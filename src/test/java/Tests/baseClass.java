package Tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class baseClass {

    static AppiumDriver<MobileElement> driver;
    //static AppiumDriver driver;
    @BeforeTest
    public AppiumDriver<MobileElement> setup() {
        File fs=new File("src\\resources");
        //File f=new File(fs,"ApiDemos-debug.apk");
        File f=new File(fs,"ApiDemo.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
        //cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "krina1");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        cap.setCapability(MobileCapabilityType.APPLICATION_NAME, "60");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
       // cap.setCapability("chromedriverExecutable","C:\\Test cases\\chromedriver_win32");
        try {

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
           driver = new AppiumDriver<MobileElement>(url, cap);
            //driver = new AppiumDriver(url, cap);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return driver;
    }



    @AfterTest
    public void tearDown(){
        driver.quit();

    }
}
