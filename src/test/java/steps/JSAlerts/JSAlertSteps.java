package steps.JSAlerts;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import pages.JSAlerts.AlertsPage;

public class JSAlertSteps {

	AlertsPage alertsPage;
	
	@Step
	@Given("^I open alerts web app$")
    public void iOpenApp() {
		alertsPage.open();
    }
	
	@Step
	@Given("^I click on (.*)$")
    public void iSelectAlert(String alertType) {
		alertsPage.selectAlert(alertType);
    }
	
	
	@Step
	@Given("^I (accept|dismiss) the alert$")
    public void iAcceptOrDismiss(String action) {
		switch(action) {
		case "accept":
			alertsPage.acceptAlert();
			break;
		case "dismiss":
			alertsPage.dismissAlert();
			break;
		}
    }
	
	
	@Step
	@Given("^I input '(.*)' in the alert prompt$")
    public void iInputInAlertPrompt(String text) {
		alertsPage.inputAlertPrompt(text);
    }
	
	@Step
	@Given("^I should see alert with message '(.*)'$")
    public void assertAlertTextContains(String text) {
		Assert.assertTrue(alertsPage.assertAlertTextContains(text));
    }
	
	@Step
	@Given("^result should display '(.*)'$")
    public void assertResult(String text) {
		Assert.assertTrue(alertsPage.assertResultText(text));
    }
	
}
