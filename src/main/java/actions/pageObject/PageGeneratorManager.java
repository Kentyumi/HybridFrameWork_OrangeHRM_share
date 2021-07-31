package actions.pageObject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static DashBoardPageObject getDashBoardPage(WebDriver driver) {
        return new DashBoardPageObject(driver);
    }

    public static EmployeeDetailPageObject getEmployeeDetailPage(WebDriver driver) {
        return new EmployeeDetailPageObject(driver);
    }

    public static UserDetailPageObject getUserDetailPage(WebDriver driver){return new UserDetailPageObject(driver);}
}
