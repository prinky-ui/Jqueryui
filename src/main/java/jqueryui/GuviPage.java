package jqueryui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuviPage {
	public String baseUrl = "https://www.guvi.in/";
	WebDriver driver = new ChromeDriver() ;
		
	public void launchapp () {
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	public void signup() throws InterruptedException {
    WebElement signuppage = driver.findElement(By.xpath("//a[text()='Sign up']"));
    signuppage.click();
    driver.findElement(By.id("name")).sendKeys("Johntest");
    driver.findElement(By.id("email")).sendKeys("johntest@gmail.com");
	driver.findElement(By.id("password")).sendKeys("john@1");
	driver.findElement(By.id("mobileNumber")).sendKeys("9591997399");
	driver.findElement(By.id("signup-btn")).click();
	driver.findElement(By.className("login")).click();
	}
	public void loginpage() {
		driver.findElement(By.id("email")).sendKeys("johntest@gmail.com");
		driver.findElement(By.id("password")).sendKeys("john@1");
		driver.findElement(By.id("login-btn")).click();
		System.out.println(" "+driver.getTitle());
		driver.close();
	}
	public static void main(String[] args) throws InterruptedException {
		GuviPage guvi = new GuviPage();
		guvi.launchapp();
		guvi.signup();
		guvi.loginpage();

	}

}
