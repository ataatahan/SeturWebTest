package com.setur.webapp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ResultPage
{
    private final WebDriver driver;

    public ResultPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public boolean doesUrlContain(String keyword)
    {
        return driver.getCurrentUrl().contains(keyword);
    }

    public void scrollToBottomAndHighlightElement(String elementClass)
    {
        WebElement element = findElementWithClass(elementClass);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].style.border='3px solid yellow'", element);
    }

    private WebElement findElementWithClass(String elementClass)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(elementClass)));
    }

    public int getRegionCount()
    {
        List<WebElement> regionElements = driver.findElements(By.cssSelector("span.kxWULs"));
        return regionElements.size();
    }
}
