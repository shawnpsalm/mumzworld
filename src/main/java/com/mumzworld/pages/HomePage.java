package com.mumzworld.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By searchBox = By.xpath("//input[@id='search_textbox']");
    private By searchButton = By.xpath("//use[@xlink:href='/icons/sprite.svg#MagnifyingGlassIcon']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String product) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(product);
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
    }
}
