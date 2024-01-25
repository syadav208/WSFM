package TestComponents;
import PageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
       // FileInputStream fis = new FileInputStream("D:\\WSIProjectFW\\src\\main\\java\\WS\\resources\\GlobalData.properties.txt");

       FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\WS\\resources\\GlobalData.properties.txt");
        prop.load(fis);
        String browserName = prop.getProperty("browser");


       if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

      /*  if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions handlingSSL = new ChromeOptions();
            handlingSSL.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(handlingSSL);*/


        } else if (browserName.equalsIgnoreCase("firefox")) {
            //Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "edge.exe");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;

    }
@BeforeMethod
    public LandingPage launchApplication() throws IOException {
      driver= initializeDriver();
        LandingPage landinPage = new LandingPage(driver);
        landinPage.goTo();
        return landinPage;
    }

    @AfterMethod()
    public void tearDown() {
      //  driver.close();
    }

}
