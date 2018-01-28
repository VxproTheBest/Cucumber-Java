package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import testng.CukesTest;

public class BaseStepDefs implements En {

	private static final Logger logger = LoggerFactory.getLogger(BaseStepDefs.class);

	private final CukesTest test;

	private Scenario scenario;

	private WebDriver driver;

	public BaseStepDefs(CukesTest test) {
		this.test = test;
	}

	public void before(Scenario scenario) {
		this.scenario = scenario;
		if (getDriver() == null) {
			createWebDriver(scenario);
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void createWebDriver(Scenario scenario) {
		System.setProperty("webdriver.ie.driver", "./src/test/resources/drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver(new DesiredCapabilities().internetExplorer());
		if (driver instanceof RemoteWebDriver) {
			Reporter.getCurrentTestResult().setAttribute("webdriver.sessionID",
					((RemoteWebDriver) driver).getSessionId());
			String sauceLink = "http://saucelabs.com/jobs/" + ((RemoteWebDriver) driver).getSessionId();
			logger.info("Link to test execution in sauce labs {}", sauceLink);
		}
	}

	/*
	 * public WebDriver instantiateWebDriver() { return (WebDriver)
	 * test.getPrimaryDriverFactory().create(); }
	 */

	public void after(Scenario scenario) {
		closeWebDriver();
	}

	private void closeWebDriver() {
		driver.quit();
	}
}