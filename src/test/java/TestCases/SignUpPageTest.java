package TestCases;

import Base.BaseClass;
import Pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseClass {
    private SignUpPage signUpPage;

    @BeforeMethod
    public void setUp() {
        initialization();
        signUpPage = new SignUpPage();
    }

    @Test(priority = 1)
    public void registrationTest() {
        signUpPage.signUpWithEmail(prop.getProperty("email"), prop.getProperty("pass"));
    }
}