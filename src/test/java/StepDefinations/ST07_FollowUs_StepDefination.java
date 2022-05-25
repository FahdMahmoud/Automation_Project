package StepDefinations;

import Pages.Home_Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ST07_FollowUs_StepDefination {

    WebDriver driver;
    Home_Page home;
    // array to hold the opened tabs
    ArrayList<String> Tabs;

    @Given("Open The Browser")
    public void OpenBrowser()
    {
        String Chrom_Path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",Chrom_Path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new Home_Page(driver);
    }

    @And("Navigate To HomePage")
    public void NavigateHomePage()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("click the facebook link")
    public void Click_On_Facebook_Link() throws InterruptedException {
        home.FaceBook_Link().click();
        Tabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.switchTo().window(Tabs.get(1));
        Thread.sleep(3000);
        driver.switchTo().window(Tabs.get(0));
        TimeUnit.SECONDS.sleep(3);
        driver.switchTo().window(Tabs.get(1));
    }

    @When("user click on the twitter link")
    public void Click_On_Twitter_Link() throws InterruptedException {
        home.Twitter_Link().click();
        Tabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.switchTo().window(Tabs.get(1));
        Thread.sleep(3000);
    }

    @When("user click on the rss link")
    public void Click_On_Rss_Link() throws InterruptedException
    {
        home.Rss_Link().click();
        Tabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
    }

    @When("user click on the youtube link")
    public void Click_On_Youtube_Link() throws InterruptedException {
        home.Youtube_Link().click();
        Tabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.switchTo().window(Tabs.get(1));
        Thread.sleep(3000);
    }

    @Then("Facebook opened in new tab")
    public void Facebook_Link_Opened()
    {
        String F_Expected_URL = "https://web.facebook.com/nopCommerce?_rdc=1&_rdr";
        String F_Actual_URL = driver.getCurrentUrl();
        Assert.assertEquals(F_Expected_URL, F_Actual_URL);
    }

    @Then("Twitter opened in new tab")
    public void Twitter_Tab_Opened()
    {
        String T_Expected_URL = "https://twitter.com/nopCommerce";
        String T_Actual_URL = driver.getCurrentUrl();
        Assert.assertEquals(T_Expected_URL, T_Actual_URL);
    }

    @Then("Rss opened in new tab")
    public void Rss_Tab_Opened()
    {
        String R_Expected_URL = "https://demo.nopcommerce.com/news/rss/1";
        String R_Actual_URL = driver.getCurrentUrl();
        Assert.assertEquals(R_Expected_URL, R_Actual_URL);
    }

    @Then("Youtube opened in new tab")
    public void Youtube_Link_Opened()
    {
        String Y_Expected_URL = "https://www.youtube.com/user/nopCommerce";
        String Y_Actual_URL = driver.getCurrentUrl();
        Assert.assertEquals(Y_Expected_URL, Y_Actual_URL);
    }

    @After("@FollowUs")
    public void Close()
    {
        driver.quit();
    }

}
