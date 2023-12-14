package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    private static final String SRC_TEST_JAVA_CONFIG_DATA_PROPERTIES = "src/test/java/config/data.properties";
    WebDriver driver;
    public Properties prop;

    public WebDriver initDriver() throws IOException {

        prop = new Properties();
        prop.load(new FileInputStream(SRC_TEST_JAVA_CONFIG_DATA_PROPERTIES));
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("Ie")) {

            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;

    }

    public String takeScreenshot(String testName, WebDriver driver) throws IOException {


        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFilePath = "screenshots/" + testName + ".png";
        //String destinationFilePath = System.getProperty("screenshots/"+testName+".png");
        //FileUtils.copyFile(sourceFile,new File(destinationFilePath));
        FileUtils.copyFile(sourceFile, new File("screenshots/" + testName + ".png"));

        return destinationFilePath;
    }


}


