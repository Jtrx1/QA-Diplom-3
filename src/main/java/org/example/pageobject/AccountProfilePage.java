package org.example.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage {
    private final WebDriver driver;

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    //локатор кнопки "Выход"
    private final By exitButton=By.xpath(".//button[contains(text(),'Выход')]");

    //локатор поля c текстом "В этом разделе вы можете изменить свои персональные данные"
    private final By textInPage=By.xpath(".//nav[@class='Account_nav__Lgali']//p");
    //локатор Логотипа stellarburgers
    private final By logoField=By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //локатор кнопки Констркуктор
    private final By inscriptionField=By.xpath(".//li/a");

    @Step("Получаем текст внутри личного кабинета")
    public String getTextInPage(){
        return driver.findElement(textInPage).getText();
    }

    @Step("Нажимаем кнопку \"Выйти\"")
    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }
    @Step("Нажимаем на лого")
    public void clickLogoField(){
        driver.findElement(logoField).click();
    }
    @Step("Нажимаем на надпись конструктор")
    public void clickInscriptionField(){
        driver.findElement(inscriptionField).click();
    }

}
