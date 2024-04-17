package Pages;

import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass
{
    @FindBy(xpath = "/html/body/app-root/app-layout-header/nav/div/a")
    WebElement titleValidation;
    @FindBy(xpath = "//a[@routerlink='/login']")
    WebElement singIn;
    @FindBy(xpath = "//a[@routerlink='/editor']")
    WebElement article;
    @FindBy(xpath = "//a[@routerlink='/settings']")
    WebElement settings;

    @FindBy(xpath = "/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/app-article-preview[1]/div/a/h1")
    WebElement globalFieldProfileName;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitleValidationText() {
        return titleValidation.getText();
    }
    public LoginPage clickSingIn(){
        singIn.click();
        return new LoginPage();
    }
    public ArticlesPage clickNewArticle(){
        article.click();
        return new ArticlesPage();
    }
    public SettingsPage clickSettings(){
        settings.click();

        return new SettingsPage();
    }
    public HomePage globalFieldProfile()
    {
        globalFieldProfileName.click();
        return new HomePage();
    }
}
