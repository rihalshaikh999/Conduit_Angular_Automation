package Pages;

import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BaseClass
{
    @FindBy(xpath = "//input[@placeholder='URL of profile picture']")
    WebElement urlimage;

    @FindBy(xpath = "/html/body/app-root/app-settings-page/div/div/div/div/form/fieldset/fieldset[2]/input")
    public WebElement newUserName;

    @FindBy(xpath = "/html/body/app-root/app-settings-page/div/div/div/div/form/fieldset/fieldset[3]/textarea")
    public WebElement bio;

    @FindBy(xpath = "/html/body/app-root/app-settings-page/div/div/div/div/form/fieldset/fieldset[4]/input")
    public WebElement updatedEmail;

    @FindBy(xpath = "/html/body/app-root/app-settings-page/div/div/div/div/form/fieldset/fieldset[5]/input")
    public WebElement updatedPassword;

    @FindBy(xpath = "/html/body/app-root/app-settings-page/div/div/div/div/form/fieldset/button")
    public WebElement updateSettingsButton;
    @FindBy(xpath = "/html/body/app-root/app-settings-page/div/div/div/div/button")
    WebElement logout;

    public SettingsPage() {
        PageFactory.initElements(driver, this);
    }

    public void profileSettings(String image, String username, String bio1, String email1, String newPassword){
        urlimage.sendKeys(image);
        newUserName.sendKeys(username);
        bio.sendKeys(bio1);
        updatedEmail.sendKeys(email1);
        updatedPassword.sendKeys(newPassword);
//        newUserName.click();
    }

    public HomePage Logout(){
        logout.click();
        return new HomePage();
    }
}
