package base;

import config.Config;
import config.DriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    DriverFactory driverFactory = new DriverFactory();
    public  WebDriver driver;
    protected Logger logger = LogManager.getLogger(BaseTest.class);
    protected Config cfg = ConfigFactory.create(Config.class);

    @BeforeTest
    protected void setUp() {
        String browserType = System.getProperty("browser");
        logger.info("Got a browser name = {}", browserType);

        if (browserType == null) driver = driverFactory.createNewDriver("chrome");
        else driver = driverFactory.createNewDriver(browserType);

        logger.info("Driver set'up = {}", driver.getClass());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void startUp(){
        logger.info("Переходим на сайт: {}", cfg.URL());
        driver.navigate().to(cfg.URL());
    }

    @AfterMethod
    public void cleanUp(){
            driver.manage().deleteAllCookies();
    }

    @AfterTest
    protected void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver close");
        }
    }
}
