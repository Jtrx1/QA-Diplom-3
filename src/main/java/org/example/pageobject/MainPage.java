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
    //локатор поля "Булки", для проверки что она нажата
    private final By bunField = By.xpath(".//span[contains(text(), 'Булки')]//parent::div[contains(@class, 'tab_tab_type_current')]");
    //локатор поля "Соусы", для проверки что она нажата
    private final By sauceField = By.xpath(".//span[contains(text(), 'Соусы')]//parent::div[contains(@class, 'tab_tab_type_current')]");
    //локатор поля "Начинки", для проверки что она нажата
    private final By ingredientField = By.xpath(".//span[contains(text(), 'Начинки')]//parent::div[contains(@class, 'tab_tab_type_current')]");

    //Локатор кнопки "Булки"
    private final By bunButton = By.xpath(".//span[contains(text(), 'Булки')]");
    //Локатор кнопки "Соусы"
    private final By sauceButton = By.xpath(".//span[contains(text(), 'Соусы')]");

    //Локатор кнопки "Начинки"
    private final By ingredientButton = By.xpath(".//span[contains(text(), 'Начинки')]");


    @Step("Скроллим до самого нижнего элемента")
    public void scrollToLowestElemet(String lowestElement){
        WebElement element= driver.findElement(By.xpath(String.format(".//div//p[contains(text(), '%s')]", lowestElement)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

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


}

