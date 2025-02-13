package com.mumzworld.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By searchBox = By.xpath("//input[@id='search_textbox']");
    private By searchButton = By.xpath("//button[@id='search_btn']");
    private By popupCloseButton = By.xpath("\"//div[@id='close' and @class='close']\"");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopupIfVisible() {
        try {
            // Wait until the popup is visible and close it
        	driver.get("https://mumzworld.com/");
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ct-web-popup-imageonly")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //ShadowRoot shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
            //ShadowRoot shadowRoot = (ShadowRoot) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost);
            WebElement closeButton = (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector('#close')", shadowHost);
            //WebElement closeButton = shadowRoot.findElement(By.id("close"));
            wait.until(ExpectedConditions.elementToBeClickable(closeButton));
            closeButton.click();  
        } 
       catch (Exception e) {
            System.out.println("Popup not visible or already closed");
        }
    }
    public void searchForProduct(String product) {
    	
    	WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(product);
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
    }
}


