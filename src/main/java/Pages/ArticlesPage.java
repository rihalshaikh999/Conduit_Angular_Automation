package Pages;

import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlesPage extends BaseClass
{
    @FindBy(xpath = "//input[@placeholder='Article Title']")
    WebElement Title;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[2]/input")
    WebElement Description;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[3]/textarea")
    WebElement article;

    @FindBy(xpath = "//input[@placeholder='Enter tags']")
    WebElement tag;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/button")
    WebElement publishButton;
    @FindBy(xpath = "/html/body/app-root/app-article-page/div/div[1]/div/app-article-meta/div/span/button")
    WebElement deleteArticleButton;

    public ArticlesPage(){
        PageFactory.initElements(driver, this);
    }

    public void PublishArticle(String title, String description, String write, String tags){
        Title.sendKeys(title);
        Description.sendKeys(description);
        article.sendKeys(write);
        tag.sendKeys(tags);
        publishButton.click();
    }
    public void deleteArticle()
    {
        deleteArticleButton.click();
    }
}
