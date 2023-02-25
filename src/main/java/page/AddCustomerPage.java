package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]")
	WebElement AddContact_Header_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FullName_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement Company_DropDown_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement Email_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement Ph_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement State_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement Zip_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement Country_DropDown_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement Save_Button_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement City_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement Address_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement Summery_Element;

	public void validateAddContactPage() {

		Assert.assertTrue(AddContact_Header_Element.isDisplayed(), "AddContact Page Not Found!!");
	}

	String insertedName;

	public void insertFullName(String fullName) {

		insertedName = fullName + generateRandomNum(999);
		FullName_Element.sendKeys(insertedName);
		System.out.println("===========" + insertedName);
	}

	public void insertEmail(String mail) {
		Email_Element.sendKeys(generateRandomNum(999) + mail);

	}

	public void selectCompany(String company) {

		selectFromDropDown(Company_DropDown_Element, company);
	}

	public void insertPhone(String phone) {
		Ph_Element.sendKeys(generateRandomNum(999) + phone);
	}

	public void insertState(String state) {
		State_Element.sendKeys(state);
	}

	public void insertZip(String zip) {
		Zip_Element.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropDown(Country_DropDown_Element, country);
	}

	public void saveButton() {
		Save_Button_Element.click();
		;
	}

	public void insertCity(String city) {
		City_Element.sendKeys(city);
	}

	public void insertAddress(String address) {
		Address_Element.sendKeys(address);
	}

	public void validateProfilePage() {
		waitForElement(driver, 5, AddContact_Header_Element);

		Assert.assertTrue(Summery_Element.isDisplayed(), "Profile page is not found!!");
	}

////tbody/tr[1]/td[3]
////tbody/tr[2]/td[3]
////tbody/tr[3]/td[3]
////tbody/tr[1]/td[7]/a[2]
	String after_xpath_delete = "]/td[8]/a[2]";

	String before_Xpath = "//tbody/tr[";
	String after_Xpath = "]/td[3]";

	public void validateInsertedNameAndDeleteOriginal() {

		String title = driver.getTitle();

		System.out.println("Title : " + title);

		String finalXpath;
		for (int i = 1; i <= 5; i++) {
			finalXpath = before_Xpath + i + after_Xpath;
			System.out.println(i + " ,  finalXpath : " + finalXpath);

			String name = driver.findElement(By.xpath(finalXpath)).getText();
			System.out.println(name);
			if (name.contains(insertedName)) {
				// driver.findElement(By.xpath (before_Xpath+i+after_xpath_delete)).click();
				driver.findElement(By.xpath(
						"/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]"))
						.click();

			}

		}
		
	
	}
	public void TestAlert() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
		Thread.sleep(2000);
		String getTextMsg=driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();
		System.out.println(getTextMsg);
	}


}
