package WSpages.tests;

import PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpRequest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BrokenLinks {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        LandingPage landinPage = new LandingPage(driver);
        landinPage.goTo();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("No of Links are:" +links.size());

        List<String> urlList = new ArrayList<String>();
        for(WebElement e : links)
        {
            String url = e.getAttribute("href");
        //    urlList.add(url);
           CheckBrokenlink(url);
        }

       /* long stTime = System.currentTimeMillis();
        urlList.parallelStream().forEach(e->CheckBrokenlink(e));
        long endTime = System.currentTimeMillis();

        System.out.println("Total time taken:" + (endTime-stTime));*/
        driver.quit();
    }



    public static void CheckBrokenlink(String linkUrl){

        try{
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()>=400)
            {
                System.out.println(linkUrl + "-->" + httpURLConnection.getResponseMessage()+ " is a broken link");
            }

            else{
                System.out.println(linkUrl + " --> "+ httpURLConnection.getResponseMessage());
            }
        } catch (Exception e){

        }
    }
}
