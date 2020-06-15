package pages.userProfile;

import base.BasePage;
import data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDataPage extends BasePage {

    private WebDriver driver;
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
    private final String CITY_DISABLE_FLAG_CSS = "input[data-title=\"Город\"]";
    private final String CITY_MENU_CSS = ".select.js-lk-cv-dependent-slave-city";
    private final String CITIES_NAME_MOSCOW_IN_MENU_CSS = "button[title=\"Москва\"]";
    private final String ENGLISH_MENU_XPATCH = "(//div[contains(@class,'input input_full')])[3]";
    private final String ENGLISH_LEVEL_BEGINNER_IN_MENU_CSS = "button[title=\"Начальный уровень (Beginner)\"]";
    private final String RELOCATION_MENU_YES_XPATCH = "//span[text()='Да']";
    private final String RELOCATION_MENU_NO_XPATCH = "//span[text()='Нет']";
    private final String WORK_FORMAT_FULL_XPATCH = "(//p[text()='Формат работы']/../following-sibling::div//label)[1]";
    private final String WORK_FORMAT_FLEX_XPATCH = "(//p[text()='Формат работы']/../following-sibling::div//label)[2]";
    private final String WORK_FORMAT_REMOTE_XPATCH = "(//p[text()='Формат работы']/../following-sibling::div//label)[3]";

    // ________________________  contact information  __________________________

    private final String MAIL_CONTACT_FIELD_CSS = "#id_email";
    private final String MAIL_CONTACT_PREF_FLAG_XPATCH = "(//div[@class =\"container__col container__col_12 container__col_md-9 container__col_ssm-8\"])[1]";
    private final String TELEPHONE_CONTACT_FIELD_CSS = "#id_phone";
    private final String TELEPHONE_CONTACT_PREF_FLAG_XPATCH = "(//div[@class =\"container__col container__col_12 container__col_md-9 container__col_ssm-8\"])[2]";
    private final String ADD_CONTACT_BUTTON_CSS = "button[type=\"button\"].js-lk-cv-custom-select-add";
    private final String COMMUNICATION_MENU_1_XPATCH = "(//span[text()='Способ связи' and @class='placeholder'])[1]";
    private final String COMMUNICATION_1_FIELD_CSS = "input[name=\"contact-0-value\"]";
    private final String COMMUNICATION_FACEBOOK_CSS = "button[data-value=\"facebook\"][title=\"Facebook\"]";
    private final String COMMUNICATION_MENU_2_XPATCH = "(button[type=\"button\"].js-lk-cv-custom-select-add)[2]";
    private final String COMMUNICATION_2_FIELD_CSS = "input[name=\"contact-1-value\"]";
    private final String COMMUNICATION_VK_CSS = "(//button[@data-value=\"vk\"])[2]";

    // __________________________________   other  _______________________________

    private final String GENDER_MENU_CSS = "#id_gender";
    private final String GENDER_NAME_MALE_IN_MENU_CSS = "option[value=m]";
    private final String COMPANY_CSS = "#id_company";
    private final String POSITION_CSS = "#id_work";
    private final String SAVE_AND_CONTINUE_BUTTON_CSS = "button[name=\"continue\"]";

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

    @FindBy(css = COUNTRY_MENU_CSS)
    public WebElement countryMenu;

    @FindBy(css = COUNTRY_NAME_RUSSIA_IN_MENU_CSS)
    public WebElement countryRussia;

    @FindBy(css = CITY_DISABLE_FLAG_CSS)
    public WebElement cityFlag;

    @FindBy(css = CITY_MENU_CSS)    //  +============
    public WebElement cityMenu;

    @FindBy(css = CITIES_NAME_MOSCOW_IN_MENU_CSS)
    public WebElement cityMoscow;

    @FindBy(xpath = ENGLISH_MENU_XPATCH)
    public WebElement englishMenu;

    @FindBy(css = ENGLISH_LEVEL_BEGINNER_IN_MENU_CSS)
    public WebElement englishLevelBeginner;

    @FindBy(xpath = RELOCATION_MENU_YES_XPATCH)
    public WebElement relocationYES;

    @FindBy(xpath = RELOCATION_MENU_NO_XPATCH)
    public WebElement relocationNO;

    @FindBy(xpath = WORK_FORMAT_FULL_XPATCH)
    public WebElement workFormatFull;

    @FindBy(xpath = WORK_FORMAT_FLEX_XPATCH)
    public WebElement workFormatFlex;

    @FindBy(xpath = WORK_FORMAT_REMOTE_XPATCH)
    public WebElement workFormatRemote;

    @FindBy(css = MAIL_CONTACT_FIELD_CSS)
    public WebElement mailContactField;

    @FindBy(xpath = MAIL_CONTACT_PREF_FLAG_XPATCH)
    public WebElement mailContactPrefFlag;

    @FindBy(css = TELEPHONE_CONTACT_FIELD_CSS)
    public WebElement telephoneContactFiled;

    @FindBy(xpath = TELEPHONE_CONTACT_PREF_FLAG_XPATCH)
    public WebElement telephoneContactPrefFlag;

    @FindBy(css = ADD_CONTACT_BUTTON_CSS)
    public WebElement addContactButton;

    @FindBy(xpath = COMMUNICATION_MENU_1_XPATCH)
    public WebElement communicationMenuFirst;

    @FindBy(css = COMMUNICATION_1_FIELD_CSS)
    public WebElement communicationFieldFirst;

    @FindBy(css = COMMUNICATION_FACEBOOK_CSS)
    public WebElement communicationFacebook;

    @FindBy(xpath = COMMUNICATION_MENU_2_XPATCH)
    public WebElement communicationMenuSecond;

    @FindBy(css = COMMUNICATION_2_FIELD_CSS)
    public WebElement communicationFieldSecond;

    @FindBy(css = COMMUNICATION_VK_CSS)
    public WebElement communicationVK;

    @FindBy(css = GENDER_MENU_CSS)
    public WebElement genderMenu;

    @FindBy(css = GENDER_NAME_MALE_IN_MENU_CSS)
    public WebElement genderMale;

    @FindBy(css = COMPANY_CSS)
    public WebElement companyField;

    @FindBy(css = POSITION_CSS)
    public WebElement positionField;

    @FindBy(css = SAVE_AND_CONTINUE_BUTTON_CSS)
    public WebElement saveAndContinueButton;
    //  установка имени и имени на латинице
    public PersonalDataPage setFirstName() {
        firstNameField.clear();
        sendDataInElement(firstNameField, userData.firstName, driver);
        firstNameLatinField.clear();
        sendDataInElement(firstNameLatinField, userData.firstNameLatin, driver);
        return this;
    }
    // устанавка фамилии и фамилии на латинице
    public PersonalDataPage setLastName() {
        lastNameField.clear();
        sendDataInElement(lastNameField, userData.lastName, driver);
        lastNameLatinField.clear();
        sendDataInElement(lastNameLatinField, userData.lastNameLatin, driver);
        return this;
    }
    //  установка ника
    public PersonalDataPage setNickName() {
        nickNameField.clear();
        sendDataInElement(nickNameField, userData.nickName, driver);
        return this;
    }
    // установка даты рождения
    public PersonalDataPage setBirdData() {
        birdDataField.clear();
        sendDataInElement(birdDataField, userData.birdDate, driver);
        return this;
    }
    // установка стараны проживания
    public PersonalDataPage setCountry() {
        guidanceOnElement(countryMenu, driver);
        useElement(countryMenu, driver);
        useElement(countryRussia, driver);
        return this;
    }
   //  установка города проживания
    public PersonalDataPage setCity() {
        waitElementVisible(cityMenu, driver);
        guidanceOnElement(cityMenu,driver);
        useElement(cityMenu, driver);
        waitElementVisible(cityMoscow, driver);
        useElement(cityMoscow, driver);
        return this;
    }
    //  установка уровня английского
    public PersonalDataPage setEnglishLevel() {
        guidanceOnElement(englishMenu, driver);
        useElement(englishMenu, driver);
        useElement(englishLevelBeginner, driver);
        return this;
    }
    // готовность к релокации
    public PersonalDataPage setRelocation() {
        useElement(relocationYES, driver);
        return this;
    }
    //  установка типа работы
    public PersonalDataPage setWorkType() {
        useElement(workFormatFull, driver);
        return this;
    }
    //  добавление двух дополнительных полей контактов
    public PersonalDataPage addTwoSecondCommunicationField(){
        guidanceOnElement(addContactButton, driver);
        useElement(addContactButton, driver);
       // useElement(addContactButton, driver);
       // guidanceOnElement(englishMenu, driver);
        return this;
    }
    //  ввод первого дополнительного контакта - Facebook
    public PersonalDataPage addSecondCommunicationFB(){
        guidanceOnElement(communicationMenuFirst, driver);
        useElement(communicationMenuFirst, driver);
        guidanceOnElement(communicationFacebook, driver);
        useElement(communicationFacebook, driver);
        guidanceOnElement(communicationFieldFirst, driver);
        sendDataInElement(communicationFieldFirst, userData.contactFB, driver);
        return this;
    }
    //  ввод второго дополнительного контакта  -  VK
    public PersonalDataPage addSecondCommunicationVK(){
        guidanceOnElement(communicationMenuSecond, driver);
        useElement(communicationMenuSecond, driver);
        guidanceOnElement(communicationVK, driver);
        useElement(communicationVK, driver);
        guidanceOnElement(communicationFieldSecond, driver);
        sendDataInElement(communicationFieldSecond, userData.contactVK, driver);
        return this;
    }
    //  выбор пола
    public PersonalDataPage setGender() {
        guidanceOnElement(genderMenu, driver);
        useElement(genderMenu, driver);
        useElement(genderMale, driver);
        return this;
    }
    // установка компании
    public PersonalDataPage setCompany() {
        guidanceOnElement(companyField, driver);
        companyField.clear();
        sendDataInElement(companyField, userData.company, driver);
        return this;
    }
    //  установка должности
    public PersonalDataPage setPosition() {
        guidanceOnElement(positionField, driver);
        positionField.clear();
        sendDataInElement(positionField, userData.position, driver);
        return this;
    }
    // взаимодейсвтие с кнопкой Сохранить
    public PersonalDataPage useSaveButton() {
        useElement(saveAndContinueButton, driver);
        return this;
    }

}
