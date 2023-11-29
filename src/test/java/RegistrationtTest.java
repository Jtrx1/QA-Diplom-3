import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.WebBrowser;
import org.example.helper.CreateUserFaker;
import org.example.model.User;
import org.example.model.UserApi;
import org.example.model.UserResponse;
import org.example.pageobject.LoginPage;
import org.example.pageobject.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.example.Settings.SITE_URL;
import static org.junit.Assert.assertEquals;

@DisplayName("Тесты на регистрацию")
public class RegistrationtTest {
    private WebDriver driver;
    private User user;
    private boolean registrationSuccess;

    @Before
    @Step("Подготавливаем тест")
    public void init() {
        user = CreateUserFaker.getFakerUser();
        driver = WebBrowser.get();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(SITE_URL+"register");
    }
    @Test
    @DisplayName("Успешная регистрация")
    @Step("Успешная регистрация")
    public void registrationSuccess(){
        RegistrationPage rPage = new RegistrationPage(driver);
        rPage.registration(user);
        LoginPage lPage = new LoginPage(driver);
        String expected = "Войти";
        String actual=lPage.getHeadEnterFieldText();
        assertEquals(expected, actual);
        registrationSuccess=true;
    }
    @Test
    @DisplayName("Регистрация с недостаточным количеством символов в пароле")
    @Step("Регистрация с недостаточным количеством символов в пароле")
    public void registrationFail(){
        user.setPassword(user.getPassword().substring(0, 5));
        RegistrationPage rPage = new RegistrationPage(driver);
        rPage.registration(user);
        String expected = "Некорректный пароль";
        String actual =rPage.getInvalidPasswordFieldText();
        assertEquals(expected, actual);
    }
    @After
    @Step("Закрываем браузер, при необходимости удаляем данные")
    public void exit(){
        driver.quit();
        if (registrationSuccess) {
            RestAssured.baseURI = SITE_URL;
            Response response=UserApi.userLogin(user);
            UserResponse userResponse =response.as(UserResponse.class);
            UserApi.deleteUser(userResponse.getAccessToken());
        }
    }
}
