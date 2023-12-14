package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private static final String MENU = "//body/div[@id='root']/div[3]/div[1]/div[1]/*[1]";
    private static final String LOGIN_BUTTON = "//h3[contains(text(),'Login')]";
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = MENU)
    public WebElement menu;
    public WebElement menu() {
        return menu;
    }

    @FindBy(xpath = LOGIN_BUTTON)
    public WebElement loginButton;
    public WebElement loginButton() {
        return loginButton;
    }
}
