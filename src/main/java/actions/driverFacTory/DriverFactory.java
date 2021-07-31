package actions.driverFacTory;

import actions.commons.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class DriverFactory {

    public static DriverManager getBrowserDriver(String browserName) {
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        DriverManager driverManager = null;
        if (browser == Browser.CHROME) {
            WebDriverManager.chromedriver().setup();
            driverManager = new ChromeDriverManager();
        } else if (browser == Browser.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driverManager = new FireFoxDriverManager();
        } else throw new RuntimeException("Please choose your browser name!");
        return driverManager;
    }

}