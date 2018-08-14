package pages.ComputerDatabase;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("http://computer-database.herokuapp.com/computers")
public class ComputerListPage extends PageObject{
	
	@FindBy(id="searchbox") WebElementFacade computerSearchInput;
	@FindBy(id="searchsubmit") WebElementFacade computerSearchButton;
	@FindBy(id="add") WebElementFacade addComputerButton;
	@FindBy(linkText="Next →") WebElementFacade nextButton;
	@FindBy(css="div.alert-message.warning") WebElementFacade alertMessage;


	
	public ComputerListPage (WebDriver driver) {
		super(driver);
	}
	
	@WhenPageOpens
	public void waitUntilPageIsOpened() {
		computerSearchButton.waitUntilVisible();
	}
	
	public void filterComputerByName (String name) {
		typeInto(computerSearchInput,name);
		computerSearchButton.click();
	}
	
	public boolean assertComputerInList (String name) {
		return getDriver().findElement(By.linkText(name)).isDisplayed();
	}
	
	public void selectComputer (String name) {
		filterComputerByName(name);
		getDriver().findElement(By.linkText(name)).click();
	}
	
	public void addComputer() {
		addComputerButton.click();
	}
	
	public boolean alertMessageContainsText (String message) {
		if(alertMessage.getText().contains(message)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isComputerAdded () {
		return alertMessageContainsText("has been created");
	}
	
	public boolean isComputerUpdated () {
		return alertMessageContainsText("has been updated");
	}
	
	public boolean isComputerDeleted () {
		return alertMessageContainsText("Computer has been deleted");
	}
	

}
