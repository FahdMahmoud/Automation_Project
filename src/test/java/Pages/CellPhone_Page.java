package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CellPhone_Page {

    WebDriver driver;

    public CellPhone_Page(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement Add_HTC_M8_WishList()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[3]"));
    }

    public WebElement Add_HTC_Mini_WishList()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[3]"));
    }

    public WebElement CellPhone_Notification_MSG()
    {
        return driver.findElement(By.xpath("/html/body/div[5]/div"));
    }

    public WebElement Wishlist_Link_On_SuccessMSG()
    {
        return driver.findElement(By.xpath("/html/body/div[5]/div/p/a"));
    }

    public WebElement Add_NokiaLumia1020_To_Cart_BTN()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]"));
    }

    public WebElement Add_HTC_OneMini_To_Cart_BTN()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]"));
    }


}
