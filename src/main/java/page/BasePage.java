package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public int generateRandomNum(int boundNum) {
		Random rnd=new Random();
		int generateNum=rnd.nextInt(boundNum);
		return generateNum;
	}
	public void selectFromDropDown(WebElement Element, String visibleText ) {
		Select sel=new Select(Element);
		sel.selectByVisibleText(visibleText);
	}
	public void waitForElement(WebDriver driver, int waitTime, WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(Element));
		
		
	}

}
