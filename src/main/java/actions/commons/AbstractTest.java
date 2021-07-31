package actions.commons;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractTest {

//    WebDriver driver;
//    public WebDriver getBrowserDriver(String browserName){
//        Browser browser = Browser.valueOf(browserName.toUpperCase());
//        if (browser==Browser.CHROME){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browser == Browser.FIREFOX){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//        throw new RuntimeException("Please choose browser name!");
//    }
}
