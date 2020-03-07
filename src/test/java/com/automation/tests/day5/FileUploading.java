package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);


        WebElement upload = driver.findElement(By.id("file-upload"));
        // https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        // I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+ "/pom.xml";
        // We can add some files from our computer. Right click on file and copy as path name, then paste :
        String file2Path = "/Users/aysesoylu/Downloads/OOP Presentation File Group 6.pdf";

        // to upload file in Selenium: you need to use sendKeys() method and provide path to the file

        upload.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click(); // click to upload

        BrowserUtils.wait(5);
        driver.quit();
    }
}
