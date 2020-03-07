package com.automation.utilities;

public class BrowserUtils {

    public static void wait(int seconds){
        try{
            Thread.sleep(1000 * seconds);
        }catch (InterruptedException e){
            e.printStackTrace(); // printStackTrace() : it's a message in console showing the entire history of what exceptions occurred and what classes were involved
            // so printStackTrace() is method for every Exception, right? just to show where what happened
            // throws usually issues warning
        }
    }
}
