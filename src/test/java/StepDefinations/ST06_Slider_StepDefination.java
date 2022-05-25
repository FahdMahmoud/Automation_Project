package StepDefinations;

import Pages.Home_Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ST06_Slider_StepDefination {

    WebDriver driver = null;
    String Chrom_Path = null;
    Home_Page home;
    WebDriverWait wait;
    boolean check;

    @Given("open browser")
    public void BrowserOpen()
    {
       Chrom_Path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
       System.setProperty("webdriver.chrome.driver",Chrom_Path);
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       home = new Home_Page(driver);
    }

    @And("navigate to home_page")
    public void NavigateHomePage()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("user click on first slider")
    public void FirstSliderClicked() throws InterruptedException
    {
        // Explicit wait
        // wait = new WebDriverWait(driver,30);
        // wait.until(ExpectedConditions.visibilityOf(home.Sliders(1)));

        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        home.Sliders(1).click();
    }

    @When("user click on second slider")
    public void SecondSliderClicked() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(3);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        home.Sliders(2).click();
    }

    @Then("first slider item page opened successfully")
    public void FirstSliderPageOpened()
    {
        // assert that when click on first slider the app directed to item slider page
        // by using explicit wait
        wait = new WebDriverWait(driver,10);
        // this assertion will fail as the page directed to home page not to item page
        check = wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        Assert.assertTrue(check);
        // this url will fail  ( https://demo.nopcommerce.com/nokia-lumia-1020 )
        // this url will pass  ( https://demo.nopcommerce.com/ )
    }

    @Then("second slider item page opened successfully")
    public void SecondSliderPageOpened()
    {
        wait = new WebDriverWait(driver,10);
        check = wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/iphone-6"));

        // this assertion will fail as the page directed to home page not to slider product page
        Assert.assertTrue(check);
    }

    @After("@Slider")
    public void CloseURL() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
    }

}


