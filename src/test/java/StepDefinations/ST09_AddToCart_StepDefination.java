package StepDefinations;

import Pages.CellPhone_Page;
import Pages.Home_Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ST09_AddToCart_StepDefination {

    WebDriver driver ;
    Home_Page home;
    CellPhone_Page phone;
    SoftAssert soft;


    @Given("Open Browser On HomePage")
    public void UserOpensBrowserOnHomePage()
        {
            String Chrome_Path ;
            Chrome_Path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver",Chrome_Path);
            driver = new ChromeDriver();
            phone = new CellPhone_Page(driver);
            driver.manage().window().maximize();
            home = new Home_Page(driver);
            driver.navigate().to("https://demo.nopcommerce.com/");
        }

        @And("user open CellPhone page")
    public void NavigateToCellPhone()
        {
            driver.navigate().to("https://demo.nopcommerce.com/cell-phones");
        }

        @When("user click on AddToCart button Nokia Lumia 1020 phone")
    public void Add_NokiaLumia_ToCart() throws InterruptedException
        {
            phone.Add_NokiaLumia1020_To_Cart_BTN().click();
            TimeUnit.SECONDS.sleep(3);
        }

        @When("user click on AddToCart button HTC One Mini Blue phone to Add cart")
    public void Add_HTC_One_Mini_ToCart() throws InterruptedException
    {
        phone.Add_HTC_OneMini_To_Cart_BTN().click();
        TimeUnit.SECONDS.sleep(3);
    }

    @And("HTC One Mini Blue phone should be added to Cart successfully")
    public void HTC_ONE_MiniBlue_AddedToAddCart() throws InterruptedException
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
        //driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
        home.AddToCart_Link().click();
        TimeUnit.SECONDS.sleep(3);
        soft.assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[2]/a/img")).isDisplayed());
        soft.assertAll();
    }

    @And("Nokia Lumia 1020 phone should be added to cart Page successfully")
    public void NokiaLumia_AddedToCart_Successfully() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        home.AddToCart_Link().click();
        TimeUnit.SECONDS.sleep(3);
        soft = new SoftAssert();
        soft.assertTrue(driver.
                        findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[2]/a/img")).isDisplayed()
                ,"Assertion Fail HTC Mini image not found");
        soft.assertAll();
    }


        @Then("Notification success message should be displayed when Add success")
    public void Notification_MSG_appeared()
        {
            String Expected_MSG = "The product has been added to your shopping cart";
            String Actual_MSG = phone.CellPhone_Notification_MSG().getText();
            soft = new SoftAssert();
            soft.assertTrue(Actual_MSG.contains(Expected_MSG),"First Assertion fail , MSG is not as expected");
            soft.assertAll();
        }

        @And("Notification success message color is green when Add success")
    public void Notification_Green_OnSuccess() throws InterruptedException
        {
            phone.CellPhone_Notification_MSG().getCssValue("background-color");
            String Expected_Color = "rgba(75, 176, 122, 1)";
            TimeUnit.SECONDS.sleep(1);
            String Actual_Color = phone.CellPhone_Notification_MSG().getCssValue("background-color");
            soft = new SoftAssert();
            soft.assertEquals(Actual_Color,Expected_Color,"second Assertion Fail Color is not Green");
            soft.assertAll();
        }



        @And("user add another Nokia Lumia 1020 phone, the count should increased")
    public void Add_Another_nokiaLumia_ToCart() throws InterruptedException
        {
            driver.navigate().to("https://demo.nopcommerce.com/cell-phones");
            TimeUnit.SECONDS.sleep(3);
            Add_NokiaLumia_ToCart();
            driver.navigate().to("https://demo.nopcommerce.com/");
            home.AddToCart_Link().click();
            TimeUnit.SECONDS.sleep(3);
            WebElement LumiaItemCount = driver.
                    findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input"));
            String actualCount_NokiaLumia = LumiaItemCount.getAttribute("value");
            String expectedCount_NokiaLumia = "2";
            soft.assertEquals(expectedCount_NokiaLumia, actualCount_NokiaLumia);
            soft.assertAll();
        }

    @And("user add another HTC Mini phone, the count should increased")
    public void Add_Another_HTC_Mini_ToCart() throws InterruptedException
    {
        driver.navigate().to("https://demo.nopcommerce.com/cell-phones");
        TimeUnit.SECONDS.sleep(3);
        Add_HTC_One_Mini_ToCart();
        driver.navigate().to("https://demo.nopcommerce.com/");
        home.AddToCart_Link().click();
        TimeUnit.SECONDS.sleep(3);
        WebElement HTCItemCount = driver.
                findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[5]/input"));
        String actualCount_HTC = HTCItemCount.getAttribute("value");
        String expectedCount_HTC = "2";
        soft.assertEquals(expectedCount_HTC, actualCount_HTC);
        soft.assertAll();
    }

    @After("@Add_Cart")
    public void CloseBrowser()
    {
        driver.quit();
    }
}
