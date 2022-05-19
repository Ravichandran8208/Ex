package Ex;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonopen extends Baseforamazon {
	@BeforeTest
	public void set() {


		testName ="loginAmazon";
		testDescription="Checking amazon login functionality";
		testCategory="smoke";
		testAuthor="hari";
	}
	@Test
	public void method() throws Exception {
		String url="http://leaftaps.com/opentaps";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();


		driver.get(url);


		try {
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			reportStep(" Username is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("Username is not entered successfully "+e, "fail");
		} 
		try {
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			reportStep(" password is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("password is not entered successfully", "fail");
		} 
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Login button is clicked", "pass");
		} catch (Exception e) {
			reportStep("Login button is not clicked", "fail");
		}


	}
}
