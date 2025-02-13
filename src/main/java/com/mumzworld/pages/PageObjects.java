package com.mumzworld.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjects {
    private WebDriver driver;
    private By searchBox = By.xpath("//input[@id='search_textbox']");
    private By searchButton = By.xpath("//button[@id='search_btn']");
    private By addButton = By.xpath("//button[@id='add_cart_button']"); 
    private By cartButton = By.xpath("//div[text()='1']");
    private By plusButton = By.xpath("//button[@id='increase_button']");
    private By proceedButton = By.xpath("//button[@title='Proceed to Checkout']");
    private By createAccount = By.xpath("//a[@id='create_account_button']");
    private By firstName = By.xpath("//input[@id='firstname']");
    private By lastName = By.xpath("//input[@id='lastname']");
    private By email = By.xpath("//input[@id='email']");
    private By password = By.xpath("//input[@id='password']");
    private By regButton = By.xpath("//button[@id='register_btn']");
  
    public PageObjects(WebDriver driver) {
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
    public void addToCart() {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.elementToBeClickable(addButton));
        WebElement addBtn = driver.findElement(addButton);
        addBtn.click();
    }
    public void cartCheckout() {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        WebElement cartBtn = driver.findElement(cartButton);
        cartBtn.click();
    }
    public void addQty(int quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            for (int i = 1; i < quantity; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(plusButton));
            WebElement plusBtn = driver.findElement(plusButton);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", plusBtn);
            plusBtn.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("qty")));
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            String currentQty = (String) js1.executeScript("return arguments[0].value;", driver.findElement(By.name("qty")));
            System.out.println("Current quantity after " + (i + 1) + " click(s): " + currentQty);
            if (Integer.parseInt(currentQty) != (i + 1)) {
            System.out.println("Mismatch! Expected quantity: " + (i + 1) + ", but got: " + currentQty);
            break;
            }
            
                    try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            
    }
    public void proceedCheckout()
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.elementToBeClickable(proceedButton));
        WebElement proceedBtn = driver.findElement(proceedButton);
        proceedBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(createAccount));
        WebElement createBtn = driver.findElement(createAccount);
        createBtn.click();
        WebElement first = wait.until(ExpectedConditions.elementToBeClickable(firstName));
        first.sendKeys("Shawn");
        WebElement last = wait.until(ExpectedConditions.elementToBeClickable(lastName));
        last.sendKeys("C A");
        WebElement eml = wait.until(ExpectedConditions.elementToBeClickable(email));
        eml.sendKeys("shawnqadm@mail.com");
        WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(password));
        pwd.sendKeys("Shawn@12345");
        WebElement regBtn = driver.findElement(regButton);
        regBtn.click();
    }
    }
    
    



