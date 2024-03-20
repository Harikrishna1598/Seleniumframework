package ProjectTesting.PageObjects;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ProjectTesting.AbstractComponents.AbstractMethods;

public class ConfirmationPage extends AbstractMethods {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cart_item_label']/a/div")
	WebElement product;

	@FindBy(xpath = "//div[@class='item_pricebar']/div")
	WebElement productPrice;

	@FindBy(className = "summary_tax_label")
	WebElement taxRate;

	String actualProduct = "$29.99";

	public Boolean verifyProductInConfirmation(String verifyProduct) {
		Boolean confirmedProduct = product.getText().equalsIgnoreCase(verifyProduct);
		return confirmedProduct;

	}

	public boolean verifyProductPrize() {
		boolean price = productPrice.getText().contains(actualProduct);
		return price;

	}
}
