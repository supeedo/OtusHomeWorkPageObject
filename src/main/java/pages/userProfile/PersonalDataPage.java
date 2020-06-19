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

    // ________________________  contact information  __________________________

    private final String ADD_CONTACT_BUTTON_CSS = "button[type=\"button\"].js-lk-cv-custom-select-add";
    private final String COMMUNICATION_MENU_1_XPATCH = "(//span[text()='Способ связи' and @class='placeholder'])[1]";
    private final String COMMUNICATION_1_FIELD_CSS = "input[name=\"contact-0-value\"]";
    private final String COMMUNICATION_FACEBOOK_CSS = "button[data-value=\"facebook\"][title=\"Facebook\"]";
    private final String COMMUNICATION_MENU_2_XPATCH = "(button[type=\"button\"].js-lk-cv-custom-select-add)[2]";
    private final String COMMUNICATION_2_FIELD_CSS = "input[name=\"contact-1-value\"]";
    private final String COMMUNICATION_VK_CSS = "(//button[@data-value=\"vk\"])[2]";



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

    //_____________________________________

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

    //  добавление двух дополнительных полей контактов
    public PersonalDataPage addTwoSecondCommunicationField(){
        guidanceOnElement(addContactButton, driver);
        useElement(addContactButton, driver);
        useElement(addContactButton, driver);
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
      //  guidanceOnElement(communicationVK, driver);
      //  useElement(communicationVK, driver);
      //  guidanceOnElement(communicationFieldSecond, driver);
      //  sendDataInElement(communicationFieldSecond, userData.contactVK, driver);
        return this;
    }


}
