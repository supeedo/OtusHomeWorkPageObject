package ru.otus;

import base.BaseTest;
import config.Config;
import config.DriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class OtherMethodOtusTest extends BaseTest {
    DriverFactory driverFactory = new DriverFactory();
    public static WebDriver driver;
    protected Config cfg = ConfigFactory.create(Config.class);

    @BeforeTest
    protected void setUp() {
        String browserType = System.getProperty("browser");

        if (browserType == null) driver = driverFactory.createNewDriver("chrome");
        else driver = driverFactory.createNewDriver(browserType);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(cfg.URL());
    }

    @Test(description = "Test Otus site and personal information on cabinet")
    public void marketTest() {
        //кнопка Вход и регистрация
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector(".header2__auth.js-open-modal > span"))).click();
        // поле Электронная почта
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .cssSelector(".new-input.js-email-input[name=email][placeholder=\"Электронная почта\"]")))
                .sendKeys(cfg.LOGIN());
        // Поле Пароль
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .cssSelector(".new-input[name=password][placeholder=\"Введите пароль\"]")))
                .sendKeys(cfg.PASSWORD());
        // Кнопка Войти
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("button.new-button[type=\"submit\"]"))).click();
        // Наводит на меню
        Actions action = new Actions(driver);
        action.moveToElement(driver
                .findElement(By
                        .cssSelector("div.header2-menu__icon div.ic-blog-default-avatar")))
                .perform();

        // Кнопка Мой профиль
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .cssSelector("b.header2-menu__dropdown-text_name")))
                .click();
        //перешли в профиль

        // ______________________________________


    }





   // @AfterTest
    protected void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
