package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        // every window has some id, this id calls window handle
        // based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);

        // CDwindow-0BDAD20853F87BA77A5A516CE6E1DEBF => this id represent particular window. By using this id, we can switch to another window.

        // getWindowHandles() - returns id's of all currently opened windows
        // Set - because doesn't allow duplicates
        Set<String> windowHandles = driver.getWindowHandles(); // to get all window handles

        System.out.println(windowHandles);
        System.out.println("BEFORE SWITCH :" + driver.getCurrentUrl());
        // result => [CDwindow-F2CE5E325E02574AAD911A6E3DE5646F, CDwindow-390E0F83864384C04FC589601370E23B] => represent two window ids currently opened in browser

        // since we have all windows
        // and we know id of original window
        // we can say switch to something that is not equals to old window
        // to switch to another window => .switchTo()
        // but we need to say where exactly to switch

        for (String windowId : windowHandles) {
            // if it's not an old window, then switch
            if (!windowId.equals(windowHandle)){
                // to switch(jump) to new window
                driver.switchTo().window(windowId);
            }
        }

        System.out.println("AFTER SWITCH :" + driver.getCurrentUrl());

        driver.close();
    }

    /**
     *
     * This method helps to switch in between windows based on page title
     * @param pageTitle
     * @param driver
     */

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}
