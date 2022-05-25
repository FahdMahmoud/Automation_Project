package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page_Elements {

    WebDriver driver ;
    Login_Page_Elements Login;

    // initilize the driver which will used by constructor class
    public Login_Page_Elements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement EmailTxtBox_PF(){
        return driver.findElement(By.id("Email"));
    }

    public WebElement PassTxtBox_PF(){
        return driver.findElement(By.id("Password"));
    }

    public WebElement LoginBTN(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
    }

    public WebElement Logout_Link(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }

    public WebElement MyAccount(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
    }

    public WebElement Wrong_Login_Err_Msg(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"));
    }

    // repeated steps grouped in one class to allow to call this class to perform what inside
    public void LoginSteps(String Login_Email,String Password)
    {
        EmailTxtBox_PF().clear();
        EmailTxtBox_PF().sendKeys(Login_Email);

        PassTxtBox_PF().clear();
        PassTxtBox_PF().sendKeys(Password);
    }




}
