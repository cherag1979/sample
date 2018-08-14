package steps.ComputerDatabase;

import beans.Computer;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import net.thucydides.core.annotations.Step;
import pages.ComputerDatabase.ComputerDetailsPage;
import pages.ComputerDatabase.ComputerListPage;

public class ComputerCRUDSteps {
	
	ComputerDetailsPage computerDetailsPage;
	ComputerListPage computerListPage;
	
	@Step
	@Given("^I open Computer Database app$")
    public void iOpenApp() {
		computerListPage.open();
    }
	
	@Step
	@Given("^I select to add a new computer$")
    public void iSelectAddComputer() {
		computerListPage.addComputer();
    }

	@Step
	@Given("^I add computer with below details$")
    public void iAddComputer(DataTable dataTable) {
		Computer computer = dataTable.asList(Computer.class).get(0);
		computerListPage.addComputer();
		computerDetailsPage.inputDetails(computer);
		computerDetailsPage.saveDetails();
    }
	
	@Step
	@Given("^I should not be able to add computer with below details$")
    public void iCannotAddComputer(DataTable dataTable) {
		for (int i = 0; i < dataTable.asList(Computer.class).size(); i++) {
			Computer computer = dataTable.asList(Computer.class).get(i);
			computerDetailsPage.inputDetails(computer);
			computerDetailsPage.saveDetails();
			iCannotSubmit();
		}
    }
	
	
	@Step
	@Given("^I update computer with below details$")
    public void iUpdateComputer(DataTable dataTable) {
		Computer computer = dataTable.asList(Computer.class).get(0);
		computerDetailsPage.inputDetails(computer);
		computerDetailsPage.saveDetails();
    }
	
	@Step
	@Given("^I input below computer details$")
    public void iInputWithoutSubmit(DataTable dataTable) {
		Computer computer = dataTable.asList(Computer.class).get(0);
		computerDetailsPage.inputDetails(computer);
    }
	
	@Step
	@Given("^I submit the details$")
    public void iSubmit() {
		computerDetailsPage.saveDetails();
    }
	
	
	@Step
	@Given("^I should not be able to submit successfully$")
    public void iCannotSubmit() {
		Assert.assertTrue(computerDetailsPage.onDetailsPage());
    }
	
	@Step
	@Given("^I should see the computer details as below$")
    public void iVerifyDetails(DataTable expectedComputerDetailsTable) {
		computerDetailsPage.verifyDetails(expectedComputerDetailsTable);
    }
	
	@Step
	@Given("^I delete computer (.*)$")
    public void iDeleteComputer(String name) {
		computerDetailsPage.deleteComputer();
    }
	
	
	@Step
	@Given("^I search (and select|) computer (.*)$")
    public void iSearchComputer(String selectClause, String name) {
		computerListPage.open();
		if(!selectClause.contentEquals("")) {
			computerListPage.selectComputer(name);
		}
		else {
			computerListPage.filterComputerByName(name);
		}
    }
	
	
	@Step
	@Given("^I should see computer (added|updated|deleted) alert message$")
    public void iCheckAlert(String action) {
		if(action.contentEquals("added")) {
			Assert.assertTrue(computerListPage.isComputerAdded());
		}
		else if(action.contentEquals("updated")) {
			Assert.assertTrue(computerListPage.isComputerUpdated());
		}
		else if(action.contentEquals("deleted")) {
			Assert.assertTrue(computerListPage.isComputerDeleted());
		}
    }
}
