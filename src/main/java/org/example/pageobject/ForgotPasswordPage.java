package org.example.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор кнопки Войти на странице восстановления пароля
    private final By enterButton= By.xpath(".//a[@class='Auth_link__1fOlj']");

    @Step("Нажимаем кнопку \"Войти\" на странице восстановления пароля")
    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }
}
