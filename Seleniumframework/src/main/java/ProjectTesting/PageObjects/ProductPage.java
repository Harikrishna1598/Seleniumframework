package ProjectTesting.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ProjectTesting.AbstractComponents.AbstractMethods;

public class ProductPage extends AbstractMethods {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='inventory_item_label']")
	List<WebElement> productList;

	By locator = By.xpath("//div[@class='inventory_item_label']");

	public WebElement chooseProduct(String productToBuy) {

		waitForElementToAppear(locator);
		WebElement desiredProduct = productList.stream()
				.filter(pro -> pro.findElement(By.tagName("a")).getText().equals(productToBuy)).findFirst()
				.orElse(null);
		return desiredProduct;
	}
	

	public void addProductToCard(String productToBuy) {
		WebElement prod = chooseProduct(productToBuy);
		prod.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).click();
	}

}
