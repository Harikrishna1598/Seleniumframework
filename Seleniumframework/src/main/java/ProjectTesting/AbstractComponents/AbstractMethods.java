package ProjectTesting.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ProjectTesting.PageObjects.CartPage;

public class AbstractMethods {

	WebDriver driver;

	public AbstractMethods(WebDriver driver) {

		this.driver = driver;
	}

	public void waitForElementToAppear(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement cart;

	public CartPage goToCart()

	{
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
