package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private static final String H_2_CONTAINS_TEXT_NIPUNI_NUWANTHI = "//h2[contains(text(),'Nipuni Nuwanthi')]";
    private static final String H_3_CONTAINS_TEXT_LOG_OUT = "//h3[contains(text(),'Log Out')]";
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = H_2_CONTAINS_TEXT_NIPUNI_NUWANTHI)
    private WebElement userNameDisplay;
    public WebElement userNameDisplay() {
        return userNameDisplay;
    }
    @FindBy(xpath = H_3_CONTAINS_TEXT_LOG_OUT)
    private WebElement logOutButton;
    public WebElement logOutButton() {
        return logOutButton;
    }

}
