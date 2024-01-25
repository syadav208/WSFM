package WSpages.tests;

import PageObjects.LandingPage;
import PageObjects.ProductsSearch;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSelection extends BaseTest {

   @Test
  public void ProductSelect() throws InterruptedException {
        LandingPage landinPage = new LandingPage(driver);
         landinPage.goTo();
        // landinPage.loginApplication("sbsriniwaas@gmail.com", "Srinivas@208");
         ProductsSearch productSearch = new ProductsSearch(driver);
         productSearch.ProductSearch("pillow cover");
         productSearch.ActualProductcount();
         productSearch.customerSearchTxt();
         productSearch.ActualProdCount();
         Assert.assertEquals( productSearch.ActualProductcount(),productSearch.ActualProdCount());

    }
}