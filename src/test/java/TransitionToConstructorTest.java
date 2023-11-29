import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.example.pageobject.AccountProfilePage;
import org.example.pageobject.LoginPage;
import org.example.pageobject.MainPage;
import org.junit.Assert;
import org.junit.Test;

import static org.example.Settings.SITE_URL;
@DisplayName("Переход в конструктор")
public class TransitionToConstructorTest extends BaseTest{

    @Test
    @Step("Переход в Конструктор через лого Stellarburgers")
    @DisplayName("Переход в конструктор через лого Stellarburgers")
    public void trasitionToLogo(){
        driver.get(SITE_URL+"login");
        LoginPage lPage=new LoginPage(driver);
        lPage.loginInTheSystem(user);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.clickLogoField();
        MainPage mainPage=new MainPage(driver);
        Assert.assertTrue(driver.findElement(mainPage.getPlaceOrder()).isDisplayed());
    }
    @Test
    @Step("Переход в Конструктор через надпись Конструктор")
    @DisplayName("Переход в Конструктор через надпись Конструктор")
    public void trasitionToInscription(){
        driver.get(SITE_URL+"login");
        LoginPage lPage=new LoginPage(driver);
        lPage.loginInTheSystem(user);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.clickInscriptionField();
        MainPage mainPage=new MainPage(driver);
        Assert.assertTrue(driver.findElement(mainPage.getPlaceOrder()).isDisplayed());
    }

}
