package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import config.Base;

import java.io.IOException;

public class ThirdClass extends Base {

    public WebDriver driver;

    @Test
    public void thirdClass() throws IOException, InterruptedException {
        System.out.println("Yohan");
        WebDriver driver = initDriver();
        driver.get("https://mvnrepository.com/");
        Thread.sleep(2000);
        driver.close();
    }
}


