package step_definitions;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import config.Base;

import java.io.IOException;

public class Logout extends Base {
    WebDriver driver;
    LandingPage landingPage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Given("Open any Browser")
    public void openAnyBrowser() throws IOException {
        driver = initDriver();
    }

    @And("Navigate to Login page")
    public void navigateToLoginPage() throws InterruptedException {
        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
        landingPage.menu().click();
        landingPage.loginButton().click();
        Thread.sleep(3000);
    }

    @When("User enters username as {string} and password as {string} into the fields")
    public void userEntersUsernameAsAndPasswordAsIntoTheFields(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.email().sendKeys(email);
        loginPage.password().sendKeys(password);
    }

    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.loginButton().click();
    }

    @Then("Verify user is able to successfully login")
    public void verifyUserIsAbleToSuccessfullyLogin() {
        accountPage = new AccountPage(driver);
        landingPage.menu().click();
        Assert.assertTrue(accountPage.userNameDisplay().isDisplayed());
    }

    @Then("Verify user is able to successfully logout")
    public void verifyUserIsAbleToSuccessfullyLogout() {
        accountPage = new AccountPage(driver);
        // l1.menu().click();
        Assert.assertThrows(NoSuchElementException.class, () -> accountPage.userNameDisplay().isDisplayed());
        //Assert.assertFalse(a1.userNameDisplay().isDisplayed());
    }

    @And("User clicks on Logout button")
    public void userClicksOnLogoutButton() throws InterruptedException {
        Thread.sleep(3000);
        accountPage = new AccountPage(driver);
        accountPage.logOutButton().click();
    }

    @After
    public void closeBrowser() {
            driver.close();
    }
}

