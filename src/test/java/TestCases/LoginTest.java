package TestCases;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.Base;

import java.io.IOException;

public class LoginTest extends Base {

    Logger log;

    WebDriver driver;

    @Test(dataProvider = "getLoginData")
    public void login(String email, String password, String status) throws IOException {

        try {

            LandingPage l1 = new LandingPage(driver);
            l1.menu().click();
            log.debug("Click on Menu Icon");
            l1.loginButton().click();
            log.debug("Click on login button");

            Thread.sleep(3000);

            LoginPage l2 = new LoginPage(driver);
            l2.email().sendKeys(email);
            log.error("Email address got entered");
            l2.password().sendKeys(password);
            log.debug("Password got entered");
            l2.loginButton().click();
            log.debug("Clicked on login button");

            Thread.sleep(3000);

            AccountPage a1 = new AccountPage(driver);
            String actualResult = null;
            l1.menu().click();
            Thread.sleep(3000);

            if (a1.userNameDisplay().isDisplayed()) {
                actualResult = "Successful";
                log.info("User logged In");
            } else {
                log.error("Login Fail");
                actualResult = "Failure";
                log.error("Login Fail1");
            }
            Assert.assertEquals(actualResult, status);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeMethod
    public void open() throws IOException {

        log = LogManager.getLogger(LoginTest.class.getName());

        try {
            driver = initDriver();
            driver.get(prop.getProperty("url"));
            log.debug("URL Navigate");
            System.out.println(prop.getProperty("url"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        log.debug("Browser Closed");
    }

    @DataProvider
    public Object[][] getLoginData() {
        Object[][] data = {{"nipuninuwanthi97@gmail.com", "nuwanthi@5914", "Successful"}, {"nnuwanthi97@gmail.com", "nuwanthi@59", "Failure"}};
        return data;
    }
}
