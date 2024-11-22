package jqueryui;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {
	public String baseUrl = "https://jqueryui.com/datepicker/";
	WebDriver driver = new ChromeDriver();
	
	public void lunchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	public void DropableLink() {
		WebElement hyperlink = driver.findElement(By.xpath("//a[@href='https://jqueryui.com/droppable/']"));
		hyperlink.click();
		
	}
	public void DomouseActions() throws InterruptedException {
		Thread.sleep(3000);
		WebElement frameElement = driver.findElement(By.xpath("//iframe [@class='demo-frame']"));
		driver.switchTo().frame(frameElement);
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destenation = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action = new Actions(driver); 
		action.dragAndDrop(source, destenation).build().perform();
		
		String droppablecolor = driver.findElement(By.xpath("//p[text()='Dropped!']")).getCssValue("background");
		System.out.println(droppablecolor);
				
	}
	public static void main(String[] args) throws InterruptedException {
		DragandDrop draganddrop = new DragandDrop();
		draganddrop.lunchApp();
		draganddrop.DropableLink();
		draganddrop.DomouseActions();
				
	}

}
