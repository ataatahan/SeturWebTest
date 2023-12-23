package com.setur.webapp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SearchTest
{
    private HomePage homePage;
    private SearchPage searchPage;
    private ResultPage resultPage;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);
    }

    @Test
    public void searchHotelInAntalya()
    {
        homePage.navigateToSetur();
        Assert.assertTrue(homePage.isUrlCorrect("https://www.setur.com.tr/"));
        try
        {
            searchPage.closeAdvertCookies();
        }
        catch (Exception e)
        {
            Assert.fail("Reklam çerezleri kapatılamadı: " + e.getMessage());
        }
        homePage.clickHotelTab();

        searchPage.enterDestination("Antalya");
        searchPage.selectFirstDestination();

        Assert.assertTrue(searchPage.isSearchButtonVisible());
        searchPage.clickSearchButton();

        searchPage.increaseAdultCount();

        Assert.assertTrue(searchPage.isSearchButtonVisible());
        searchPage.clickSearchButton();

        Assert.assertTrue(resultPage.doesUrlContain("Antalya"));

        resultPage.scrollToBottomAndHighlightElement("span.dQerZq");

        int regionCount = resultPage.getRegionCount();

        Assert.assertEquals(0, regionCount);
    }
}