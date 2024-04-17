package TestCases;

import Base.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass
{
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage=new HomePage();
        loginPage=homePage.clickSingIn();
    }

    @Test
    public void loginValidation()
    {
        loginPage.login(prop.getProperty("email"), prop.getProperty("pass"));
    }
}
