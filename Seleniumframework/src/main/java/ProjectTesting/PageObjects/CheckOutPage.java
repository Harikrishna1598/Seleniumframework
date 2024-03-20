package ProjectTesting.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ProjectTesting.AbstractComponents.AbstractMethods;

public class CheckOutPage extends AbstractMethods {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "first-name")
	WebElement firstNameField;

	@FindBy(id = "last-name")
	WebElement lastNameField;

	@FindBy(id = "postal-code")
	WebElement zipCodeField;

	@FindBy(id = "continue")
	WebElement submit;

	public void fillDetails(String userFirstName, String userLastName, String userZipcode) {

		firstNameField.sendKeys(userFirstName);
		lastNameField.sendKeys(userLastName);
		zipCodeField.sendKeys(userZipcode);
	}

	public ConfirmationPage proceed() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		if (firstNameField.getText().contains("") && lastNameField.getText().contains("")
				&& zipCodeField.getText().contains(""))
			submit.click();

		ConfirmationPage page = new ConfirmationPage(driver);
		return page;

	}

}
