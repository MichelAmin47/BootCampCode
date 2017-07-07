package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by MiesMSI on 6-7-2017.
 */
public class BrowserFactoryAdvanced {

    public enum Browser{
        FIREFOX,
        IE,
        CHROME;
    }


    public static WebDriver getDriver(Browser browser){
        switch(browser) {
            case FIREFOX:
                return createFireFoxBrowser();
            case IE:
                return createIEBrowser();
            case CHROME:
                return createChromeBrowser();
            default:
                return createChromeBrowser();
        } // end switch
    }

    private static WebDriver createChromeBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //Chrome options are chrome specific
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("ignore-certificate-errors");
        //Capabilities can used for WebDriver capabilities ie: proxy
        capabilities.setCapability("chrome.switches", "--verbose");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(capabilities);
    }

    private static WebDriver createFireFoxBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver(capabilities);
    }

    private static WebDriver createIEBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        InternetExplorerDriverManager.getInstance().setup();
        return new InternetExplorerDriver(capabilities);
    }
}
