package org.example.pageobject;

import io.qameta.allure.Step;
import org.example.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    //Локатор кнопки "Войти" на странице регистрации
    private final By enterButton = By.xpath(".//a[@class='Auth_link__1fOlj']");
    //Локатор поле Имя
    private final By nameField = By.xpath(".//fieldset[1]//div/input");
    //Локатор поле Email
    private final By emailField = By.xpath(".//fieldset[2]//div/input");
    //Локатор поле Пароль
    private final By passwordField = By.xpath(".//div/input[@name='Пароль']");
    //Локатор кнопки регистрации
    private final By registrationButton =By.xpath(".//form//button");
    //Локатор поля сообщения о некорректном пароле
    private final By invalidPasswordField = By.xpath(".//div[@class='input__container']//p[@class]");

    @Step("Жмем кнопку \"Войти\" на странице регистрации")
    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }
    @Step("Вводим email")
    public void sendEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Вводим пароль")
    public void sendPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Вводим имя")
    public void sendName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Нажимаем кнопку \"Зарегистрироваться")
    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }
    @Step("Заполняем данные")
    public void registration(User user){
        sendName(user.getName());
        sendEmail(user.getEmail());
        sendPassword(user.getPassword());
        clickRegistrationButton();
    }
    @Step("Возвращаем текст ошибки при некорректном пароле")
    public String getInvalidPasswordFieldText(){
        return driver.findElement(invalidPasswordField).getText();
    }

}
