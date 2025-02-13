

package com.mumzworld.test;

import com.mumzworld.base.BaseTest;
import com.mumzworld.pages.PageObjects;
import org.testng.annotations.Test;

public class MumzworldTest extends BaseTest {

    @Test
    public void testEcommerceFlow() {
        
    	PageObjects page = new PageObjects(driver);
        page.closePopupIfVisible();
        page.searchForProduct("Eazy Kids - Stegaurous Backpack and Bento Lunch Box - Green");   
        page.addToCart();
        page.cartCheckout();
        page.addQty(5);
        page.proceedCheckout();
    }

	
}
