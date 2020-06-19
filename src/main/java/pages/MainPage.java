package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.userProfile.PersonalDataPage;
import utils.HelperForUseElement;

public class MainPage extends HelperForUseElement {
    private WebDriver driver;
    //  //button[@data-modal-id='new-log-reg']
    private final String BUTTON_ENTER_AND_REGISTER_CSS = ".header2__auth.js-open-modal > span";
    private final String USER_PROFILE_BANNER_CSS = "div.header2-menu__icon div.ic-blog-default-avatar";
    private final String USER_PROFILE_MENU_FIELD_CSS = "b.header2-menu__dropdown-text_name";

    private final String EMAIL_INPUT_CSS = ".new-input.js-email-input[name=email][placeholder=\"Электронная почта\"]";
    private final String PASSWORD_INPUT_CSS = ".new-input[name=password][placeholder=\"Введите пароль\"]";
    private final String SUBMIT_BUTTON_CSS = "button.new-button[type=\"submit\"]";


    @FindBy(css = BUTTON_ENTER_AND_REGISTER_CSS)
    public WebElement buttonEnterAndRegister;

    @FindBy(css = USER_PROFILE_BANNER_CSS)
    public WebElement userProfileBanner;

    @FindBy(css = USER_PROFILE_MENU_FIELD_CSS)
    public WebElement userProfileMenuField;

    @FindBy(css = EMAIL_INPUT_CSS)
    public WebElement emailInput;

    @FindBy(css = PASSWORD_INPUT_CSS)
    public WebElement passwordInput;

    @FindBy(css = SUBMIT_BUTTON_CSS)
    public WebElement submitButton;


    public MainPage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage useEnterAndRegister() {
        useElement(buttonEnterAndRegister, driver);
        return this;
    }

    public MainPage sendAccountDataInField(String login, String password) {
        sendDataInElement(emailInput, login , driver);
        sendDataInElement(passwordInput, password , driver);
        useElement(submitButton, driver);
        return this;
    }

    public PersonalDataPage goToPersonalPage() {
        guidanceOnElement(userProfileBanner,driver);
        useElement(userProfileMenuField, driver);
        return new PersonalDataPage(driver);
    }


}
