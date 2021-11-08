package week5.day1.assignment1;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends BaseClass {
	@Test
	public  void runUpdateIncident() {

		// public void runUpdateIncident() {
		// TODO Auto-generated method stub
	
		driver.findElementByXPath("//span[text()='Service Desk']/parent::a/following::ul//div[text()='Incidents']")
				.click();

		driver.switchTo().frame("gsft_main");
		Select sl = new Select(driver.findElementByXPath("//div[@class='input-group']//select"));
		sl.selectByValue("number");
		driver.findElementByXPath("//div[@class='input-group']//input[@placeholder='Search']").sendKeys("INC0010047",
				Keys.ENTER);
		driver.findElementByXPath("//a[@class='linked formlink']").click();

		Select s2 = new Select(driver.findElementById("incident.urgency"));
		s2.selectByValue("1");

		Select s3 = new Select(driver.findElementById("incident.state"));
		s3.selectByValue("2");
		String expectedState= s3.getFirstSelectedOption().getText();
		Select s4 = new Select(driver.findElementById("incident.priority"));
		String priority=s4.getFirstSelectedOption().getText();
		driver.findElementById("sysverb_update").click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='input-group']//input[@placeholder='Search']")));

		/*WebElement table = driver.findElementByXPath("//table[@id='incident_table']/tbody");
		List<WebElement> row = table.findElements(By.tagName("tr"));
		WebElement firstRow =row.get(0);
		List<WebElement> col = firstRow.findElements(By.tagName("td"));

		String Expectedstate = "In Progress";

		for (WebElement column : col) {
		if(column.getText().equals(Expectedstate)){
				System.out.println("state is verified");
		
			}
		}*/
		String priority1= driver.findElementByXPath("//table[@id='incident_table']//tr[1]/td[7]").getText();
		
		String state1= driver.findElementByXPath("//table[@id='incident_table']//tr[1]/td[8]").getText();
		System.out.println(priority+""+expectedState);
		if (priority1.equals(priority))
		{
			System.out.println("verified priority");}
		else 
			System.out.println("priority not verified");
		if(expectedState.equals(state1))
			{System.out.println("verified state");}
		else 
			System.out.println("state not verified");
	}
}


