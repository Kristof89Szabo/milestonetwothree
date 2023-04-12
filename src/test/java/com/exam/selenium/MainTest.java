package com.exam.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MainTest {

    private static final String URL = "https://agreeable-beach-0514a6003.azurestaticapps.net/k1";
    private static WebDriver driver;
    private static ChromeOptions chromeOptions;


    @BeforeAll
    static void setupAll() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); // without this we get unable to establish connection to chrome. https://groups.google.com/g/chromedriver-users/c/xL5-13_qGaA
        chromeOptions.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testWebpageShouldAppearCorrectly() {
        driver.get(URL);
        WebElement a = driver.findElement(By.id("a"));
        WebElement b = driver.findElement(By.id("b"));
        WebElement c = driver.findElement(By.id("c"));
        WebElement calculateButton = driver.findElement(By.id("submit"));

        assertNotNull(a);
        assertNotNull(b);
        assertNotNull(c);
        assertNotNull(calculateButton);
        assertEquals("", a.getAttribute("value"));
        assertEquals("", b.getAttribute("value"));
        assertEquals("", a.getAttribute("value"));
    }


    @Test
    void testShouldCalculateCorrectly() {
        driver.get(URL);
        WebElement a = driver.findElement(By.id("a"));
        WebElement b = driver.findElement(By.id("b"));
        WebElement c = driver.findElement(By.id("c"));
        WebElement calculateButton = driver.findElement(By.id("submit"));
        WebElement results = driver.findElement(By.id("result"));

        a.sendKeys("1");
        b.sendKeys("2");
        c.sendKeys("3");
        calculateButton.click();

        assertEquals("6", results.getText());
    }


    @Test
    void testPermitierShouldBeNaN() {
        driver.get(URL);
        WebElement a = driver.findElement(By.id("a"));
        WebElement b = driver.findElement(By.id("b"));
        WebElement c = driver.findElement(By.id("c"));
        WebElement calculateButton = driver.findElement(By.id("submit"));
        WebElement results = driver.findElement(By.id("result"));

        calculateButton.click();

        assertEquals("NaN", results.getText());
    }

}
