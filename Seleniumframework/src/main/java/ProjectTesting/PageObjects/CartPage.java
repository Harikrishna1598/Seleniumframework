package ProjectTesting.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ProjectTesting.AbstractComponents.AbstractMethods;

public class CartPage extends AbstractMethods {

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cart_item_label'] /a /div")
	WebElement cartProduct;
	WebDriver driver;

	@FindBy(id = "checkout")
	WebElement checkOutButton;

	public Boolean verifyproduct(String myProductTest) {
		boolean result = cartProduct.getText().equalsIgnoreCase(myProductTest);
		return result;
	}

	public CheckOutPage goToCheckOut() {
		checkOutButton.click();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}

}
