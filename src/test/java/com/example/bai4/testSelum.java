package com.example.bai4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class testSelum {
    ChromeDriver chromeDriver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10)); // Chờ tối đa 10 giây
    }

    @Test
    public void testRegistrationAndLogin() {
        chromeDriver.get("https://vitimex.com.vn/dang-ky.html");

        // Nhập thông tin đăng ký
        sendKeys(By.id("name"), "Dang Xuan Com");
        sendKeys(By.id("phone"), "0292187990");
        sendKeys(By.id("email"), "thihuyentrangd59@gmail.com");
        sendKeys(By.id("pass-regis"), "123a@123");
        sendKeys(By.id("pass-confirm"), "123a@123");

        // Click nút đăng ký
        clickElement(By.xpath("//form[@id='register-form']//div[@class='btnsubmit']"));

        // Chờ và click "Đăng nhập ngay"
        clickElement(By.xpath("//a[contains(text(),'Đăng nhập ngay')]"));

        // Nhập thông tin đăng nhập
        sendKeys(By.id("account"), "thihuyentrangd59@gmail.com");
        sendKeys(By.id("pass"), "123a@123");

        // Click nút đăng nhập
        clickElement(By.id("signin-btn"));
        // Đợi 10 giây để kiểm tra đăng nhập thành công
        try {
            Thread.sleep(10000); // Dừng 10 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        chromeDriver.quit();
    }

    // Hàm nhập text vào ô input
    private void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    // Hàm click phần tử với xử lý lỗi
    private void clickElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            scrollToElement(element);
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element bị chặn, thử click bằng JavaScript...");
            WebElement element = chromeDriver.findElement(locator);
            ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].click();", element);
        }
    }

    // Cuộn đến phần tử nếu cần
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
