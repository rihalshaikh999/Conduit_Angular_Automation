package TestCases;

import Base.BaseClass;
import Pages.HomePage;
import Pages.SettingsPage;
import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsUpdateTest extends BaseClass
{
    public LoginPage loginPage;
    public HomePage homePage;
    public SettingsPage settingsPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        homePage=new HomePage();
        loginPage=homePage.clickSingIn();
        homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("pass"));
        Thread.sleep(2000);
        settingsPage=homePage.clickSettings();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void profileUpdateTest() throws InterruptedException {
        settingsPage.profileSettings(prop.getProperty("imageURL"), prop.getProperty("username"), prop.getProperty("bio"), prop.getProperty("email"), prop.getProperty("pass"));
    }
    @Test(priority = 2)
    public void logout()
    {
        settingsPage.Logout();
    }
}
