package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage extends PageObjectBase {
	static WebDriver driver;

	private By firstNameText = By.xpath("//input[@id='first_16']");
	private By lastNameText = By.xpath("//input[@id='last_16']");
	private By eMailText = By.xpath("//input[@id='input_17']");
	private By roomTypeDropDown = By.xpath("//*[@id='cid_6']");
	private By numberOfGaust = By.xpath("//input[@id='input_18']");
	private By arrivalDate = By.xpath("//input[@id='lite_mode_22']");
	private By hourArrivalTimedDropDown = By.xpath("//select[@id='hour_22']");
	private By minutesArrivalTimeDropdown = By.xpath("//select[@id='min_22']");
	private By ampmArrivalTimeDropDown = By.xpath("//select[@id='ampm_22']");
	private By monthDepartureDropDown = By.xpath("//select[@id='input_20_month']");
	private By dayDepartureDropDown = By.xpath("//select[@id='input_20_day']");
	private By yearDepartureDropDown = By.xpath("//select[@id='input_20_year']");
	private By yesFreePickUpRadio = By.xpath("//label[@id='label_input_10_0']");
	private By noFreePickUpRadio = By.xpath("//label[@id='label_input_10_1']");
	private By flightNumberText = By.xpath("//input[@id='input_28']");
	private By specialRequestText = By.xpath("//textarea[@id='input_30']");
	private By uploadTestFile = By.xpath("//*[contains(text(),'Browse Files')]");
	private By submitButton = By.xpath("//button[@id='input_2']");

	public BookingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}
	public BookingPage enterFirstName(String firstNameValue) {

		enterData(firstNameText, firstNameValue);
		return new BookingPage(driver);
	}

	public BookingPage enterLastname(String lastNameValue) {

		enterData(lastNameText, lastNameValue);
		return new BookingPage(driver);
	}

	public BookingPage enterEmail(String emailValue) {

		enterData(eMailText, emailValue);
		return new BookingPage(driver);
	}

	public BookingPage enterRoomType(String roomTypeValue) throws InterruptedException {

		dropDown(roomTypeDropDown, roomTypeValue);
		return new BookingPage(driver);
	}

	public BookingPage enterNumberOfGuest(String numberOfGuestValue) {

		enterData(numberOfGaust, numberOfGuestValue);
		return new BookingPage(driver);
	}

	public BookingPage enterArrivalDate(String arrivalDateValue) {

		enterData(arrivalDate, arrivalDateValue);
		return new BookingPage(driver);
	}

	public BookingPage enterArrivalHour(String arrivalHourValue) throws InterruptedException {

		dropDown(hourArrivalTimedDropDown, arrivalHourValue);
		return new BookingPage(driver);
	}

	public BookingPage enterArrivalMinute(String arrivalMinuteValue) throws InterruptedException {

		dropDown(minutesArrivalTimeDropdown, arrivalMinuteValue);
		return new BookingPage(driver);
	}

	public BookingPage enterAmpmArrivalTimeDropDown(String ampmArrivalTimeDropDownValue) throws InterruptedException {

		dropDown(ampmArrivalTimeDropDown, ampmArrivalTimeDropDownValue);
		return new BookingPage(driver);
	}

	public BookingPage enterMonthDepartureDropDown(String monthDepartureDropDownValue) throws InterruptedException {

		dropDown(monthDepartureDropDown, monthDepartureDropDownValue);
		return new BookingPage(driver);
	}

	public BookingPage enterYearDepartureDropDown(String yearDepartureDropDownValue) throws InterruptedException {

		dropDown(yearDepartureDropDown, yearDepartureDropDownValue);
		return new BookingPage(driver);
	}

	public BookingPage enterDayDepartureDropDown(String dayDepartureDropDownValue) throws InterruptedException {

		dropDown(dayDepartureDropDown, dayDepartureDropDownValue);
		return new BookingPage(driver);
	}

	public BookingPage selectFreePickUp(String pickUpRadioValue) throws InterruptedException {
		if (pickUpRadioValue.equalsIgnoreCase("yes")) {
			click(yesFreePickUpRadio);

		} else {
			click(noFreePickUpRadio);

		}
		return new BookingPage(driver);
	}

	public BookingPage enterFlightNumberText(String flightNumberTextValue) {

		enterData(flightNumberText, flightNumberTextValue);
		return new BookingPage(driver);
	}

	public BookingPage enterSpecialRequestText(String specialRequestTextValue) {

		enterData(specialRequestText, specialRequestTextValue);
		return new BookingPage(driver);
	}

	public BookingPage uploadTestFile(String uploadFilePath) throws InterruptedException {

		WebElement button = driver.findElement(uploadTestFile);
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
		Thread.sleep(2000);

		WebElement browse = driver.findElement(By.id("input_31"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", browse);

		Thread.sleep(5000);

		uploadFile(uploadFilePath);
		// uploadFile("C:\\Users\\faryan\\Desktop\\SampleFile\\Dummy.txt");
		Thread.sleep(5000);
		return new BookingPage(driver);
	}

	public BookingPage clickSubmitButton() {

		submitButton(submitButton);
		return new BookingPage(driver);
	}
}
