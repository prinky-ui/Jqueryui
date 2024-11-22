package jqueryui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	public String baseUrl = "https://jqueryui.com/datepicker/";
	WebDriver driver = new ChromeDriver();
	int date = 12;
	
	public void lunchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	public void date() throws InterruptedException{
		WebElement dateclick = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(dateclick);
		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		String text = driver.findElement(By.xpath("//span[text()='December']")).getText();
		System.out.println("The Selected month on the console is:" +text);
		driver.findElement(By.xpath("//a[@data-date='" +date+ "']")).click();
		System.out.println("The Selected dte on the console is: " +date);
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		DatePicker datepicker  = new DatePicker();
		datepicker.lunchApp();
		datepicker.date();
	}

}
