package lession15;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import Driver.DriverFactory;

import java.util.concurrent.TimeUnit;

public class FormScreenTest {
    public static void main(String[] args) {
        //Start appium
        DriverFactory.startAppiumServer();
        try {
            AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAndroidDriver();
            appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();
            MobileElement formLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            formLabel.click();
        }finally {
            //Stop appium
            DriverFactory.stopAppiumServer();
        }
    }
}
