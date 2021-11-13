package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;

import java.time.Duration;

public class SwipeUtils {

    private static void swipe(AppiumDriver<MobileElement> appiumDriver, Point startPointCoor, Point endPointCoor) {
        PointOption startPoint = new PointOption().withCoordinates(startPointCoor);
        PointOption endPoint = new PointOption().withCoordinates(endPointCoor);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint).release().perform();
    }

    private static void longSwipe(AppiumDriver<MobileElement> appiumDriver, Point startPointCoor, Point endPointCoor) {
        PointOption startPoint = new PointOption().withCoordinates(startPointCoor);
        PointOption endPoint = new PointOption().withCoordinates(endPointCoor);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.longPress(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint).release().perform();
    }

    public static void swipe(AppiumDriver<MobileElement> appiumDriver, SwipeType swipeType){
        int xStartPoint = 0, xEndPoint = 0, yStartPoint = 0, yEndPoint = 0;
        //Get Mobile window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenWidth = windowSize.getWidth();
        int screenHeight = windowSize.getHeight();

        //Calculate touch point
        switch (swipeType){
            case UP:
                xStartPoint = 50 * screenWidth / 100;
                xEndPoint = 50 * screenWidth / 100;
                yStartPoint = 10 * screenHeight / 100;
                yEndPoint = 80 * screenHeight / 100;
                break;
            case DOWN:
                xStartPoint = 50 * screenWidth / 100;
                xEndPoint = 50 * screenWidth / 100;
                yStartPoint = 80 * screenHeight / 100;
                yEndPoint = 10 * screenHeight / 100;
                break;
            case LEFT:
                xStartPoint = 10 * screenWidth / 100;
                xEndPoint = 80 * screenWidth / 100;
                yStartPoint = 50 * screenHeight / 100;
                yEndPoint = 50 * screenHeight / 100;
                break;
            case RIGHT:
                xStartPoint = 80 * screenWidth / 100;
                xEndPoint = 10 * screenWidth / 100;
                yStartPoint = 50 * screenHeight / 100;
                yEndPoint = 50 * screenHeight / 100;
                break;
            default:
                break;
        }

        //Perform Touch actions
        swipe(appiumDriver, new Point(xStartPoint, yStartPoint), new Point(xEndPoint, yEndPoint));
    }

    public static void swipe(AppiumDriver<MobileElement> appiumDriver, By by, SwipeType swipeType){
        //Get Mobile window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenWidth = windowSize.getWidth();
        int screenHeight = windowSize.getHeight();
        //Get element coordinate
        MobileElement element = appiumDriver.findElement(by);
        Point elementPoint = element.getLocation();
        int x = elementPoint.getX();
        int y = elementPoint.getY();
        switch (swipeType){
            case DOWN:
                swipe(appiumDriver, elementPoint, new Point(x, screenHeight));
                break;
            case UP:
                swipe(appiumDriver, elementPoint, new Point(x, 0));
                break;
            case LEFT:
                swipe(appiumDriver, elementPoint, new Point(0, y));
                break;
            case RIGHT:
                swipe(appiumDriver, elementPoint, new Point(screenWidth, y));
                break;
        }
    }

    public static void swipeUntilTextDisplay(AppiumDriver<MobileElement> appiumDriver, String text, SwipeType swipeType, int swipeTime){
        for (int i = 0; i < swipeTime; i++) {
            swipe(appiumDriver, swipeType);
            if(appiumDriver.getPageSource().contains(text)){
                return;
            }
        }
        throw new NoSuchElementException(String.format("There is no text '%s' displayed after %d times swipe",text, swipeTime));
    }

    public static void swipeUntilTextDisplay(AppiumDriver<MobileElement> appiumDriver, String text, SwipeType swipeType){
        swipeUntilTextDisplay(appiumDriver, text, swipeType, 5);
    }

    public static void swipeUntilElementDisplay(AppiumDriver<MobileElement> appiumDriver, By by, SwipeType swipeType, int swipeTime){
        for (int i = 0; i < swipeTime; i++) {
            swipe(appiumDriver, swipeType);
            if(appiumDriver.findElements(by).size() > 0){
                return;
            }
        }
        throw new NoSuchElementException(String.format("There is no element '%s' displayed after %d times swipe",by.toString(), swipeTime));
    }

    public static void swipeUntilElementDisplay(AppiumDriver<MobileElement> appiumDriver, By by, SwipeType swipeType){
        swipeUntilElementDisplay(appiumDriver, by, swipeType, 5);
    }

    public static void swipeUntilElementText(AppiumDriver<MobileElement> appiumDriver, By by, String text, SwipeType swipeType, int swipeTime) {
        for (int i = 0; i < swipeTime; i++) {
            swipe(appiumDriver,by, swipeType);
            System.out.println(appiumDriver.findElement(by).getText());
            if(appiumDriver.findElement(by).getText().equals(text)){
                return;
            }
        }
        throw new NoSuchElementException(String.format("There is no element has text '%s' displayed after %d times swipe",by.toString(), swipeTime));
    }
    public static void swipeUntilElementText(AppiumDriver<MobileElement> appiumDriver, By by, String text, SwipeType swipeType) {
        swipeUntilElementText(appiumDriver, by, text, swipeType, 5);
    }

    public enum SwipeType{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
