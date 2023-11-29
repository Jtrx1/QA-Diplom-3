import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.example.pageobject.AccountProfilePage;
import org.example.pageobject.LoginPage;
import org.example.pageobject.MainPage;
import org.junit.Assert;
import org.junit.Test;
import static org.example.Settings.SITE_URL;

@DisplayName("Проверка выхода из аккаунта")
public class LogoutOfAccountTest extends BaseTest{
    @Test
    @Step("Проверка выхода из аккаунта")
    @DisplayName("Проверка выхода из аккаунта")
    public void logoutOfAccount(){
        driver.get(SITE_URL);
        MainPage mPage = new MainPage(driver);
        mPage.clickLoginAccountButton();
        LoginPage lPage=new LoginPage(driver);
        lPage.loginInTheSystem(user);
        mPage.clickPersonalAccountButton();
        AccountProfilePage aPage=new AccountProfilePage(driver);
        aPage.clickExitButton();
        String expected = "Войти";
        String actual=lPage.getHeadEnterFieldText();
        Assert.assertEquals(expected,actual);
        }
}
