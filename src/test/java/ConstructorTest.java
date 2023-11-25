import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.example.WebBrowser;
import org.example.pageobject.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.example.Settings.SITE_URL;
@DisplayName("Тесты на переходы к разделам: Булки, Соусы, Начинки")

public class ConstructorTest{
    protected WebDriver driver;
    @Before
    public void init(){
        driver = WebBrowser.get();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(SITE_URL);
    }

    @Test
    @Step("Переход к разделу Начинки")
    @DisplayName("Переход к разделу Начинки")
    public void checkIngredientFieldTest(){
        MainPage mainPage=new MainPage(driver);
        mainPage.clickIngredientButton();
        Assert.assertTrue(driver.findElement(mainPage.getIngredientField()).isDisplayed());
    }

    @Test
    @Step("Переход к разделу Соусы")
    @DisplayName("Переход к разделу Соусы")
    public void checkSauceFieldTest(){
        MainPage mainPage=new MainPage(driver);
        mainPage.clickSauceButton();
        Assert.assertTrue(driver.findElement(mainPage.getSaucefield()).isDisplayed());
    }

    @Test
    @Step("Переход к разделу Булки")
    @DisplayName("Переход к разделу Булки")
    public void checkBunFieldTest(){
        MainPage mainPage=new MainPage(driver);
        mainPage.scrollToIngredientField();
        mainPage.clickBunButton();
        Assert.assertTrue(driver.findElement(mainPage.getBunField()).isDisplayed());
    }
    @After
    @Step("Выходим из браузера")
    public void exit(){
        driver.quit();
    }

}
