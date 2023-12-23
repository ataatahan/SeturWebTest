package com.setur.webapp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

public class HomePage
{
    private final WebDriver driver;
    private final Logger logger = Logger.getLogger(String.valueOf(HomePage.class));

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateToSetur()
    {
        String seturUrl = "https://www.setur.com.tr/";
        logger.info("Navigating to Setur URL: " + seturUrl);
        driver.get(seturUrl);
    }

    public boolean isUrlCorrect(String expectedUrl)
    {
        return driver.getCurrentUrl().equals(expectedUrl);
    }

    public void clickHotelTab()
    {
        driver.findElement(By.className("span.etvBQv")).click();
    }
}
