package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddContactPage extends BasePage{

	WebDriver driver;

	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h5[text()='Add Contact']")
	WebElement ADD_CONTACT_HEADER_ElEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULLNAME_ElEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_ElEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ElEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ElEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_ElEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_ElEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_ElEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_CODE_ElEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id = 'country']")
	WebElement COUNTRY_ElEMENT;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	WebElement TAGS_ElEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SAVE_BUTTON_ElEMENT;
	@FindBy(how = How.XPATH,using = "//th[text()='Accounting Summary']")
	WebElement VARIFY_CONTACT_PAGE;
	

	public void validateAddContactPage(String addContact) {
		Assert.assertEquals(ADD_CONTACT_HEADER_ElEMENT.getText(), addContact, "Wrong Page!!");
	}

	public void insertFullName(String fullName) {
		FULLNAME_ElEMENT.sendKeys(fullName + generateRandomNo(999));
	}

	public void selectCompany(String company) {
		selectFromDropdown(COMPANY_ElEMENT, company);
	}
	
	public void insertEmail(String email) {
		EMAIL_ElEMENT.sendKeys(generateRandomNo(999) + email);
	}
	
	public void insertPhone(String phone) {
		PHONE_ElEMENT.sendKeys(phone + generateRandomNo(9999999));
	}

	public void insertAddress(String address) {
		ADDRESS_ElEMENT.sendKeys(generateRandomNo(9999) + address);
	}
	
	public void insertCity(String city) {
		CITY_ElEMENT.sendKeys(city);
	}
	
	public void insertState(String state) {
		STATE_ElEMENT.sendKeys(state);
	}
	
	public void insertZipCode(String zipcode) {
		ZIP_CODE_ElEMENT.sendKeys(zipcode + "-" + generateRandomNo(9999));
	}
	
	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_ElEMENT, country);
	}
	
	public void insertTags(String tags) {
		TAGS_ElEMENT.sendKeys("@" + tags + generateRandomNo(99));
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ElEMENT.click();
	}
	public void contactPageVarify(String contactpagevarify) {
		Assert.assertEquals(VARIFY_CONTACT_PAGE.getText() , contactpagevarify, "worng page");
	}
}
