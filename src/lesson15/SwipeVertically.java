package lesson15;

import Driver.DriverFactory;
import Utilities.SwipeUtils;
import Utilities.SwipeUtils.SwipeType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwipeVertically {
    public static void main(String[] args) throws InterruptedException {

        //Start appium
        DriverFactory.startAppiumServer();
        try {
            AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAndroidDriver();
            WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Forms")));

            MobileElement formLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            formLabel.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView[@content-desc=\"Forms-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")));

            //Perform Touch actions
            SwipeUtils.swipe(appiumDriver, SwipeType.DOWN);

            formLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            formLabel.click();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Swipe-screen")));

            //Perform Touch actions to find logo
            SwipeUtils.swipeUntilElementDisplay(appiumDriver,MobileBy.AccessibilityId("WebdriverIO logo"), SwipeType.DOWN);

        }finally {
            //Stop appium
            DriverFactory.stopAppiumServer();
        }
    }
}
