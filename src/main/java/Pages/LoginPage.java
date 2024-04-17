package Pages;

import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailPlaceholder;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordPlaceholder;

    @FindBy(xpath = "//button[text()=' Sign in ']")
    WebElement signInButtonSubmit;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String email, String password) {
        emailPlaceholder.sendKeys(email);
        passwordPlaceholder.sendKeys(password);
        signInButtonSubmit.click();
        return new HomePage();
    }
}
