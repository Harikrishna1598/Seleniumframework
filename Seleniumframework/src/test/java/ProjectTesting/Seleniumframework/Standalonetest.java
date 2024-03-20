package ProjectTesting.Seleniumframework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ProjectTesting.PageObjects.CartPage;
import ProjectTesting.PageObjects.CheckOutPage;
import ProjectTesting.PageObjects.ConfirmationPage;
import ProjectTesting.PageObjects.LandingPage;
import ProjectTesting.PageObjects.ProductPage;
import ProjectTesting.Testcomponents.BaseTest;

public class Standalonetest extends BaseTest {

	@Test(dataProvider = "getData")
	public void SubmitOrder(HashMap<String,String> input) throws IOException {

		// data
		//String myProduct = "Sauce Labs Backpack";

		// initializing browser and hitting URL
		LandingPage landingPage = launchApplication();
		ProductPage productPage = landingPage.logIn(input.get("emailid"), input.get("password"));

		// product adding
		productPage.addProductToCard(input.get("product"));

		// moving to card page
		CartPage cartPage = landingPage.goToCart();

		// cart page actions
		Boolean result = cartPage.verifyproduct(input.get("product"));
		Assert.assertTrue(result);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();

		// checkout actions
		checkOutPage.fillDetails("Hari", "krishna", "635802");
		ConfirmationPage confirmationPage = checkOutPage.proceed();

		// confirmationpage actions
		Boolean confirmedProduct = confirmationPage.verifyProductInConfirmation(input.get("product"));
		Assert.assertTrue(confirmedProduct);
		Boolean confirmedPrize = confirmationPage.verifyProductPrize();
		Assert.assertTrue(confirmedPrize);

		// quitting browser
		tearDown();

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\ProjectTesting\\data\\TestDataSet.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}
