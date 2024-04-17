package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass
{
    public static WebDriver driver;
    public static Properties prop;
    public ExtentReports extent= new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\rihal\\Downloads\\conduitAngularAutomation\\Reports\\ExternalReport.html");

    public BaseClass()
    {



        try {
            prop=new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\rihal\\Downloads\\conduitAngularAutomation\\src\\main\\java\\Config\\Config.properties");
            prop.load(ip);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initialization()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }
}
