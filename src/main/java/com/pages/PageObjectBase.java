package com.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectBase {
	WebDriver driver;
	WebDriverWait wait = null;

	public PageObjectBase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	public void enterData(By locator, String text) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);

	}


	public void dropDown(By locator, String text) throws InterruptedException {
		 wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).click();
		//Select dropdown = new Select (driver.findElement(locator));
		//dropdown.selectByVisibleText("\"+text+\"");

		Thread.sleep(2000);
		//driver.findElement(locator).click();

		driver.findElement(By.xpath("//*[contains(text(),' "+text+" ')]")).click();
		Thread.sleep(1000);
		


	}
	
	public void click(By locator) {
		 wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).click();


	}
	
	public void submitButton(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).submit();

	}
	
	public void uploadFile(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).click();

	}
	
	public void uploadFile(String fileLocation) {
        try {
        	//Thread.sleep(20000);
        	System.out.println("after 20 seconds");
        	System.out.println(fileLocation);
           // waitFor();
            StringSelection stringSelection = new StringSelection(fileLocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            //Thread.sleep(10000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("all code ");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


	
}
