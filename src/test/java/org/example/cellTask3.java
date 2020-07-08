package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class cellTask3 {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Electronics")).click();
        driver.findElement(By.linkText("Cell phones")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/input[1]")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.linkText("HTC One Mini Blue")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@class=\"button-1 add-to-cart-button valid\"]")).click();
        //driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/input[1]")).click();
        //driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div/div[2]/div[3]/div[2]/input[1]")).click();
        driver.findElement(By.linkText("Shopping cart")).click();
        String pageText = driver.findElement(By.linkText("HTC One M8 Android L 5.0 Lollipop")).getText();
        System.out.println(pageText);
         pageText = driver.findElement(By.linkText("HTC One Mini Blue")).getText();
         System.out.println(pageText);
    }
}