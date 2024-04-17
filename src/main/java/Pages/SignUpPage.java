package Pages;

import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseClass {
    @FindBy(xpath = "//a[@href='/register']")
    WebElement signUpButton;

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailPlaceholder;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordPlaceholder;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    public void signUpWithEmail(String email, String password) {
        signUpButton.click();
        emailPlaceholder.sendKeys(email);
        passwordPlaceholder.sendKeys(password);
        submitButton.click();
    }
}
