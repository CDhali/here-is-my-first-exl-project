package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage extends BasePage {
	WebDriver driver;

	// we created a constructor to hold our driver variable, because when we use the
	// PageFactory() method we declared driver as one of the arguments
	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// element list
	 @FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']") WebElement
	 IMPORT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='List Customers']")
	WebElement LIST_CUSTOMERS_ELEMENT;
	
	public void clickListCustomer() {
		LIST_CUSTOMERS_ELEMENT.click();
	}

	public void verifyListCustomersPage(String expectedText) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(IMPORT_ELEMENT.getText(), expectedText, "Wrong page");
	}
	
	
	////tbody/tr[i]/td[3] this is not a valid xpath to make this valid we break it down nd put into in a String variable....
 public void varifyFinalPage(String Name ) {
	String before_xpath="//tbody/tr[";
   String after_xpath = "]/td[3]";
	   
   for(int i = 1;i<=5;i++) {
	  String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
	   System.out.println(name);
  
   
   if (name.contains(Name)){
	   System.out.println("name found!!");
   }
   break;
   
   }
   

 }


}


