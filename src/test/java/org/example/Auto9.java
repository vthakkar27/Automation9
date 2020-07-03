package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Auto9 {
  static  WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       // WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("vaishali");

        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Thakkar");

         String actualText= driver.findElement(By.xpath("//div/strong")).getText();

        System.out.println(actualText);

    }
}
