package StepDefinations;

import Pages.Home_Page;
import Pages.Register_Page_Elements;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


public class ST01_Register_StepDefination {

    WebDriver driver = null;
    Register_Page_Elements Register;
    Select selectDay;
    Select selectMonth;
    Select selectYear;
    SoftAssert soft;
    Home_Page home;

    @Given("user Open the browser to register")
    public void User_Open_Browser()
    {
        String Chrome_Path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",Chrome_Path);
        driver = new ChromeDriver();
        Register = new Register_Page_Elements(driver);
        home = new Home_Page(driver);
        driver.manage().window().maximize();
    }

    @Given("user navigate to Home page")
    public void HomeNavigation(){
        driver.navigate().to("https://demo.nopcommerce.com");
    }


    @And("user navigate to register page")
    public void Navigate_RegisterPage()
    {
        home.Register_Link().click();
    }

    @When("^user enter valid data, first name is \"(.*)\" , last name is \"(.*)\", email is \"(.*)\", company is \"(.*)\", password is \"(.*)\" and confirm password is \"(.*)\"$")
    public void Register_ValidData(String first_Name, String last_Name, String email, String company, String password, String confirm_Password) {

        Register.male_Gender().click();
        Register.first_Name().sendKeys(first_Name);
        Register.last_Name().sendKeys(last_Name);

        selectDay = new Select(Register.day_BirthDate());
        selectDay.selectByVisibleText("25");
        selectMonth = new Select(Register.month_BirthDate());
        selectMonth.selectByVisibleText("January");
        selectYear = new Select(Register.year_BirthDate());
        selectYear.selectByVisibleText("1983");

        Register.email_Txt().sendKeys(email);
        Register.company_Txt().sendKeys(company);
        Register.password_Txt().sendKeys(password);
        Register.confirmPassword_Txt().sendKeys(confirm_Password);
    }

    @And("user click on Register Button")
    public void Click_Reg_BTN() {
        Register.register_BTN().click();
    }

    @Then("user Registration Successfully")
    public void Register_Successfully() {
        String ExpectedMsg = "Your registration completed" ;
        String ActualMsg = Register.reg_Success_Msg().getText();
        String Expected_Color = "rgba(76, 177, 124, 1)";
        String Actual_Color = Register.reg_Success_Msg().getCssValue("color");
        String Expected_Url = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
        String Actual_Url = driver.getCurrentUrl();

        soft = new SoftAssert();
        soft.assertTrue(ActualMsg.contains(ExpectedMsg),"First Assertion Failed , Success message does not appeared");
        soft.assertEquals(Actual_Color,Expected_Color);
        soft.assertEquals(Actual_Url,Expected_Url);
        soft.assertAll();
    }

    @After("@Register")
    public void end() {
        driver.quit();
    }
}

