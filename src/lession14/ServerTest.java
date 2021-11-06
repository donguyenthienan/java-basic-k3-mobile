package lession14;

import caps.MobileCapabilityTypeEx;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Locale;

public class ServerTest {
    public static void main(String[] args) {
        //Start appium
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withIPAddress("127.0.0.1").usingAnyFreePort();
        AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumServer.start();

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.UDID, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE, "com.wdiodemoapp");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.NEW_COMMAND_TIMEOUT, 120);

        AppiumDriver<MobileElement> appiumDriver = new AndroidDriver<>(appiumServer.getUrl(), desiredCapabilities);
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //Stop appium

        String killNodeWindowsCmd = "taskkill /F /IM node.exe";
        String killNodeLinuxCmd = "killall node";
        String killNodeCmd = System.getProperty("os.name").toLowerCase().startsWith("windows")
                ? killNodeWindowsCmd : killNodeLinuxCmd;
        Runtime runtime = Runtime.getRuntime();
        try{
            runtime.exec(killNodeCmd);
        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
