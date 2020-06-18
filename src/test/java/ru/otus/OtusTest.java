package ru.otus;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.userProfile.PersonalDataPage;

/**
 * - Открыть https://otus.ru
 * - Авторизоваться на сайте
 * - Войти в личный кабинет
 * - В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
 * - Нажать сохранить
 * - Открыть https://otus.ru в "чистом браузере"
 * - Авторизоваться на сайте
 * - Войти в личный кабинет
 * - Проверить, что в разделе "О себе" отображаются указанные ранее данные
 */


public class OtusTest extends BaseTest {
    MainPage mainPage;
    PersonalDataPage personalDataPage;


    @BeforeMethod
    public void setUpMethod() {
        mainPage = new MainPage(driver);
        personalDataPage = new PersonalDataPage(driver);
    }

    @Test(description = "Test Otus site and personal information on cabinet", priority = 1)
    public void otusFirstTest() {
        mainPage
                .useEnterAndRegister()
                .sendAccountDataInField()
                .goToPersonalPage();
        personalDataPage
                .setFirstName()
                .setLastName()
                .setNickName()
                .setBirdData()
                .addTwoSecondCommunicationField()
                .addSecondCommunicationFB()
                .addSecondCommunicationVK();
    }

 //   @Test(description = "Second Test Otus site and validation personal information on cabinet", priority = 2)
    public void otusSecondTest () {
        mainPage
                .useEnterAndRegister()
                .sendAccountDataInField()
                .goToPersonalPage();
    }
}