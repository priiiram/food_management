package com.restaurant.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MenuTest {
    private WebDriver driver;
    // Replace this with your GitHub Pages URL once deployed, or use your local HTML path for testing
    private final String URL = "https://<your-github-username>.github.io/restaurant-website/";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Uncomment if running without opening browser UI
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testMenuLoadsSuccessfully() {
        driver.get(URL);
        List<WebElement> menuItems = driver.findElements(By.className("menu-item"));
        Assert.assertTrue(menuItems.size() > 0, "Menu items failed to load!");
    }

    @Test
    public void testCategoryFiltering() {
        driver.get(URL);

        // Click on 'Starters' filter button
        WebElement starterBtn = driver.findElement(By.xpath("//button[text()='Starters']"));
        starterBtn.click();

        // Verify items displayed belong to starters category
        List<WebElement> visibleItems = driver.findElements(By.className("menu-item"));
        Assert.assertEquals(visibleItems.size(), 2, "Filter for starters did not return expected count.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}