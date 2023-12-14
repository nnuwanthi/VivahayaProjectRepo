package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import config.Base;

import java.io.IOException;


public class FirstClass extends Base {

    public WebDriver driver;

    @Test
    public void firstClass() throws IOException, InterruptedException {

        System.out.println("Nipuni");
        driver = initDriver();
        driver.get("https://mvnrepository.com/");
        Thread.sleep(2000);
        // driver.close();
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
