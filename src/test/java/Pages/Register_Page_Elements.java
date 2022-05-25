package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register_Page_Elements {

    WebDriver driver;

    public Register_Page_Elements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement male_Gender() {
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement female_Gender() {
        return driver.findElement(By.id("gender-female"));
    }

    public WebElement first_Name() {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement last_Name() {
        return driver.findElement(By.id("LastName"));
    }

    public WebElement day_BirthDate() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]"));
    }

    public WebElement month_BirthDate() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]"));
    }

    public WebElement year_BirthDate() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]"));
    }

    public WebElement email_Txt() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement company_Txt() {
        return driver.findElement(By.id("Company"));
    }

    public WebElement password_Txt() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassword_Txt() {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement register_BTN() {
        return driver.findElement(By.id("register-button"));
    }

    public WebElement reg_Success_Msg() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
    }

}