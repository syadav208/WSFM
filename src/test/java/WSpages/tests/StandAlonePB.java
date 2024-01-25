package WSpages.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class StandAlonePB {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.potterybarn.com/");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[contains(@class,'dismiss-overlay-text')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'email-campaign-wrapper joinEmailList')]//a[contains(@class,'stickyOverlayMinimizeButton')]")).click();

        driver.findElement(By.id("my-account")).click();
        driver.findElement(By.id("email")).sendKeys("sbsriniwaas@gmail.com");
       // Thread.sleep(5000L);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='accountLoginButton']")));
        driver.findElement(By.id("accountLoginButton")).click();
        driver.findElement(By.id("password")).sendKeys("Srinivas@208");
        WebElement element = driver.findElement(By.xpath("//div/button[contains(text(),'Sign In')]"));

        driver.findElement(By.id("accountLoginButton")).click();

    }
    }
