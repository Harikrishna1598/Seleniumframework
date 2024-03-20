package ProjectTesting.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ProjectTesting.AbstractComponents.AbstractMethods;

public class LandingPage extends AbstractMethods{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement submit;
	

	public ProductPage logIn(String userEmail, String userPassword) {
		email.sendKeys(userEmail);
		password.sendKeys(userPassword);
		submit.click();
		ProductPage productPage = new ProductPage(driver);
		return productPage;
	}

	public void reachWebsite() {
		driver.get("https://www.saucedemo.com/");
		
	}

}
