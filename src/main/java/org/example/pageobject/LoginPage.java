package org.example.pageobject;

import io.qameta.allure.Step;
import org.example.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //локатор поля email
    private final By emailField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    //локатор поля пароль
    private final By passwordField = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    //Локатор кнопки войти
    private final By enterButton=By.xpath(".//button[contains(text(),'Войти')]");

    @Step("Вводим email")
    public void sendEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Вводим пароль")
    public void sendPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Нажимаем кнопку ВОЙТИ")
    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }
    @Step("Авторизация")
    public void loginInTheSystem(User user){
        sendEmail(user.getEmail());
        sendPassword(user.getPassword());
        clickEnterButton();
    }

    @Step("Получаем текст кнопки \"Войти\"")
    public String getHeadEnterFieldText(){
        return driver.findElement(enterButton).getText();
    }

}
