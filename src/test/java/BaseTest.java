import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.WebBrowser;
import org.example.helper.CreateUserFaker;
import org.example.model.User;
import org.example.model.UserApi;
import org.example.model.UserResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static org.example.Settings.SITE_URL;

public class BaseTest {
    protected WebDriver driver;
    protected User user;
    protected String accessToken;
    @Before
    @Step("Подготавливаем тест")
    public void init() {
    RestAssured.baseURI = SITE_URL;
    user = CreateUserFaker.getFakerUser();
    Response response=UserApi.createUser(user);
    UserResponse userResponse=response.as(UserResponse.class);
    accessToken=userResponse.getAccessToken();
    driver = WebBrowser.get();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @After
    @Step("Выходим из браузера, удаляем пользователя")
    public void exit(){
        driver.quit();
        UserApi.deleteUser(accessToken);
    }
}
