package tests;

import static org.testng.Assert.assertTrue;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SourceFuseTest {
	
    private WebDriver driver;

	@BeforeTest
	public void LoginInToApplication() {
		System.out.print("Start =>");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91817\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(" http://sfwebhtml:t63KUfxL5vUyFLG4eqZNUcuRQ@sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterTest
	public void closeTheBrowser() {
		driver.quit();
	}
	
	
	@Test(description = "Try to submit without filling required fields and Labels of all the required fields printed on Console.")
	public void gettingAllRequiredFieldLabels() {
		
		List<WebElement> requiredFieldLabels = driver.findElements(By.xpath("//span[@class=\"required\"]/parent::label"));
		System.out.println(requiredFieldLabels.size());
		for(WebElement ele:requiredFieldLabels) {
			System.out.println(ele.getText());
		}
		
	}
	
	
	@Test(description = "Submit the form after filling all details properly by using XPath only")
	public void SubmitingForm() {
		
		WebElement firstName = driver.findElement(By.xpath("//div[@id='fnameInput']/input"));
		WebElement lastName =driver.findElement(By.xpath("//div[@id='lnameInput']/input"));
		WebElement email = driver.findElement(By.xpath("//div[@id='emailInput']/input"));
		WebElement currentCompany = driver.findElement(By.xpath("//div[@id='curCompanyInput']/input"));
		WebElement mobileNumber = driver.findElement(By.xpath("//div[@id='mobInput']/input"));
		WebElement dateOfBirth = driver.findElement(By.xpath("//div[@class='input-group date']/input"));
		WebElement position = driver.findElement(By.xpath("//div[@id='positionInput']/input"));
		WebElement requiredSalary = driver.findElement(By.xpath("//div[@id='salaryInput']/input"));
		WebElement portfolio = driver.findElement(By.xpath("//div[@id='portfolioInput']/input"));
		WebElement startTime = driver.findElement(By.xpath("//div[@id='whenStartInput']/input"));
		WebElement yesRadioButton = driver.findElement(By.id("yes"));
		WebElement UploadFIle = driver.findElement(By.xpath("//input[@type='file']"));
		WebElement SubmitButton = driver.findElement(By.xpath("//button[text()='Submit Form']"));
		
		firstName.sendKeys("Masthanvali");
		lastName.sendKeys("Shaik");
		email.sendKeys("MasthanvaliSMVVALi@gmail.com");
		currentCompany.sendKeys("QualitLabs");
		mobileNumber.sendKeys("8179705706");
		dateOfBirth.sendKeys("02/01/2021");
		position.sendKeys("Automation Test Engineer");
		requiredSalary.sendKeys("700000");
		portfolio.sendKeys("Google.com");
		startTime.sendKeys("in 2 months");
		UploadFIle.sendKeys("C:\\Users\\91817\\Desktop\\pics\\48406048_798899623786569_4400480782603255808_o.jpg");
		yesRadioButton.click();
		SubmitButton.click();

	}
	
	@Test(description = "Verify all input fields using hard assertion")
	public void hardAssertion() {
		
		WebElement firstName = driver.findElement(By.xpath("//div[@id='fnameInput']/input"));
		assertTrue(firstName.isDisplayed(), "First name input field is not getting displayed");
		assertTrue(firstName.isEnabled(), "First name input field is not getting enabled");
		
		WebElement lastName = driver.findElement(By.xpath("//div[@id='lnameInput']/input"));
		assertTrue(lastName.isDisplayed(), "Last name input field is not getting displayed");
		assertTrue(lastName.isEnabled(), "Last name input field is not getting enabled");
		
		WebElement email = driver.findElement(By.xpath("//div[@id='emailInput']/input"));
		assertTrue(email.isDisplayed(), "email  input field is not getting displayed");
		assertTrue(email.isEnabled(), "email  input field is not getting enabled");
		
		WebElement currentCompany = driver.findElement(By.xpath("//div[@id='curCompanyInput']/input"));
		assertTrue(currentCompany.isDisplayed(), "current Company input field is not getting displayed");
		assertTrue(currentCompany.isEnabled(), "current Company input field is not getting enabled");
		
		WebElement mobileNumber = driver.findElement(By.xpath("//div[@id='mobInput']/input"));
		assertTrue(mobileNumber.isDisplayed(), "mobile number input field is not getting displayed");
		assertTrue(mobileNumber.isEnabled(), "Mobile number input field is not getting enabled");
		
		WebElement dateOfBirth = driver.findElement(By.xpath("//div[@class='input-group date']/input"));
		assertTrue(dateOfBirth.isDisplayed(), "date of birth input field is not getting displayed");
		assertTrue(dateOfBirth.isEnabled(), "date of irth input field is not getting enabled");
		
		WebElement position = driver.findElement(By.xpath("//div[@id='positionInput']/input"));
		assertTrue(position.isDisplayed(), "Position input field is not getting displayed");
		assertTrue(position.isEnabled(), "Position input field is not getting enabled");
		
		WebElement portfolio = driver.findElement(By.xpath("//div[@id='portfolioInput']/input"));
		assertTrue(portfolio.isDisplayed(), "Portfolio input field is not getting displayed");
		assertTrue(portfolio.isEnabled(), "Portfolio input field is not getting enabled");
		
		WebElement startTime = driver.findElement(By.xpath("//div[@id='whenStartInput']/input"));
		assertTrue(startTime.isDisplayed(), "Start time input field is not getting displayed");
		assertTrue(startTime.isEnabled(), "Start time input field is not getting enabled");
	}
	
	@Test(description = "Verify all input fields using Soft assertion")
	public void softAssertion() {
		SoftAssert softAssert = new SoftAssert();
		
		WebElement firstName = driver.findElement(By.xpath("//div[@id='fnameInput']/input"));
		softAssert.assertTrue(firstName.isDisplayed(), "First name input field is not getting displayed");
		softAssert.assertTrue(firstName.isEnabled(), "First name input field is not getting enabled");
		
		WebElement lastName = driver.findElement(By.xpath("//div[@id='lnameInput']/input"));
		softAssert.assertTrue(lastName.isDisplayed(), "Last name input field is not getting displayed");
		softAssert.assertTrue(lastName.isEnabled(), "Last name input field is not getting enabled");
		
		WebElement email = driver.findElement(By.xpath("//div[@id='emailInput']/input"));
		softAssert.assertTrue(email.isDisplayed(), "email  input field is not getting displayed");
		softAssert.assertTrue(email.isEnabled(), "email  input field is not getting enabled");
		
		WebElement currentCompany = driver.findElement(By.xpath("//div[@id='curCompanyInput']/input"));
		softAssert.assertTrue(currentCompany.isDisplayed(), "current Company input field is not getting displayed");
		softAssert.assertTrue(currentCompany.isEnabled(), "current Company input field is not getting enabled");
		
		WebElement mobileNumber = driver.findElement(By.xpath("//div[@id='mobInput']/input"));
		softAssert.assertTrue(mobileNumber.isDisplayed(), "mobile number input field is not getting displayed");
		softAssert.assertTrue(mobileNumber.isEnabled(), "Mobile number input field is not getting enabled");
		
		WebElement dateOfBirth = driver.findElement(By.xpath("//div[@class='input-group date']/input"));
		softAssert.assertTrue(dateOfBirth.isDisplayed(), "date of birth input field is not getting displayed");
		softAssert.assertTrue(dateOfBirth.isEnabled(), "date of irth input field is not getting enabled");
		
		WebElement position = driver.findElement(By.xpath("//div[@id='positionInput']/input"));
		softAssert.assertTrue(position.isDisplayed(), "Position input field is not getting displayed");
		softAssert.assertTrue(position.isEnabled(), "Position input field is not getting enabled");
		
		WebElement portfolio = driver.findElement(By.xpath("//div[@id='portfolioInput']/input"));
		softAssert.assertTrue(portfolio.isDisplayed(), "Portfolio input field is not getting displayed");
		softAssert.assertTrue(portfolio.isEnabled(), "Portfolio input field is not getting enabled");
		
		WebElement startTime = driver.findElement(By.xpath("//div[@id='whenStartInput']/input"));
		softAssert.assertTrue(startTime.isDisplayed(), "Start time input field is not getting displayed");
		softAssert.assertTrue(startTime.isEnabled(), "Start time input field is not getting enabled");
		
		softAssert.assertAll();
	}
}
