package pages.ComputerDatabase;

import beans.Computer;
import cucumber.api.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;

public class ComputerDetailsPage extends PageObject {
	
	@FindBy(id="name") WebElementFacade computerNameInput;
	@FindBy(id="introduced") WebElementFacade introducedDateInput;
	@FindBy(id="discontinued") WebElementFacade discontinuedDateInput;
	@FindBy(id="company") WebElementFacade companySelect;
	@FindBy(css="input.btn.primary") WebElementFacade submitButton;
	@FindBy(css="input.btn.danger") WebElementFacade deleteButton;
	@FindBy(linkText="Cancel") WebElementFacade cancelButton;

	
	public void inputDetails (Computer computer) {
		inputComputerName(computer.getName());
		inputIntroducedDate(computer.getIntroducedDate());
		inputDiscontinuedDate(computer.getDiscontinuedDate());
		inputCompany(computer.getCompany());
	}
	
	public void inputComputerName (String name) {
		typeInto(computerNameInput,name);
	}
	
	public void inputIntroducedDate (String introducedDate) {
		typeInto(introducedDateInput,introducedDate);
	}

	public void inputDiscontinuedDate (String discontinuedDate) {
		typeInto(discontinuedDateInput,discontinuedDate);
	}

	public void inputCompany (String company) {
		companySelect.selectByVisibleText(company);
	}

	public void saveDetails () {
		submitButton.click();
	}
	
	public void cancel () {
		cancelButton.click();
	}
	
	public boolean onDetailsPage () {
		return submitButton.isVisible();
	}
	
	
	public void deleteComputer () {
		deleteButton.click();
	}
	
	public void verifyDetails (DataTable expectedComputerDetailsTable) {
		Computer actualComputerDetails = new Computer();
		actualComputerDetails.setName(computerNameInput.getValue());
		actualComputerDetails.setIntroducedDate(introducedDateInput.getValue());
		actualComputerDetails.setDiscontinuedDate(discontinuedDateInput.getValue());
		actualComputerDetails.setCompany(companySelect.getSelectedVisibleTextValue());
	
		List<String> headers = expectedComputerDetailsTable.topCells();
		List<List<String>> actual_values = Arrays.asList(headers,
		Arrays.asList(actualComputerDetails.getName(),
				actualComputerDetails.getIntroducedDate(),
				actualComputerDetails.getDiscontinuedDate(),
				actualComputerDetails.getCompany()));
		
		DataTable actualComputerDetailsTable = DataTable.create(actual_values,  
									headers.get(0), 
									headers.get(1), 
									headers.get(2), 
									headers.get(3));
		
		expectedComputerDetailsTable.diff(actualComputerDetailsTable);
	}

}
