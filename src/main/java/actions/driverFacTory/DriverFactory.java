package actions.driverFacTory;


import actions.commons.Browser;

public abstract class DriverFactory {

    public static DriverManager getBrowserDriver(String browserName) {
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        DriverManager driverManager = null;

        if (browser == Browser.CHROME){
            driverManager = new ChromeDriverManager();
        } else if (browser == Browser.FIREFOX){
           driverManager = new FireFoxDriverManager();
        }
        return driverManager;
}

}