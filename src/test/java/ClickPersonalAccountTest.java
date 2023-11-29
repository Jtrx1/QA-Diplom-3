import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.example.pageobject.AccountProfilePage;
import org.example.pageobject.LoginPage;
import org.example.pageobject.MainPage;
import org.junit.Test;

import static org.example.Settings.SITE_URL;
import static org.junit.Assert.assertEquals;

@DisplayName("Проверка переход по клику на Личный кабинет")
public class ClickPersonalAccountTest extends BaseTest{
    @Test
    @DisplayName("с авторизацией")
    @Step("Проверка с авторизацией")
    public void checkClickWithAutorization(){
        driver.get(SITE_URL);
        MainPage mPage = new MainPage(driver);
        mPage.clickLoginAccountButton();
        LoginPage lPage=new LoginPage(driver);
        lPage.loginInTheSystem(user);
        mPage.clickPersonalAccountButton();
        AccountProfilePage aPage=new AccountProfilePage(driver);
        String expected="В этом разделе вы можете изменить свои персональные данные";
        String actual=aPage.getTextInPage();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("без авторизации")
    @Step("Проверка без авторизации")
    public void checkClickWithoutAutorization(){
        driver.get(SITE_URL);
        MainPage mPage = new MainPage(driver);
        mPage.clickPersonalAccountButton();
        LoginPage loginPage=new LoginPage(driver);
        String expected = "Войти";
        String actual=loginPage.getHeadEnterFieldText();
        assertEquals(expected, actual);
    }
}
