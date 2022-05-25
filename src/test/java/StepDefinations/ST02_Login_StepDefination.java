package StepDefinations;

import Pages.Home_Page;
import Pages.Login_Page_Elements;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class ST02_Login_StepDefination {
    WebDriver driver = null;
    Login_Page_Elements Login;
    SoftAssert soft;
    Home_Page LoginLink;

    // by using annotation we link between feature file lines and the related code here ( step defination )
    @Given("user open the browser")
    public void Open_Browser()
    {
        // bridge between test script and browser
        String Chrom_path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",Chrom_path);
        // new object of web driver
        driver = new ChromeDriver();
        // Navigate to desired URL
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        Login = new Login_Page_Elements(driver);
        LoginLink = new Home_Page(driver);

    }

    @And("user navigate to the login page")
    public void Navigate_To_Login_URL()
    {
        LoginLink.Login_Link().click();
    }

    @When("^user enter Valid Data vaild Email is \"(.*)\" , valid Password is \"(.*)\"$")
    public void Login_With_Valid_Data(String Login_Email , String Password){

        Login.LoginSteps(Login_Email,Password);
    }


    @When("^user enter Invalid Login Data inavlid email is \"(.*)\" , invalid Password is \"(.*)\"$")
    public void Login_With_Invalid_Data(String Email , String Password) {
        Login.LoginSteps(Email,Password);
    }

    @And("user click on login button")
    public void Click_On_Login_BTN() throws InterruptedException
    {
        Login.LoginBTN().click();
        TimeUnit.SECONDS.sleep(3);
    }

    // compare actual with expected
    @Then("user could login successfully")
    public void Success_Login()
    {
        String Expected_URL = "https://demo.nopcommerce.com/";
        String Actual_URL = driver.getCurrentUrl();

        soft = new SoftAssert();
        soft.assertEquals(Actual_URL,Expected_URL);        // first assertion the url after login same as expected
        soft.assertTrue(Login.MyAccount().isDisplayed());  // second assertion MyAccount is appeared after login
        soft.assertAll();

   }

    @Then("user could Not login successfully")
    public void Wrong_Login() throws InterruptedException {

        soft = new SoftAssert();

        String ExpectedErrMsg = "Login was unsuccessful. Please correct the errors and try again.";
        String ActualErrMsg =  Login.Wrong_Login_Err_Msg().getText();  // get the message appeared
        TimeUnit.SECONDS.sleep(3);
        //String Expected_URL = "https://demo.nopcommerce.com/login";
        //String Actual_URL = driver.getCurrentUrl();

        //soft.assertEquals(Actual_URL,Expected_URL,"First assertion  Fail");  // first assertion
        soft.assertTrue(ActualErrMsg.contains(ExpectedErrMsg),"Second assertion faild");  // second assertion , actual error message contain expected error mgs

        soft.assertAll();
    }

    @And("user directed to the home page")
    public void Direct_to_homePage()
    {
        String Expected_URL = "https://demo.nopcommerce.com/";
        String Actual_URL = driver.getCurrentUrl();

        soft.assertEquals(Actual_URL,Expected_URL,"direction to home page after login is faild");
    }

    // after each Test case this after will execute , and its also execute in case of tc failure in any steps
    @After("@Login")
    public void Close_Driver()
    {
        driver.quit();
    }
}
