package AutomationAcademy.stepDefinitation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import AutomationAcademy.TestComponnets.BaseTest;
import AutomationAcademyPageObject.CartPage;
import AutomationAcademyPageObject.CheckOutPage;
import AutomationAcademyPageObject.ConfirmationPage;
import AutomationAcademyPageObject.LandingPage;
import AutomationAcademyPageObject.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinitationImpl extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in the username (.+) and password (.+)$")
	public void Logged_in_the_username_and_password(String username, String password) {

		productCatalogue = landingPage.loginApplication(username, password);

	}

	@When("^I add the product (.+) in Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException {

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

	}

	@When("^CheckOut (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		CartPage cartPage = productCatalogue.goTocartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);

		Assert.assertFalse(match);
		CheckOutPage checkOutPage = cartPage.checkOut();
		checkOutPage.addCountry("India");
		confirmationPage = checkOutPage.submitOrder();

	}

	@Then("{string} message is displayed on ConfirmationPage.")
	public void message_displayed_on_confirmationPage(String string) {
		String confirmMessage = confirmationPage.getConfimationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
	@Then ("{string} message is displayed")
	public void someting_displayed_on_confirmationPage(String string) {
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
	}
}
