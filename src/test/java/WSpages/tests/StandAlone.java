package WSpages.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StandAlone {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.williams-sonoma.com/");


        driver.manage().window().maximize();

        driver.findElement(By.id("my-account")).click();
        driver.findElement(By.id("email")).sendKeys("sbsriniwaas@gmail.com");
        Thread.sleep(5000L);
        driver.findElement(By.id("accountLoginButton")).click();
    //    driver.findElement(By.cssSelector("button.btn-primary")).click();


      //  driver.findElement(By.xpath("//button[@id='accountLoginButton']")).click();
      //  JavascriptExecutor jse = (JavascriptExecutor)driver;
      //  jse.executeScript("browserstack_executor:  {\"action\": \"acceptSsl\"}");

       /* WebElement we = driver.findElement(By.xpath("//button[@id='accountLoginButton']"));
        Actions action = new Actions(driver);
        action.moveToElement(we).click().build().perform();

        WebElement element = driver.findElement(By.xpath("//button[@id='accountLoginButton']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='accountLoginButton']")));*/
       /* driver.findElement(By.xpath("//button[@id='accountLoginButton']")).click();
        driver.findElement(By.id("password")).sendKeys("Srinivas@208");
        driver.findElement(By.id("accountLoginButton")).click();*/


    }

}
