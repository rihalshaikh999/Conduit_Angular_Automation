package TestCases;

import Base.BaseClass;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass
{
    HomePage homepage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homepage = new HomePage();
    }

    @Test
    public void verifyTitleTest()
    {
        String expectedTitle = "Conduit";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Not Matched");
    }
}
