package lession15;

import Driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwipeVertically {
    public static void main(String[] args) throws InterruptedException {

        //Start appium
        DriverFactory.startAppiumServer();
        try {
            AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAndroidDriver();

            MobileElement formLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            formLabel.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView[@content-desc=\"Forms-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")));

            //Get Mobile window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenWidth = windowSize.getWidth();
            int screenHeight = windowSize.getHeight();

            //Calculate touch point
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;
            int yStartPoint = 90 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;

            //Convert to PointOptions - Coordinates
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint,yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint,yEndPoint);

            //Perform Touch actions
            TouchAction touchAction = new TouchAction(appiumDriver);
            touchAction.press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .moveTo(endPoint)
                    .release()
                    .perform();


            MobileElement activeBtn = appiumDriver.findElementByAccessibilityId("button-Active");
            activeBtn.click();

        }finally {
            //Stop appium
            DriverFactory.stopAppiumServer();
        }
    }
}
