package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayAmazonWikipedia {

    public static void main(String[] args) throws Exception {

        ebayTest();
        amazonTest();
        wikiTest();
    }

    /**
     * Go to ebay --->          driver.get("http://ebay.com");
     * enter search term        input.sendKeys("java book");
     * click on search button   searchButton.click();
     * print number of results
     */
//    public static void ebayTest() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://ebay.com");
//        driver.findElement(By.id("gh-ac")).sendKeys("macbook", Keys.ENTER);
//        Thread.sleep(2000);
//        driver.findElement(By.id("gh-btn")).click();
//        Thread.sleep(2000);
//        String str = driver.findElement(By.tagName("h1")).getText();
//        System.out.println("str = " + str);
//
//        driver.quit();
//    }
         // VASYL'S CODE
        public static void ebayTest(){
            WebDriver driver = DriverFactory.createDriver("chrome");
            driver.get("http://ebay.com");
            driver.findElement(By.id("gh-ac")).sendKeys("java book");
            driver.findElement(By.id("gh-btn")).click();
            WebElement searchResults = driver.findElement(By.tagName("h1"));
            System.out.println(searchResults.getText().split(" ")[0]);
            driver.quit();
        }



    /**
     * go to amazon
     * enter search term
     * click on search button
     * verify title contains search term
     */
//    public static void amazonTest(){
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://amazon.com");
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ipad", Keys.ENTER);
//        String str = driver.getTitle();
//        System.out.println(str.contains("ipad"));
//    }

    // VASYL'S CODE
    public static void amazonTest() throws Exception{
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        //enter text and click ENTER
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        Thread.sleep(2000);//to wait 2 seconds
        String title = driver.getTitle();
        if(title.contains("java book")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }


    /**
     * Go to wikipedia.org
     * enter search term `selenium webdriver`
     * click on search button
     * click on search result `Selenium (software)`
     * verify url ends with `Selenium_(software)`
     */
//    public static void wikiTest(){
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://wikipedia.com");
//        WebElement search =driver.findElement(By.name("search"));
//        search.sendKeys("Who Born Today?",Keys.ENTER);
//    }

    // VASYL'S CODE
    public static void wikiTest() throws Exception{
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Go to wikipedia.org
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        //enter search term `selenium webdriver` & click on search button
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);
        Thread.sleep(3000);
        //click on search result `Selenium (software)`
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String link = driver.getCurrentUrl(); // to get link as a String
        //verify url ends with `Selenium_(software)`
        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }
}


