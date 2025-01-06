package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitionsImpl extends BaseTest
{
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue; 
	public ConfirmationPage confirmationPage;
		@Given("I landed on Ecommerce page")
		public void i_landed_on_ecommerce_page() throws IOException
		{
			landingPage=launchApplication();
		}
		@Given("Logged in with username {string} and password {string}")
		public void loggedInUserNameandPassword(String username, String password)
		{
			productCatalogue = landingPage.loginApplication(username,password);
		}
		@When("I add the {string} to cart")
		public void  I_add_product_to_cart(String productName) throws InterruptedException
		{
			List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(productName);
		}
		@And("Checkout {string} and submit the order")
		public void checkout_submit_order(String productName)
		{
			CartPage cartPage = productCatalogue.goToCartPage();
			Boolean match = cartPage.VerifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = cartPage.goToCheckout();
			checkoutPage.selectCountry("india");
			confirmationPage = checkoutPage.submitOrder();
		}
		//Then "THANKYOU FOR THE ORDER." message is displayed on the ConfirmationPage
		@Then("{string} message is displayed on the ConfirmationPage")
		public void message_displayed_ConfirmationPage(String string)
		{
			String confirmMessage = confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
			driver.quit();
		}
		  @Given("^\"([^\"]*)\" message is displayed$")
		  public void something_message_is_displayed(String strargs) throws InterruptedException
		  {
			//Thread.sleep(1000);;
		  Assert.assertEquals(strargs,landingPage.getErrorMessage()); 
		  driver.quit();
		  }
}
