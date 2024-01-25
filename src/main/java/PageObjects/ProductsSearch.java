package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsSearch extends AbstractComponents {
    WebDriver driver;

    public ProductsSearch(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//section[@class=\'ossa-16883 rvi\']//input[@id=\'search-field\']")
    WebElement ProductSearch;

    @FindBy(xpath = "//section[@class='ossa-16883 rvi']//button[@type='submit']")
    WebElement Searchbtnclick;

    @FindBy(css = "span.heading.search-results-count")
    WebElement count;

    @FindBy(xpath ="//h2[contains(text(),' Customers Who Searched ')]")
    WebElement Customersearch;


    @FindBy(xpath ="//div[(@class='grid-item')]")
    List<WebElement> PCAcNum;




   public void ProductSearch(String product) {
       ProductSearch.sendKeys(product);
       Searchbtnclick.click();
   }
     public int ActualProductcount(){
           int PCNum= Integer.parseInt(count.getText().split("search")[0].trim());
           System.out.println("Expected Product count is :"+PCNum);
           return PCNum;
       }


   public WebElement customerSearchTxt() throws InterruptedException {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,5000)");
       js.executeScript("arguments[0].scrollIntoView(true)", Customersearch);
       return Customersearch;
    }
    public int ActualProdCount() throws InterruptedException {
        Thread.sleep(6000);
        int ProductsCount = PCAcNum.size();
        System.out.println("Actual product count is " +ProductsCount);
        return ProductsCount;
    }
}
