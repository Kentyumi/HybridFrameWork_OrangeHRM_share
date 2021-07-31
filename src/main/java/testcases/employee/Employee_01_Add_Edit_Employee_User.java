package testcases.employee;

import actions.commons.AbstractTest;

import actions.driverFacTory.DriverFactory;
import actions.driverFacTory.DriverManager;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Employee_01_Add_Edit_Employee_User extends AbstractTest {

    WebDriver driver;
    DriverManager driverManager;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browser,@Optional("https://opensource-demo.orangehrmlive.com/index.php/dashboard") String url) {
        driverManager = DriverFactory.getBrowserDriver(browser);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void TC_01_ValidateCurrentUrl() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}


