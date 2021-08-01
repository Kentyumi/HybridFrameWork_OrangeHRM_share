package actions.commons;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class AbstractPage {

    private JavascriptExecutor jsExecutor;
    private WebElement element;

    private Alert alert;
    private Select select;

    private WebDriverWait explicitWait;

    // Function for browser

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public int randomNumber() {
        Random rand = new Random();
        return rand.nextInt();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void fordWardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void acceptAlert(WebDriver driver) {
        alert = driver.switchTo().alert();
        alert.accept();
    }


    public void cancelAlert(WebDriver driver) {
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAlertText(WebDriver driver) {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void sendKeyToAlert(WebDriver driver, String text) {
        alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    // Function for Java Execute

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(WebDriver driver, String xpathValue) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = find(driver, xpathValue);
        String originalStyle = element.getAttribute("style");
    }

    // Function for Element

    public WebElement find(WebDriver driver, String xpathValue) {
        return driver.findElement(byXpath(xpathValue));
    }

    public List<WebElement> finds(WebDriver driver, String xpathValue) {
        return driver.findElements(byXpath(xpathValue));
    }

    public By byXpath(String xpathValue) {
        return By.xpath(xpathValue);
    }

    public void clickToElement(WebDriver driver, String xpathValue) {
        find(driver, xpathValue).click();
    }

    public void sendKeyToElement(WebDriver driver, String xpathValue) {
        element = find(driver, xpathValue);
        element.clear();
        element.sendKeys();
    }

    public void selectItemInDropDown(WebDriver driver, String xpathValue, String itemValue) {
        select = new Select(find(driver, xpathValue));
        select.selectByVisibleText(itemValue);
    }

    public String getSelectedItemInDropDown(WebDriver driver, String xpathValue) {
        select = new Select(find(driver, xpathValue));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropDownMultiple(WebDriver driver, String xpathValue) {
        select = new Select(find(driver, xpathValue));
        return select.isMultiple();
    }

    public void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void waitToElementVisible(WebDriver driver, String xpathValue) {
        WebElement element = find(driver,xpathValue);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(element));


    }


}