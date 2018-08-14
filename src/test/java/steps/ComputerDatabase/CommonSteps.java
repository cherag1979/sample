package steps.ComputerDatabase;


import java.io.IOException;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;

public class CommonSteps {

	util.PageHelper commonPage;
	

	@Step
	@Given("^I click on (.*) button$")
    public void clickButton(String text) throws IOException {
		commonPage.clickElementByButtonText(text);
	}
	
	@Step
	@Given("^I click on (.*) link$")
    public void clickLink(String text) throws IOException {
		commonPage.clickElementByLinkText(text);
	}
	
	@Step
	@Given("^I should see (.*) on the screen$")
    public void verifyText(String text) throws IOException {
		Assert.assertTrue(commonPage.isElementVisibleByLinkText(text));	
	}
	
	@Step
	@Given("^I should not see (.*) on the screen$")
    public void verifyTextNotDisplayed(String text) throws IOException {
		Assert.assertFalse(commonPage.isElementVisibleByLinkText(text));	
	}
	
	

}
