package StepDefinations;

import Pages.Home_Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class ST05_HoverOnCategory_StepDefination {

    WebDriver driver;
    Home_Page home;
    Actions action ;
    String subCategoryName;
    int categoryCount ;

    @Given("user open browser")
    public void Open_Browser()
    {
        String Chrome_Path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",Chrome_Path);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new Home_Page(driver);
        action = new Actions(driver);
    }

    @And("user navigate to home page to hover on category")
    public void NavigateHomePage()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("user hover category and select subcategory")
    public void HoverOnCategory()
    {
        action.moveToElement(home.mainCategory());
    }

   /* @When("user hover category and select subcategory")
    public void HoverOnCategory()
    {
        // count the top menu elements
        // loop on each element to select submenu of it
    } */


    @And("user select subcategory from main category")
    public void selectSubcategory()
    {
        action.moveToElement(home.Comp_Subcategory_Nootbooks());
        action.click().build().perform();
    }

    @Then("user select the subcategory successfully")
    public void SelectionSuccess() throws InterruptedException
    {
        // trim to remove any spaces in the title
        String ActualTxtSubCat =  home.SubCategory_Title().getText().toLowerCase().trim();
        String ExpectedTxtSubCat = "notebooks";
        Assert.assertEquals(ActualTxtSubCat,ExpectedTxtSubCat,"Assertion fail");
    }

    @After("@Hover")
    public void Close() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }
}
