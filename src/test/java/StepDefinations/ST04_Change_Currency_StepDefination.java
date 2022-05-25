package StepDefinations;

import Pages.Home_Page;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ST04_Change_Currency_StepDefination {

    WebDriver driver;
    Select Euro;
    Select Dollar;
    Home_Page currency_List;
    SoftAssert soft;


    @Given("user navigate to home page")
    public void navigate_To_HomePage(){
        // bridge between test script and browser
        String ChromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",ChromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        currency_List = new Home_Page(driver);
    }

    @And("select €")
    public void select_€ () throws InterruptedException {

        Euro = new Select(currency_List.currencyList());
        Euro.selectByVisibleText("Euro");
        TimeUnit.SECONDS.sleep(4);
    }

    @Then("€ currency is selected")
    public void €_is_selected(){
        String Expected_Currency = "Euro";
        String Actual_Currency = currency_List.euro().getText();

        soft = new SoftAssert();
        soft.assertTrue((Actual_Currency.contains(Expected_Currency)),"Assertion Faild and currency was not changed");

        soft.assertAll();
    }

    @And("select US Dollar")
    public void select_$ () throws InterruptedException {

        Dollar = new Select(currency_List.currencyList());
        Dollar.selectByVisibleText("US Dollar");
        TimeUnit.SECONDS.sleep(4);
    }

    @Then("$ currency is selected")
    public void $_is_selected(){
        String Expected_Currency = "Dollar";
        String Actual_Currency = currency_List.dollar().getText();

        soft = new SoftAssert();
        soft.assertTrue((Actual_Currency.contains(Expected_Currency)),"Assertion Faild and currency was not changed");

        soft.assertAll();
    }

    @After("@Currency")
    public void Close_driver()
    {
        driver.quit();
    }

}
