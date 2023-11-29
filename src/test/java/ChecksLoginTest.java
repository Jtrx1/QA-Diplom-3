import org.example.pageobject.*;
import org.junit.Test;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import static org.example.Settings.SITE_URL;
import static org.junit.Assert.assertEquals;

@DisplayName("Проверяем вход в аккаунт из разных мест")
public class ChecksLoginTest extends BaseTest {

    @Test
    @DisplayName("Вход через кнопку \"Войти в аккаунт\"")
    @Description("Входим через кнопку \"Войти в аккаунт\", переходим по кнопке \"Личный кабинет\" и проверяем вход")
    public void checkLoginAccountButton(){
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
    @DisplayName("Вход через кнопку \"Личный кабинет\"")
    @Description("Входим через кнопку \"Личный кабинет\", переходим по кнопке \"Личный кабинет\" и проверяем вход")
    public void checkLoginPersonalAccountButton(){
        driver.get(SITE_URL);
        MainPage mPage = new MainPage(driver);
        mPage.clickPersonalAccountButton();
        LoginPage lPage=new LoginPage(driver);
        lPage.loginInTheSystem(user);
        mPage.clickPersonalAccountButton();
        AccountProfilePage aPage=new AccountProfilePage(driver);
        String expected="В этом разделе вы можете изменить свои персональные данные";
        String actual=aPage.getTextInPage();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Вход через кнопку \"Войти\" на странице регистрации")
    @Description("Входим через кнопку \"Личный кабинет\", переходим по кнопке \"Личный кабинет\" и проверяем вход")
    public void checkLoginRegistrationPage(){
        driver.get(SITE_URL+"register");
        RegistrationPage rPage=new RegistrationPage(driver);
        rPage.clickEnterButton();
        LoginPage lPage=new LoginPage(driver);
        lPage.loginInTheSystem(user);
        MainPage mPage = new MainPage(driver);
        mPage.clickPersonalAccountButton();
        AccountProfilePage aPage=new AccountProfilePage(driver);
        String expected="В этом разделе вы можете изменить свои персональные данные";
        String actual=aPage.getTextInPage();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Вход через кнопку \"Войти\" на странице восстановления пароля")
    @Description("Входим через кнопку \"Войти\", переходим по кнопке \"Личный кабинет\" и проверяем вход")
    public void checkLoginForgotPasswordPage(){
        driver.get(SITE_URL+"forgot-password");
        ForgotPasswordPage fPage=new ForgotPasswordPage(driver);
        fPage.clickEnterButton();
        LoginPage lPage=new LoginPage(driver);
        lPage.loginInTheSystem(user);
        MainPage mPage = new MainPage(driver);
        mPage.clickPersonalAccountButton();
        AccountProfilePage aPage=new AccountProfilePage(driver);
        String expected="В этом разделе вы можете изменить свои персональные данные";
        String actual=aPage.getTextInPage();
        assertEquals(expected, actual);
    }

}