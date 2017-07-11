package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "li#header_link_contact > a")
    private WebElement contactButton;

    @FindBy(css = ".login")
    private WebElement logInButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;

        // This call sets the WebElement fields.
        PageFactory.initElements(driver, this);
    }

    public void clickContactUS(){
        contactButton.click();
    }

    public void clickLogIn(){
        logInButton.click();
    }
}
