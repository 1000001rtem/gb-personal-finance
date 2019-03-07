package ru.gd.dev.spring.pfs.ui;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @autor Eremin Artem on 24.02.2019.
 * <p>
 * For running tests you must download geckodriver for FirefoxDriver from
 * @link <a href="https://github.com/mozilla/geckodriver/releases/tag/v0.24.0">geckodriver</a>"
 * to directory "resources/drivers"
 * <p>
 * You must start appplication for run tests with Selenium2
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountDetailViewTest {

    @Autowired
    MessageSource messageSource;

    private static WebDriver driver;

    @BeforeClass
    public static void init() throws InterruptedException {
        final String path = TestUtils.getDriverPath();
        System.setProperty("webdriver.gecko.driver", path);
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/accounts");
        Thread.sleep(4000);
    }

    @Test
    public void addAccountTest() throws InterruptedException {
        final WebElement accountLink = driver.findElement(By.id("accountLink"));
        assertNotNull(accountLink);
        accountLink.click();
        final WebElement addNewAccountButton = driver.findElement(By.className("createAccountButton"));
        assertNotNull(addNewAccountButton);
        addNewAccountButton.click();
        Thread.sleep(2000);
        final WebElement titleLabel = driver.findElement(By.className("pageTitle"));
        assertEquals(
                messageSource.getMessage("addaccount.title", null, Locale.getDefault()),
                titleLabel.getText());
    }
}
