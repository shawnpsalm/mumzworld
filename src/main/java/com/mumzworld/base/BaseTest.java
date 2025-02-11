
package com.mumzworld.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
