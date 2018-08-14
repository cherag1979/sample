package pages.JSAlerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import util.PageHelper;

@DefaultUrl("https://the-internet.herokuapp.com/javascript_alerts")
public class AlertsPage extends PageObject{
	
	PageHelper helper;
	public static final String ALERT_TRIGGER_TEXT = "Click for JS Alert";
	public static final String CONFIRM_TRIGGER_TEXT = "Click for JS Confirm";
	public static final String PROMPT_TRIGGER_TEXT = "Click for JS Prompt";

	
	@FindBy(id="result") WebElementFacade resultMessage;

	
	public AlertsPage (WebDriver driver) {
		super(driver);
	}
	
//	@WhenPageOpens
//	public void waitUntilPageIsOpened() {
//		resultMessage.waitUntilVisible();
//	}
	
	
	public void selectAlert(String alertType) {
		switch(alertType) {
		case "js alert":
			helper.clickElementByButtonText(ALERT_TRIGGER_TEXT);
			try {Thread.sleep(2000);} catch(Exception e) {}
			break;
		case "js confirm":
			helper.clickElementByButtonText(CONFIRM_TRIGGER_TEXT);
			try {Thread.sleep(2000);} catch(Exception e) {}
			break;
		case "js prompt":
			helper.clickElementByButtonText(PROMPT_TRIGGER_TEXT);
			try {Thread.sleep(2000);} catch(Exception e) {}
			break;
		}
	}
	
	public boolean assertAlertTextContains (String text) {
		if(getAlert().getText().trim().contains(text)) {
			return true;
		}
		else {
			System.out.println("Alert text >> " + getAlert().getText());
			return false;
		}
	}
	
	public void acceptAlert() {
		getAlert().accept();
	}
	
	public void dismissAlert() {
		getAlert().dismiss();
	}
	
	public void inputAlertPrompt(String text) {
		getAlert().sendKeys(text);
	}
	
	public boolean assertResultText (String text) {
		if(resultMessage.getText().contains(text)) {
			return true;
		}
		else {
			return false;
		}
	}

}
