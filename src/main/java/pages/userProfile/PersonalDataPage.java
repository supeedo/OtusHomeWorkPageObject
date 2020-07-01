package pages.userProfile;

import base.BasePage;
import data.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PersonalDataPage extends BasePage {

    private WebDriver driver;
    protected Logger logger = LogManager.getLogger(PersonalDataPage.class);
    private UserData userData = new UserData();

    public PersonalDataPage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //  _______________________   main data   ____________________________

    private final String FIRST_NAME_CSS = "#id_fname";
    private final String FIRST_NAME_LATIN_CSS = "#id_fname_latin";
    private final String LAST_NAME_CSS = "#id_lname";
    private final String LAST_NAME_LATIN_CSS = "#id_lname_latin";
    private final String NICK_NAME_CSS = "#id_blog_name";
    private final String BIRD_DATE_CSS = "input[name=\"date_of_birth\"]";

    // ________________________  basic information  _________________________

    private final String COUNTRY_MENU_CSS = "div[data-ajax-slave =\"/lk/biography/cv/lookup/cities/by_country/\"]";
    private final String COUNTRY_NAME_RUSSIA_IN_MENU_CSS = "button[title=\"Россия\"]";
    private final String CITY_MENU_XPATCH = "//div[contains(@class, 'js-lk-cv-dependent-slave-city')]//..";
    private final String CITIES_NAME_MOSCOW_IN_MENU_CSS = "button[title=\"Москва\"]";
    private final String ENGLISH_MENU_XPATCH = "(//div[contains(@class,'input input_full')])[3]";
    private final String ENGLISH_LEVEL_BEGINNER_IN_MENU_CSS = "button[title=\"Начальный уровень (Beginner)\"]";


    // ________________________  contact information  __________________________

    private final String ADD_CONTACT_BUTTON_XPATCH = "//button[text()='Добавить']";
    private final String COMMUNICATION_MENU_1_XPATCH = ".//div[@data-prefix = 'contact']//div[contains(@class, 'js-custom-select-presentation')]";
    private final String COMMUNICATION_FACEBOOK_CSS = "button[data-value=\"facebook\"][title=\"Facebook\"]";
    private final String COMMUNICATION_1_FIELD_CSS = "input[name=\"contact-0-value\"]";
    private final String COMMUNICATION_MENU_2_XPATCH = "(.//div[@data-prefix = 'contact']//div[contains(@class, 'js-custom-select-presentation')])[2]";
    private final String COMMUNICATION_2_FIELD_CSS = "input[name='contact-1-value']";
    private final String COMMUNICATION_VK_XPATCH = "(//button[@data-value=\"vk\"])[2]";
    private final String CONTACT_CONTAINER_CSS = "div[class=\"js-formset\"][data-prefix='contact']";

    private final String SAVE_BUTTON_CSS = "button[title='Сохранить и продолжить']";


    @FindBy(css = FIRST_NAME_CSS)
    public WebElement firstNameField;

    @FindBy(css = FIRST_NAME_LATIN_CSS)
    public WebElement firstNameLatinField;

    @FindBy(css = LAST_NAME_CSS)
    public WebElement lastNameField;

    @FindBy(css = LAST_NAME_LATIN_CSS)
    public WebElement lastNameLatinField;

    @FindBy(css = NICK_NAME_CSS)
    public WebElement nickNameField;

    @FindBy(css = BIRD_DATE_CSS)
    public WebElement birdDataField;

    //____________________________________

    @FindBy(css = COUNTRY_MENU_CSS)
    public WebElement countryMenu;

    @FindBy(css = COUNTRY_NAME_RUSSIA_IN_MENU_CSS)
    public WebElement countryRussia;

    @FindBy(xpath = CITY_MENU_XPATCH)    //  +============
    public WebElement cityMenu;

    @FindBy(css = CITIES_NAME_MOSCOW_IN_MENU_CSS)
    public WebElement cityMoscow;

    @FindBy(xpath = ENGLISH_MENU_XPATCH)
    public WebElement englishMenu;

    @FindBy(css = ENGLISH_LEVEL_BEGINNER_IN_MENU_CSS)
    public WebElement englishLevelBeginner;

    //_____________________________________

    @FindBy(xpath = ADD_CONTACT_BUTTON_XPATCH)
    public WebElement addContactButton;

    @FindBy(xpath = COMMUNICATION_MENU_1_XPATCH)
    public WebElement communicationMenuFirst;

    @FindBy(css = COMMUNICATION_FACEBOOK_CSS)
    public WebElement communicationFacebook;

    @FindBy(css = COMMUNICATION_1_FIELD_CSS)
    public WebElement communicationFieldFirst;

    @FindBy(xpath = COMMUNICATION_MENU_2_XPATCH)
    public WebElement communicationMenuSecond;

    @FindBy(xpath = COMMUNICATION_VK_XPATCH)
    public WebElement communicationVK;

    @FindBy(css = COMMUNICATION_2_FIELD_CSS)
    public WebElement communicationFieldSecond;

    @FindBy(css = CONTACT_CONTAINER_CSS)
    public List<WebElement> contactContainer;

    @FindBy(css = SAVE_BUTTON_CSS)
    public WebElement saveButton;

    // __________________________________________________________________

    //  установка имени и имени на латинице
    public PersonalDataPage setFirstName() {
        logger.info("Enter the firstname");
        sendDataInElement(firstNameField, userData.firstName, driver);
        logger.info("Enter the firstname Eng");
        sendDataInElement(firstNameLatinField, userData.firstNameLatin, driver);
        return this;
    }

    // устанавка фамилии и фамилии на латинице
    public PersonalDataPage setLastName() {
        logger.info("Enter the lastname");
        sendDataInElement(lastNameField, userData.lastName, driver);
        logger.info("Enter the lastname Eng");
        sendDataInElement(lastNameLatinField, userData.lastNameLatin, driver);
        return this;
    }

    //  установка ника
    public PersonalDataPage setNickName() {
        logger.info("Enter the nick name");
        sendDataInElement(nickNameField, userData.nickName, driver);
        return this;
    }

    // установка даты рождения
    public PersonalDataPage setBirdData() {
        logger.info("Enter the bird date");
        sendDataInElement(birdDataField, userData.birdDate, driver);
        return this;
    }

    //  установка страны и города проживания
    public PersonalDataPage addLocation() {
        logger.info("Set Country and City");
        useElement(countryMenu, driver);
        useElement(countryRussia, driver);
        useElement(cityMenu, driver);
        useElement(cityMoscow, driver);
        return this;
    }

    //  установка уровня английского
    public PersonalDataPage setEnglishLevel() {
        logger.info("Set language level");
        guidanceOnElement(englishMenu, driver);
        useElement(englishMenu, driver);
        useElement(englishLevelBeginner, driver);
        return this;
    }

    //  добавление двух дополнительных полей контактов
    public PersonalDataPage addSecondCommunicationField() {
        logger.info("add second contact");
        useElement(addContactButton, driver);
        return this;
    }

    //  ввод первого дополнительного контакта - Facebook
    public PersonalDataPage addSecondCommunicationFB() {
        logger.info("set Facebook contact");
        useElement(communicationMenuFirst, driver);
        useElement(communicationFacebook, driver);
        sendDataInElement(communicationFieldFirst, userData.contactFB, driver);
        return this;
    }

    //  ввод второго дополнительного контакта  -  VK
    public PersonalDataPage addSecondCommunicationVK() {
        logger.info("set Vk contact");
        if (contactContainer.size() >= 2) {
            sendDataInElement(communicationFieldSecond, userData.contactVK, driver);
        } else {
            addSecondCommunicationField();
            useElement(communicationMenuSecond, driver);
            useElement(communicationVK, driver);
            sendDataInElement(communicationFieldSecond, userData.contactVK, driver);
        }
        return this;
    }

    // сохранение изменений
    public PersonalDataPage saveChanges() {
        logger.info("save personal info");
        useElement(saveButton, driver);
        return this;
    }

    public PersonalDataPage checkSavedPersonData() {
        logger.info("Assertion info");
        Assert.assertEquals(firstNameField.getAttribute("value"), userData.firstName, "FirstName не валидны!");
        Assert.assertEquals(firstNameLatinField.getAttribute("value"), userData.firstNameLatin, "FirstNameLatin не валидны!");
        Assert.assertEquals(lastNameField.getAttribute("value"), userData.lastName, "lastName не валидны!");
        Assert.assertEquals(lastNameLatinField.getAttribute("value"), userData.lastNameLatin, "lastNameLatin не валидны!");
        Assert.assertEquals(nickNameField.getAttribute("value"), userData.nickName, "nickName не валидны!");
        Assert.assertEquals(birdDataField.getAttribute("value"), userData.birdDate, "birdDate не валидны!");
        Assert.assertEquals(communicationFieldFirst.getAttribute("value"), userData.contactFB, "contactFB не валидны!");
        Assert.assertEquals(communicationFieldSecond.getAttribute("value"), userData.contactVK, "contactVK не валидны!");
        return this;
    }

}
