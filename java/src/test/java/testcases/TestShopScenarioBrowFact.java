package testcases;


import browser.BrowserFactoryBasic;
import browser.BrowserFactoryMedior;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by MiesMSI on 5-7-2017.
 */
public class TestShopScenarioBrowFact {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = BrowserFactoryMedior.getDriver("Chrome");

        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
