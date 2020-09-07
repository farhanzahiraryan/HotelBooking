package com.pages;



import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.commonclasses.DriverClass;

public class TestClassForHotelBooking {
	static WebDriver driver;

	@BeforeMethod
	public void beforeSuite() {
		driver = DriverClass.getDriver("chrome");
	}

	@Test
	public void zHappyPath() throws InterruptedException {

		driver.get("https://form.jotform.com/fouritest/hotel-booking-form");

		BookingPage bp = new BookingPage(driver);
		bp.enterFirstName("Farhan").enterLastname("Aryan").enterEmail("farhan@yahoo.com")
				.enterRoomType("Mix Dorm Room (6 People)").enterNumberOfGuest("5").enterArrivalDate("05-01-2020")
				.enterArrivalHour("8").enterArrivalMinute("20").enterAmpmArrivalTimeDropDown("AM")
				.enterMonthDepartureDropDown("May").enterDayDepartureDropDown("17").enterYearDepartureDropDown("2020")
				.selectFreePickUp("Yes").enterFlightNumberText("Flight112")
				.enterSpecialRequestText("No Special Request")
				.uploadTestFile("C:\\Users\\faryan\\Desktop\\SampleFile\\Dummy.txt").clickSubmitButton();
		
		// //*[text()=' This field is required.']

	}
	
	@Test
	public void NegativeCaseToFindoutAllRequiredFeilds() throws InterruptedException {

		driver.get("https://form.jotform.com/fouritest/hotel-booking-form");

		BookingPage bp = new BookingPage(driver);
		bp.clickSubmitButton();
		
		List<WebElement> errorwithMandatoryFields  = driver.findElements(By.xpath("//*[text()=' This field is required.']"));
		System.out.println(errorwithMandatoryFields.size());
		
		if(errorwithMandatoryFields.size()>=4) {
			assertTrue(true);
		}
		
		else {
			assertTrue(false);	
		}
		

	}


	@AfterMethod
	public void afterSuite() {
		DriverClass.quitDriver();

	}

}
