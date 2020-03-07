package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3000);

        // how to collect all links from the page?
        List<WebElement> links = driver.findElements(By.tagName("a"));
        // purple stands for => tags
        // brown =>
        // black => for text

        for (WebElement link : links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();
//            link.click();
//            Thread.sleep(2000);
//            driver.navigate().back();

        }

        for (int i = 1; i <links.size() ; i++) {

            List<WebElement> links2 = driver.findElements(By.tagName("a"));
            links2.get(i).click();
            //Thread.sleep(2000);
            driver.navigate().back();
            //Thread.sleep(2000);

        }




        driver.quit();

    }
}
