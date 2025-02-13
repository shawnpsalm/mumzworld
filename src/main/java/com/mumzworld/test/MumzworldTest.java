

package com.mumzworld.test;

import com.mumzworld.base.BaseTest;
import com.mumzworld.pages.HomePage;
import org.testng.annotations.Test;

public class MumzworldTest extends BaseTest {

    @Test
    public void testEcommerceFlow() {
        
        HomePage homePage = new HomePage(driver);
        homePage.closePopupIfVisible();
        homePage.searchForProduct("Eazy Kids - Stegaurous Backpack and Bento Lunch Box - Green");        
    }

	
}
