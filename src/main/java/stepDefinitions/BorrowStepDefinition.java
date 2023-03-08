package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BorrowStepDefinition{

	String sURL = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/";
	WebDriver driver;
	
	 @Given("^Launch the application$")
	 public void launch_the_application() {
		 System.setProperty("webdriver.chrome.driver", "C:\\GIT\\NAuto\\Cucumber-TestNG\\src\\main\\java\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get(sURL);
		 driver.manage().window().maximize();
	 }
	 
	 @When("^I click the \"([^\"]*)\"$")
	 public void i_click_the(String arg1){
	     driver.findElement(By.xpath("//*[@id='"+arg1+"']")).click(); 
	 }
	 
	 @And("^I select the \"([^\"]*)\" with \"([^\"]*)\"$")
	 public void i_select_the_with(String arg1, String arg2) {
		 WebElement wDependents = driver.findElement(By.xpath("//select[contains(@title,'"+arg1+"')]"));
		 Select select = new Select (wDependents);
		 select.selectByVisibleText(arg2);
	 }

	 @When("^I fill the \"([^\"]*)\" with \"([^\"]*)\"$")
	 public void i_fill_the_with(String arg1, String arg2) {
		 driver.findElement(By.xpath("//label[contains(text(),'"+arg1+"')]/following-sibling::div//input")).sendKeys(arg2);
	 }
	
	 @Then("^Validate the estimate amount$")
	 public void validate_the_estimate_amount() {
		 Assert.assertFalse(driver.findElement(By.xpath("//h3[@class='homeloan__borrow__text']/following-sibling::span[@id='borrowResultTextAmount']")).getText().isEmpty());
	 }
	 
	 @Then("^Close the browser$")
	 public void close_the_browser() {
		driver.quit();
	 }
	 
	 @When("^I click the Start Over$")
	 public void i_click_the_Start_Over(){
		 driver.findElement(By.xpath("//button[@aria-label='Start over']")).click();
	 }

	 @When("^Validate the fields empty$")
	 public void validate_the_fields_empty() {
		 List<WebElement> lsFields =  driver.findElements(By.xpath("//label/following-sibling::div//input"));
		 for(WebElement field : lsFields) {
			 Assert.assertTrue(field.getText().isEmpty());
		 }
	 }
	 
	 @Then("^Validate the error message$")
	 public void validate_the_error_message() {
		 Assert.assertFalse(driver.findElement(By.xpath("//div[@class='borrow__error__text'][contains(text(), 'Based on the details')]")).getText().isEmpty());
	 }


}
