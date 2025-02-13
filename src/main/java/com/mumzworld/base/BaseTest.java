
package com.mumzworld.base;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // WebDriverManager will automatically download and set up the ChromeDriver binary
        WebDriverManager.chromedriver().setup();  // For Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("prefs", Map.of("profile.default_content_setting_values.popups",2,"profile.default_content_setting_values.notifications", 2));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
