package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class Home_Page {
    WebDriver driver;

    public Home_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Register_Link()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
    }

    public WebElement Login_Link()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }

    public WebElement currencyList()
    {
        return driver.findElement(By.id("customerCurrency"));
    }

    public WebElement euro(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[1]/div/select/option[2]"));
    }

    public WebElement dollar(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[1]/div/select/option[1]"));
    }

    public WebElement Search_Store_TxtBox()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/input"));
    }

    public WebElement Search_Keyword_TxtBox()
    {
        return driver.findElement(By.id("q"));
    }

    public WebElement Search_BTN()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/button"));
    }

    // xpath of main category Computer
    public WebElement mainCategory()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
    }

    public WebElement SubCategory_Title()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"));
    }

    public WebElement Comp_Subcategory_Nootbooks()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a"));
    }

    public WebElement Sliders(Integer slide_number)
    {
        return driver.findElement(By.cssSelector("a[class=\"nivo-imageLink\"]:nth-child("+slide_number+")"));
    }

    public WebElement FaceBook_Link()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // return driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[1]/a"));
        return driver.findElement(By.cssSelector(".facebook > a:nth-child(1)"));
    }

    public WebElement Twitter_Link()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[2]/a"));
    }

    public WebElement Rss_Link()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[3]/a"));
    }

    public WebElement Youtube_Link()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[4]/div[1]/ul/li[4]/a"));
    }

    public WebElement HomePage_WishList_Link()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[1]"));
    }

    public WebElement AddToCart_Link()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[4]/a/span[1]"));
    }


}

