package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
       this.driver=driver;
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]") WebElement Username_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement Password_Element;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement SignIn_Element;
	
//	Intractable methods
	
	public void insertUsername(String username) {
		Username_Element.sendKeys(username);
	}
	
	public void insertPassword(String password) {
		Password_Element.sendKeys(password);
	}
	
	public void clickSignINButton() {
		SignIn_Element.click();
	}
}
