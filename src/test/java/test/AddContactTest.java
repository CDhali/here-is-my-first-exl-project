package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {

	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\TestData.xlsx");
	String username = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "password", 2);
	String dashbordHeaderVarify = exlRead.getCellData("DashBoard", "dashboard_Header", 2);
	String addcontactpage = exlRead.getCellData("AddContactInfo", "ADDCONTACTHEADER", 2);
    String fullname = exlRead.getCellData("AddContactInfo", "FULLNAME", 2);
    String companyName = exlRead.getCellData("AddContactInfo", "COMPANYNEME", 2);
    String email = exlRead.getCellData("AddContactInfo", "EMAIL", 2);
    String phone = exlRead.getCellData("AddContactInfo", "PHONE", 2);
    String address = exlRead.getCellData("AddContactInfo", "ADDRESS", 2);
    String city = exlRead.getCellData("AddContactInfo", "CITY", 2);
    String country = exlRead.getCellData("AddContactInfo", "COUNTRY", 2);
    String state = exlRead.getCellData("AddContactInfo", "STATE", 2);
    String zip = exlRead.getCellData("AddContactInfo", "ZIP", 2);
    String varifyContacPage = exlRead.getCellData("AddContactInfo", "VARIFYCONTACTPAGE", 2);
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {

		driver = BrowserFactory.init();

		LoginPage logpage = PageFactory.initElements(driver, LoginPage.class);      
		logpage.insertUsername(username);
		logpage.insertPassword(password);
		logpage.clickSignINButton();
		
		DashboardPage dashpage = PageFactory.initElements(driver, DashboardPage.class );
		dashpage.validateDashboardPage(dashbordHeaderVarify);;
		dashpage.clickCustomerMenuButtom();
		dashpage.clickAddCustomerMenuButton();
	
		AddContactPage addcontactpg = PageFactory.initElements(driver, AddContactPage.class);
		addcontactpg.validateAddContactPage(addcontactpage);
		addcontactpg.insertFullName(fullname);
		addcontactpg.selectCompany(companyName);
		addcontactpg.insertEmail(email);
		addcontactpg.insertPhone(phone);
		addcontactpg.insertAddress(address);
		addcontactpg.insertCity(city);
		addcontactpg.selectCountry(country);
		addcontactpg.insertState(state);
		addcontactpg.insertZipCode(zip);
		addcontactpg.clickSaveButton();
		addcontactpg.contactPageVarify(varifyContacPage);
	}

}
