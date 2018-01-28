package base;

import cucumber.api.Scenario;
import testng.CukesTest;

public class StepDefs extends BaseStepDefs {
	
	public StepDefs(CukesTest test) {
		super(test);
		Given("^Ready to test$", () -> {
			getDriver().get("https://www.google.com/");
		});

		When("^I test$", () -> {
		});

		Then("^It should successfull$", () -> {
		});

		Given("^Ready to (\\d+)$", (Integer arg1) -> {
		});
	}
	
	@cucumber.api.java.Before
	public void beforeScenario(Scenario scenario) {
		before(scenario);
	}
	

	/**
	 * After scenario
	 * 
	 * @param scenario
	 */
	@cucumber.api.java.After
	public void afterScenario(Scenario scenario) {
		after(scenario);
	}	
}
