package org.example.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //локатор кнопки "Войти в аккаунт"
    private final By loginAccountButton = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    //локатор кнопки "Личный кабинет"
    private final By personalAccountButton = By.xpath("//*[@id='root']/div/header/nav/a");
    //локатор кнопки "Оформить заказ"
    private final By placeOrder =By.xpath(".//button[contains(text(),'Оформить заказ')]");
    //локатор поля "Булки"
    private final By bunField = By.xpath(".//h2[contains(text(), 'Булки')]");
    //локатор поля "Соусы"
    private final By sauceField = By.xpath(".//h2[contains(text(), 'Соусы')]");
    //локатор поля "Начинки"
    private final By ingredientField = By.xpath(".//h2[contains(text(), 'Начинки')]");

    //Локатор кнопки "Булки"
    private final By bunButton = By.xpath(".//span[contains(text(), 'Булки')]");
    //Локатор кнопки "Соусы"
    private final By sauceButton = By.xpath(".//span[contains(text(), 'Соусы')]");

    //Локатор кнопки "Начинки"
    private final By ingredientButton = By.xpath(".//span[contains(text(), 'Начинки')]");

    @Step("Нажимаем кнопку \"Войти в аккаунт\"")
    public void clickLoginAccountButton(){
        driver.findElement(loginAccountButton).click();
    }
    @Step("Нажимаем кнопку \"Личный кабинет\"")
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }
   @Step("Возвращаем кнопку Оформить заказ, для проверки")
    public By getPlaceOrder() {
        return placeOrder;
    }
    @Step("проверяем поле Булки")
    public By getBunField() {
        return bunField;
    }
    @Step("проверяем поле соусы")
    public By getSaucefield() {
        return sauceField;
    }
    @Step("проверяем поле Начинки")
    public By getIngredientField() {
        return ingredientField;
    }
    @Step("Нажимаем кнопку Булки")
    public void clickBunButton(){
        driver.findElement(bunButton).click();
    }
    @Step("Нажимаем кнопку Соусы")
    public void clickSauceButton(){
        driver.findElement(sauceButton).click();
    }
    @Step("Нажимаем кнопку Начинки")
    public void clickIngredientButton(){
        driver.findElement(ingredientButton).click();
    }

    @Step("Скролл до элемента Начинки")
    public void scrollToIngredientField(){
     WebElement element = driver.findElement(ingredientField);
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}

