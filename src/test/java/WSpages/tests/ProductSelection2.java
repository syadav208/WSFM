package WSpages.tests;

import PageObjects.LandingPage;
import PageObjects.ProductsSearch;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProductSelection2 {


    public ProductSelection2(WebDriver driver) {
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        LandingPage landinPage = new LandingPage(driver);
        landinPage.goTo();
        landinPage.loginApplication("sbsriniwaas@gmail.com", "Srinivas@208");
        ProductsSearch productSearch = new ProductsSearch(driver);
        productSearch.ProductSearch("pillow cover");

        driver.findElement(By.xpath("//section[@class='ossa-16883 rvi']//input[@id='search-field']")).sendKeys("pillow cover");
        driver.findElement(By.xpath("//section[@class='ossa-16883 rvi']//button[@type='submit']")).click();
        String PCNum = driver.findElement(By.cssSelector("span.heading.search-results-count")).getText().split("search")[0].trim();
        System.out.println(PCNum);
        int PCExpNum  = Integer.parseInt(PCNum);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");

        Thread.sleep(6000);


        WebElement Customersearch = driver.findElement(By.xpath("//h2[contains(text(),' Customers Who Searched ')]"));
        js.executeScript("arguments[0].scrollIntoView(true)", Customersearch);


        List<WebElement> PCAcNum = driver.findElements(By.xpath("//div[(@class='grid-item')]"));
        int ProductsCount=PCAcNum.size();

        System.out.println(ProductsCount);

        Assert.assertEquals(ProductsCount,PCExpNum);




    }
}