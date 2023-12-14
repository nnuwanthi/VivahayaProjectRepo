package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private static final String EMAIL_INPUT = "//input[@id='email']";
    private static final String PASSWORD_INPUT = "//input[@id='password']";
    private static final String LOGIN_BUTTON = "//button[contains(text(),'Log in')]";
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = EMAIL_INPUT)
    public WebElement email;
    public WebElement email() {
        return email;
    }

    @FindBy(xpath = PASSWORD_INPUT)
    public WebElement password;
    public WebElement password() {
        return password;
    }

    @FindBy(xpath = LOGIN_BUTTON)
    public WebElement loginButton;
    public WebElement loginButton() {
        return loginButton;
    }
}
