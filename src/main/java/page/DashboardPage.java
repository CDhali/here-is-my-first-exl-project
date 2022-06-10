package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")WebElement Dashboard_Header_Element;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]")WebElement CUSTOMERS_MENU_Element;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]")WebElement ADD_CUSTOMOR_MENU_Element;
	
	public void validateDashboardPage(String dashboard) {
		Assert.assertEquals(Dashboard_Header_Element.getText(), dashboard, "Wrong Page!!");
	}
	
	public void clickCustomerMenuButtom() {
		CUSTOMERS_MENU_Element.click();
	}
	
	public void clickAddCustomerMenuButton() {
		ADD_CUSTOMOR_MENU_Element.click();
	}
	
	
}
