package StepDefinations;

import Pages.Home_Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ST03_Search_StepDefination {

    WebDriver driver = null ;
    Home_Page home;
    SoftAssert soft;



    @Given("user Open the browser to search")
    public void User_Open_Browser()
    {
        String Chrome_Path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",Chrome_Path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new Home_Page(driver);
        soft = new SoftAssert();  // initilize the soft variable

    }

    @And("user navigate to the Home page")
    public void Navigate_To_HomePage()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("^user write product name in the search Text box in the Home page product name is \"(.*)\"$")
    public void Write_product_name(String P_Name)
    {
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        home.Search_Store_TxtBox().clear();
        home.Search_Store_TxtBox().sendKeys(P_Name);
    }

    @And("user Click on search button")
    public void Click_SearchBTN()
    {
        home.Search_BTN().click();
    }

    @Then("the application directed to the URL Successfully_ProductName")
    public void Application_Directed_Successfully_ProductName()
    {
        String Expected_URL = "https://demo.nopcommerce.com/search?q=Apple";
        String Actual_URL_PName = driver.getCurrentUrl();
        System.out.println("The URL OF First TC is" + Actual_URL_PName);
        // first assertion to assure the app direct user to search page
        soft.assertTrue(Actual_URL_PName.contains(Expected_URL),"First assertion product name fail the actual url was not as expected");
        soft.assertAll();
    }

    @Then("the application directed to the URL Successfully_SKU")
    public void Application_Directed_Successfully_SKU()
    {
        String Expected_URL_SKU = "https://demo.nopcommerce.com/search?q=AP_MBP_13";
        String Actual_URL_SKU = driver.getCurrentUrl();
        System.out.println("The URL OF Second TC is" + Actual_URL_SKU);
        // first assertion to assure the app direct user to search page
        soft.assertTrue(Actual_URL_SKU.contains(Expected_URL_SKU),"First SKU assertion fail the actual url was not as expected");
        soft.assertAll();
    }

    @And("product appeared")
    public void Product_Appeared_Successfully()
    {
        int Result_size = driver.findElements(By.cssSelector(".products-container")).size();
        soft.assertTrue(Result_size > 0,"second assertion fail , list is empty");
        soft.assertTrue(home.Search_Keyword_TxtBox().isDisplayed(),"Third assertion fail and Search keyword Text box was not appeared");
        soft.assertAll();
    }

    @After("@Search")
    public void CloseURL() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
    }

    @When("^user write product SKU in the search Text box in the Home page Product SKU is \"(.*)\"$")
    public void Write_product_SKU(String P_SKU)
    {
        home.Search_Store_TxtBox().clear();
        home.Search_Store_TxtBox().sendKeys(P_SKU);
    }

    @And("user hit Enter from keyboard")
    public void Press_Enter()
    {
        home.Search_Store_TxtBox().sendKeys(Keys.ENTER);
    }
}
