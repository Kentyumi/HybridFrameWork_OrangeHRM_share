package actions.driverFacTory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManager extends DriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
