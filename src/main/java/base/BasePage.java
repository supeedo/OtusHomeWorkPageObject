package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HelperForUseElement;

public abstract class BasePage<P> extends HelperForUseElement {
    protected WebDriver driver;

    public P useElementOnPage( WebElement element ) {
        useElement(element, driver);
        return (P) this;
    }

    public P sendDataInElement( WebElement element, String data ) {
        sendDataInElement(element, data, driver);
        return (P) this;
    }

    public P useDropBoxMenu( WebElement element ) {
        guidanceOnElement(element, driver);
        return (P) this;
    }
}
