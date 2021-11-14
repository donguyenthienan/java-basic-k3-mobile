package lesson15;

import Driver.DriverFactory;
import Utilities.SwipeUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwipeHorizontally {
    public static void main(String[] args) throws InterruptedException {

        //Start appium
        DriverFactory.startAppiumServer();
        try {
            AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAndroidDriver();

            MobileElement formLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            formLabel.click();


            WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Swipe-screen")));
            SwipeUtils.swipeUntilElementText(appiumDriver, By.xpath("//android.view.ViewGroup[@content-desc=\"slideTextContainer\"]/android.widget.TextView[1]"),"SUPPORT VIDEOS", SwipeUtils.SwipeType.LEFT);

        }finally {
            //Stop appium
            DriverFactory.stopAppiumServer();
        }
    }
}
