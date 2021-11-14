package lesson16;

import Driver.DriverFactory;
import Utilities.SwipeUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HybridTest {
    public static void main(String[] args) {
        //Start appium
        DriverFactory.startAppiumServer();
        try {
            AppiumDriver<MobileElement> appiumDriver = DriverFactory.getAndroidDriver();

            MobileElement webviewLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Webview"));
            webviewLabel.click();

            appiumDriver.getContextHandles().forEach(context -> System.out.println(context));

            //Switch to webview context
            appiumDriver.context("WEBVIEW_com.wdiodemoapp");
            WebElement navToggleBtnEle = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnEle.click();



        }finally {
            //Stop appium
            DriverFactory.stopAppiumServer();
        }
    }
}
