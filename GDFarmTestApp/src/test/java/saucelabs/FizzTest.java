package saucelabs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

//import java.io.File;
import java.net.URL;
import java.text.MessageFormat;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import static org.junit.Assert.assertEquals;

public class FizzTest {

    private AppiumDriver<WebElement> driver;
    private WebElement btn;
    private WebElement lbl;
    private WebElement txt;

    private final String sauceUserName = "rjgumby";
    private final String sauceAccessKey = "0dee5fe6-577e-46ce-8637-c1f97d4682b2";

    @Before
    public void setUp() throws Exception {
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "build/outputs/apk/");
//        File app = new File(appDir, "GDFarmTestApp-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("app", "https://github.com/lysenkoivan/GDFarmTestingProject/blob/build_files/GDFarmTestApp-debug.apk");
        capabilities.setCapability("app-package", "com.griddynamics.khqacop.gdfarmtestingproject");
//        capabilities.setCapability("appActivity", "MainActivity");
//        capabilities.setCapability("appiumVersion", "1.3.4");
//        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new AndroidDriver<>(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub",
                                    sauceUserName, sauceAccessKey)),
                capabilities);

        this.btn = driver.findElement(By.id("btnMain"));
        this.lbl = driver.findElement(By.id("lblText"));
        this.txt = driver.findElement(By.id("txtField"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testInit(){
        assertEquals("Hello World!", lbl.getText());
        assertEquals("", txt.getText());
        assertEquals("Click Me!", btn.getText());
    }

}
