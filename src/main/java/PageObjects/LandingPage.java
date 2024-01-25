package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponents;


public class LandingPage extends AbstractComponents {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id ="my-account")
    WebElement account;

     @FindBy(id ="email")
     WebElement useremail;

   //  @FindBy(css =".btn-primary")
     @FindBy(xpath ="//div//button[contains(@class,'btn-primary')]")
     WebElement contbtn;


    @FindBy(id ="password")
    WebElement userpassword;

    @FindBy(id =".btn-primary")
    WebElement signInbtn;



    public void loginApplication(String email, String pswrd) throws InterruptedException {
        account.click();
       // Thread.sleep(4000);
        useremail.sendKeys(email);
        WebElement webElement = driver.findElement(By.xpath("//div//button[contains(@class,'btn-primary')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webElement);
      //  contbtn.click();
        userpassword.sendKeys(pswrd);
        signInbtn.click();
    }


    public void goTo()
    {
        driver.get("https://www.williams-sonoma.com/");

    }


    }


