package tests;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto{
    @Test
 void test() throws InterruptedException {
     WebDriver driver = new ChromeDriver();
     driver.get("https://practicetestautomation.com/practice-test-login/");

        Thread.sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        Thread.sleep(3000);

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        //Assert.assertEquals("","practicetestautomation.com/logged-in-successfully");




 }


}


