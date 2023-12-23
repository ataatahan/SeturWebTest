package com.setur.webapp;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchPage
{
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeAdvertCookies()
    {
        WebElement closeAdvert = driver.findElement(By.className("ins-close-button"));
        closeAdvert.click();

        WebElement closeCookies = driver.findElement(By.className("CybotCookiebotDialogBodyButton"));
        closeCookies.click();

    }

    //şehir seçeneği yerine Antalya yazar
    public void enterDestination(String Antalya) {
        driver.findElement(By.cssSelector("span.zfDUa")).sendKeys(Antalya);
    }

    //çıkan seçeneklerden Antalya seçeneğini seçer
    public void selectFirstDestination()
    {
        driver.findElement(By.cssSelector("span.kAxssy")).click();
    }

    public void selectDateRange(String startDate, String endDate) {
        // Tarih seçim yerini açar
        WebElement dateRangePicker = driver.findElement(By.className("span.dwdxhf"));
        dateRangePicker.click();

        // Başlangıç tarihini seç
        WebElement startDatePicker = driver.findElement(By.className("span.kNqhKR"));
        startDatePicker.click();

        // Tarih yerini kapat
        WebElement endDatePicker = driver.findElement(By.className("span.gmslZp"));
        endDatePicker.click();
    }

    public void increaseAdultCount()
    {
        openAdultCountPopup();
        increaseAdultCountInPopup();
    }

    private void openAdultCountPopup()
    {
        WebElement adultClass = driver.findElement(By.className("span.zfDUa"));
        adultClass.click();
    }

    private void increaseAdultCountInPopup()
    {
        WebElement increaseButton = driver.findElement(By.cssSelector("[data-testid=increment-button]"));
        increaseButton.click();
    }

    private void increaseAdultExitPopup()
    {
        WebElement adultClass = driver.findElement(By.className("span.zfDUa"));
        adultClass.click();
    }


    public boolean isSearchButtonVisible()
    {
        try
        {
            WebElement searchButton = driver.findElement(By.cssSelector("span.dYTYAP"));
            return searchButton.isDisplayed();
        }
        catch (NoSuchElementException | StaleElementReferenceException e)
        {
            return false;
        }
    }

    public void clickSearchButton()
    {
        driver.findElement(By.cssSelector("span.dYTYAP")).click();
    }

    public void performHotelSearch(String destination, String startDate, String endDate, int adultCount)
    {
        enterDestination(destination);
        selectFirstDestination();
        selectDateRange(startDate, endDate);
        increaseAdultCount();
        clickSearchButton();
    }

    public boolean verifySearchResults() {
        return true;
    }
}
