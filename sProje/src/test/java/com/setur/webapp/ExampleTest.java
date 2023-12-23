    package com.setur.webapp;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class ExampleTest {
        public static void main(String[] args)
        {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.setur.com.tr/");
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.urlContains("setur"));

            HomePage homePage = new HomePage(driver);
            homePage.navigateToSetur();

            if (homePage.isUrlCorrect("https://www.setur.com.tr/hotels"))
            {
                System.out.println("Otel sayfasına başarıyla gidildi.");
            }

            else
            {
                System.out.println("Otel sayfasına giriş başarısız");
            }

            homePage.clickHotelTab();

            driver.quit();
        }
    }
