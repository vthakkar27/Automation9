package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;


public class Auto9 {
    static WebDriver driver;


    //reusable method to wait until element is clickable
    public static void waitUntilElementIsClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void clickOnElement(By by,int time) {
        driver.findElement(by).click();
    }
    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public static long timestamp() {
        return (System.currentTimeMillis());
    }
    public static String getTextFromElement(By by)
    {
       return driver.findElement(by).getText();
    }
    public  static void selectFromDropDownByVisibleText(By by,String text){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    public static void selectFromDropDownByVisibleIndex(By by,int n){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(n);
            }
            public static void selectFromDropDownByValue(By by,String Value){
                Select select = new Select(driver.findElement(by));
                select.selectByValue(Value);
            }
            //creating Clickable method for driver to click on element
    public static void waitUntilElementToClickble(By by) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(by));

    }
    @BeforeMethod

    public static void initialiseMethod () {
      //setting up chrom driver path
      System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver\\chromedriver.exe");
      //creating object to open chrome driver
      ChromeOptions options = new ChromeOptions();
      options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
      driver = new ChromeDriver(options);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
      // WebDriver driver = new ChromeDriver(options);
              }
     @AfterMethod
     public static void closingMethod(){
        driver.close();}

      @Test

      public static void registration ()
      {
        //driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
        //driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("vaishali");
       // driver.findElement(By.cssSelector("input#LastName")).sendKeys("Thakkar");
        // String actualText= driver.findElement("By.xpath("//div/strong")").getText();

        // String expectedRegisterPageText = "Your Personal Detail";
      //  String actualOnRegisterPageText= getTextFromElement(By.xpath("By.xpath(\"//div/strong\")"));
     // Assert.assertEquals(actualOnRegisterPageText,expectedRegisterPageText,"Registe page is not Opened");
          // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

      clickOnElement(By.linkText("Register"),30);  // Starting registration process
      clickOnElement(By.xpath("//input[@id=\"gender-female\"]"),40);
      typeText(By.id("FirstName"),"Vaishali");
      typeText(By.cssSelector("input#LastName"),"Thakkar");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      selectFromDropDownByVisibleIndex(By.xpath("//select[@name='DateOfBirthDay']"),8);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      selectFromDropDownByVisibleText(By.xpath("//select[@name='DateOfBirthMonth']"),"October");
      selectFromDropDownByValue(By.xpath("//select[@name='DateOfBirthYear']"),"1980");
          //using Timestamp method to use same email address
      typeText(By.name("Email"),"dasvthakkar27+"+timestamp()+"@gmail.com");
      typeText(By.id("Company"),"Devam10");
      typeText(By.id("Password"),"123das");
      typeText(By.id("ConfirmPassword"),"123das");
      clickOnElement(By.id("register-button"),20);

          String expectedText = "Your registration completed";//user should be able to register on nopcommerce.com
          String actualText = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
                Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public static void Computer(){
        registration(); //calling Registration method to send email to friend
        clickOnElement(By.linkText("Computers"),20);
        clickOnElement(By.linkText("Desktops"),20);
        clickOnElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC"),20); //selecting item to email friend
        clickOnElement(By.xpath("//input[@value=\"Email a friend\"]"),20);
        typeText(By.xpath("//input[@id=\"FriendEmail\"]"),"jaiswaminarayan2020@yahoo.com"); //Friend email address
        typeText(By.xpath("//input[@id=\"YourEmailAddress\"]"),"dasvthakkar27@gmail.com"); //user email address
        typeText(By.xpath("//textarea[@id=\"PersonalMessage\"]"),"Happy Rakshabandhan"); //Sending email with personal message
        clickOnElement(By.xpath("//input[@name=\"send-email\"]"),20);
        String expectedText = "Digital Storm VANQUISH 3 Custom Performance PC";
        String actualText = getTextFromElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC"));
        Assert.assertEquals(actualText,expectedText);


    }
    @Test
    //Method for adding books to cart
    public static void Books(){
      //  waitUntilElementToClickble(By.linkText("Books"));
        clickOnElement(By.linkText("Books"),30);//
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div/div[2]/div[3]/div[2]/input[1]"),30);//adding "First prize book in cart
       clickOnElement(By.linkText("Fahrenheit 451 by Ray Bradbury"),40);//clicking on Bradbury book
        clickOnElement(By.xpath("//input[@id=\"add-to-cart-button-37\"]"),30);//adding Bradbury book in cart
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        clickOnElement(By.linkText("Shopping cart"),30);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String expectedText = ("Fahrenheit 451 by Ray Bradbury");
        String actualText = getTextFromElement(By.linkText("Fahrenheit 451 by Ray Bradbury"));
        Assert.assertEquals(actualText,expectedText);
        String expectedText1 = ("First Prize Pies"); //
        String actualText1 = getTextFromElement(By.linkText("First Prize Pies"));
        Assert.assertEquals(actualText1,expectedText1);


    }
}

