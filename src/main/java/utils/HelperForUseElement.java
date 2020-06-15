package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperForUseElement {
    public static void useElement( WebElement webElement, WebDriver driver ) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(webElement)).click();
    }
    public static void sendDataInElement( WebElement webElement, String data, WebDriver driver ) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(webElement)).sendKeys(data);
    }
    public static void guidanceOnElement(WebElement element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(element)
                .perform();
    }
    public static Boolean waitElementVisible( WebElement element, WebDriver driver ) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }
}
