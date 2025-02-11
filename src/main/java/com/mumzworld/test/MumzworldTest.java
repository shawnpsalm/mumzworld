

package com.mumzworld.test;

import com.mumzworld.base.BaseTest;
import com.mumzworld.pages.HomePage;
import org.testng.annotations.Test;

public class MumzworldTest extends BaseTest {

    @Test
    public void testEcommerceFlow() {
        driver.get("https://mumzworld.com/");

        // Step 1: Search for a product
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct("Eazy Kids - Stegaurous Backpack and Bento Lunch Box - Green");

        // Step 6: Register a new user (you would add code to fill out the registration form)
    }
}
