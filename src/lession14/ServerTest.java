package lession14;

import Driver.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class ServerTest {
    public static void main(String[] args) throws InterruptedException {
        //Start appium
        DriverFactory.startAppiumServer();
        try {
            AndroidDriver<MobileElement> appiumDriver = DriverFactory.getAndroidDriver();

            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();

            MobileElement userNameTbx = appiumDriver.findElementByAccessibilityId("input-email");
            userNameTbx.sendKeys("ando@test.com");

            MobileElement passwordTbx = appiumDriver.findElementByAccessibilityId("input-password");
            passwordTbx.sendKeys("TeoDo");

            MobileElement loginBtn = appiumDriver.findElementByAccessibilityId("button-LOGIN");
            passwordTbx.click();

            Thread.sleep(2000);
            //Press Back button
            appiumDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));

        }finally {
            //Stop appium
            DriverFactory.stopAppiumServer();
        }
    }
}
