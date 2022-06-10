package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LogingTest {
	WebDriver driver;
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\TestData.xlsx");
	String username = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "password", 2);
	String dashbordHeaderVarify = exlRead.getCellData("DashBoard", "dashboard_Header", 2);
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUsername(username);
		loginpage.insertPassword(password);
		loginpage.clickSignINButton();
		
		DashboardPage dashpage = PageFactory.initElements(driver, DashboardPage.class );
		dashpage.validateDashboardPage(dashbordHeaderVarify);;
		
		BrowserFactory.tearDown();
}
}