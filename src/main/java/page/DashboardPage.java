package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		
	}

	@FindBy(how=How.XPATH, using="//*[@id=\"page-wrapper\"]/div[2]/div/h2")WebElement Dashboard_Header_Element;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/a/span[1]")WebElement Customer_Element;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")WebElement AddCustomer_Menu_Element;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")WebElement List_Customer_Menu_Element;



	public void validateDashBoardPage() {
		Assert.assertTrue(Dashboard_Header_Element.isDisplayed(), "Dashboard Page not Found!!");
	}
	public void clickCustomerMenuElement() {
		Customer_Element.click();
	}
	public void clickAddCustomerMenuElement() {
		AddCustomer_Menu_Element.click();
	}
	public void clickListAddCustomerMenuElement() {
		List_Customer_Menu_Element.click();
	}
}
