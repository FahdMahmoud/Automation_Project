package StepDefinations;

import Pages.CellPhone_Page;
import Pages.Home_Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ST08_WishList_StepDefination {

    WebDriver driver;
    CellPhone_Page phones;
    SoftAssert soft;
    Home_Page home;

    @When("Open Browser")
    public void OpenBrowser()
    {
        String Chrome_Path ;
        Chrome_Path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",Chrome_Path);
        driver = new ChromeDriver();
        phones = new CellPhone_Page(driver);
        driver.manage().window().maximize();
        home = new Home_Page(driver);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user open CellPhone")
            public void CellPhone()
    {
        driver.navigate().to("https://demo.nopcommerce.com/cell-phones");
    }

    @And("Add HTC ONE M8 phone to Wish List")
    public void Add_HTC_M8_ToWishList() throws InterruptedException
    {
        phones.Add_HTC_M8_WishList().click();
        TimeUnit.SECONDS.sleep(3);
    }

    @And("Add HTC One Mini Blue phone to Wish List")
    public void Add_HTC_Mini_ToWishList() throws InterruptedException
    {
        phones.Add_HTC_Mini_WishList().click();
        TimeUnit.SECONDS.sleep(3);
    }

    @Then("Notification success message should be displayed")
    public void Notification_Msg()
    {
        String Expected_MSG = "The product has been added to your wishlist";
        String Actual_MSG = phones.CellPhone_Notification_MSG().getText();
        soft = new SoftAssert();
        soft.assertTrue(Actual_MSG.contains(Expected_MSG),"First Assertion fail , MSG is not as expected");
        soft.assertAll();
    }

    @And("Notification success message color is green")
    public void Notification_Color_Is_Green() throws InterruptedException
    {
        phones.CellPhone_Notification_MSG().getCssValue("background-color");
        String Expected_Color = "rgba(75, 176, 122, 1)";
        TimeUnit.SECONDS.sleep(1);
        String Actual_Color = phones.CellPhone_Notification_MSG().getCssValue("background-color");
        soft = new SoftAssert();
        soft.assertEquals(Actual_Color,Expected_Color,"second Assertion Fail Color is not Green");
        soft.assertAll();
    }

    @And("HTC ONE M8 phone should be added to WishList Page")
    public void HTC_ONE_M8_AddedToWishList() throws InterruptedException
    {
        phones.Wishlist_Link_On_SuccessMSG().click();
        TimeUnit.SECONDS.sleep(3);
        soft.assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr[1]/td[3]/a/img")).isDisplayed());
        soft.assertAll();
    }

    @And("HTC One Mini Blue phone should be added to WishList Page")
    public void HTC_ONE_MiniBlue_AddedToWishList() throws InterruptedException
    {
        phones.Wishlist_Link_On_SuccessMSG().click();
        TimeUnit.SECONDS.sleep(3);
        soft.assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[3]/a/img")).isDisplayed());
        soft.assertAll();
    }

    @And("user add one HTC_M8 phone, the count increased")
    public void IncreaseCounter_HTC_M8_ToWishList() throws InterruptedException
    {
        driver.navigate().to("https://demo.nopcommerce.com/cell-phones");
        TimeUnit.SECONDS.sleep(3);
        Add_HTC_M8_ToWishList();
        driver.navigate().to("https://demo.nopcommerce.com/");
        home.HomePage_WishList_Link().click();
        TimeUnit.SECONDS.sleep(3);
        WebElement M8ItemCount = driver.
                findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr[1]/td[6]/input"));
        String actualCount_HTC_M8 = M8ItemCount.getAttribute("value");
        String expectedCount_HTC_M8 = "2";
        soft.assertEquals(expectedCount_HTC_M8, actualCount_HTC_M8);
        soft.assertAll();
    }

    @And("user add one HTC_Mini phone, the count increased")
    public void IncreaseCounter_HTC_Mini_ToWishList() throws InterruptedException
    {

        driver.navigate().to("https://demo.nopcommerce.com/cell-phones");
        TimeUnit.SECONDS.sleep(3);
        Add_HTC_Mini_ToWishList();
        driver.navigate().to("https://demo.nopcommerce.com/");
        home.HomePage_WishList_Link().click();
        TimeUnit.SECONDS.sleep(3);
        WebElement HTCMini_ItemCount = driver.
                findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[6]/input"));
        String actualCount_HTCMini = HTCMini_ItemCount.getAttribute("value");

        String expectedCount_HTCMini = "2";
        soft.assertEquals(expectedCount_HTCMini,actualCount_HTCMini);
        soft.assertAll();
    }

    @After("@WishList")
    public void CloseBrowser()
    {
        driver.quit();
    }

}
