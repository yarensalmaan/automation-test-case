package com.setur.base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public static WebDriver webDriver;
    public Actions builder;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait();
        this.builder = new Actions(webDriver);
    }

    public static WebDriverWait webDriverWait() {
        WebDriverWait wait =  new WebDriverWait(webDriver, Duration.ofSeconds(15));;
        return wait;
    }

    // Burada url'e gidiyor
    public void goToUrl(String url) {
        webDriver.get(url);
    }

    public String getUrl() {
        String url;
        url = webDriver.getCurrentUrl();
        return url;
    }
    public boolean isElementVisible(By by) {
        boolean flag;
        try {
            webDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
            flag = true;
        } catch (NoSuchElementException | TimeoutException n) {
            flag = false;
        }
        return flag;
    }

    public void sendKeys(String value, By by) {
        WebElement send;
        send = webDriver.findElement(by);
        send.click();
        send.sendKeys(value);
    }

    public WebElement findElement(By by) {
        WebElement element;
        element = webDriver.findElement(by);
        return element;
    }
    public void clickClickableElement(String msg, By by) {
        assertTrue(msg, isElementClickable(by));
        findElement(by).click();
    }
    public boolean isElementClickable(By by) {
        boolean flag;
        try {
            webDriverWait().until(ExpectedConditions.elementToBeClickable(by));
            flag = true;
        } catch (ElementClickInterceptedException | TimeoutException n) {
            flag = false;
        }
        return flag;
    }
    public void assertTrue( String message, boolean assertion) {
        Assert.assertTrue(message,assertion);
    }


    public void clickVisibleElement(By by, String msg) {
        assertTrue(msg, isElementVisible(by));
        findElement(by).click();
    }

    public List<String[]> openCsv(){
        // CSV dosyasının yolunu belirtin
        String csvFilePath = "CsvReaderFile/roadTo.csv";
        List<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            // CSV dosyasındaki tüm satırları okuma
                records = reader.readAll();

            // Her bir satırı işleme alma
            for (String[] record : records) {
                for (String value : record) {
                    System.out.print(value + " ");
                }
                System.out.println(); // Her satırın sonunda yeni bir satıra geç
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return records;
    }
}
