package actions.driverFacTory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
}
