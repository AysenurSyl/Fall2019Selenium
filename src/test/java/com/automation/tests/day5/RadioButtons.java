package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2); // we already handled this exception inside of the method(Browserutils)
        // it is a static method, we should call it by class name since we're in different package

        // <input type="radio" id="red" name="color">
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton : radioButtons) {
            // isEnabled to check if button can be clicked
            // if button is eligible to click
            // return true if you can click on the button
            String id = radioButton.getAttribute("id");

            // below line will return true, if button already clicked, other wise return false
            boolean isSelected = radioButton.isSelected();
            System.out.println(id + " is selected? " + isSelected);

            // if we see id as locator, just go with it
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("Clicked on :: " + id);
                BrowserUtils.wait(1);
            }else {
                System.out.println("Button is disabled, not clicked :: " + id);
            }
            System.out.println();
        }
        // System.out.println(id+"button is disabled, not clicked :: ");

        driver.close();


    }
}
