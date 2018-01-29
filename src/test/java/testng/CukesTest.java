package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(tags = "", glue = "base", features = "src/test/resources/features", plugin = "json:target/cucumber-report.json")
public class CukesTest {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true/*, dependsOnMethods = "initializeConfig"*/)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

/*	@BeforeMethod(alwaysRun = true, dependsOnMethods = "initializeTest")
	public void before() {

	}*/

	@Test(dataProvider = "scenarios")
	public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
	}
	
	@DataProvider
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}

/*	@Override
	public String getTestName() {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected DriverFactory initPrimaryDriverFactory() {
		return (DriverFactory) new WebDriverFactory<WebDriver>(testConfig);
	}*/
}
