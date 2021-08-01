package testcases.employee;

import actions.commons.AbstractTest;

import actions.driverFacTory.DriverFactory;
import actions.driverFacTory.DriverManager;
import actions.pageObject.*;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


//@Listeners(TestNGListener.class)
public class Employee_01_Add_Edit_Employee_User extends AbstractTest {

    WebDriver driver;
    DriverManager driverManager;
    LoginPageObject loginPage;
    DashBoardPageObject dashBoard;
    EmployeeDetailPageObject employeeDetail;
    UserDetailPageObject userDetail;


    //    @Parameters({"browser","url"})
//    @BeforeClass
//    public void beforeClass(String browser,@Optional("https://opensource-demo.orangehrmlive.com/index.php/dashboard") String url) {
//        driverManager = DriverFactory.getBrowserDriver(browser);
//        driver = driverManager.getDriver();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.get(url);
//    }
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlValue){
        driverManager = DriverFactory.getBrowserDriver(browserName);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(urlValue);

        loginPage = PageGeneratorManager.getLoginPage(driver);
        log.info("Pre-condition - Step 01: Input to Username Text box ");
        loginPage.inputToUserNameTextBox();

        log.info("Pre-condition - Step 02: Input to Password Text box ");
        loginPage.inputToPasswordTextBox();

        log.info("Pre-condition - Step 01: Click Login button ");
        dashBoard = loginPage.clickLoginButton();
    }

    @Test
    public void TC_01_ValidateCurrentUrl() {


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}


