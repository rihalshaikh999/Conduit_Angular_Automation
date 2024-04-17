package TestCases;
import Base.BaseClass;
import Pages.ArticlesPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArticlePageTest extends BaseClass {

    public LoginPage loginPage;
    public HomePage homePage;
    public ArticlesPage ArticlePage;

    public ArticlePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialization();
            homePage=new HomePage();
            loginPage=homePage.clickSingIn();
            homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("pass"));
            Thread.sleep(2000);
            ArticlePage=new ArticlesPage();
            Thread.sleep(2000);
        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void publish() throws InterruptedException
    {
        Thread.sleep(2000);
        ArticlePage = homePage.clickNewArticle();
        Thread.sleep(2000);
        ArticlePage.PublishArticle(prop.getProperty("Title"), prop.getProperty("Description"), prop.getProperty("write"), prop.getProperty("tags"));
    }

    @Test(priority = 2)
    public void delete() throws InterruptedException
    {
        homePage.globalFieldProfile();
        Thread.sleep(2000);
        ArticlePage.deleteArticle();
        Thread.sleep(2000);
    }
}
