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
public class MenuTest {

    @Autowired
    MessageSource messageSource;

    private static WebDriver driver;

    private static WebElement accountLink;

    private static WebElement operationLink;

    private static WebElement statisticLink;

    @BeforeClass
    public static void init() throws InterruptedException {
        final String path = TestUtils.getDriverPath();
        System.setProperty("webdriver.gecko.driver", path);
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/accounts");
        Thread.sleep(4000);
        accountLink = driver.findElement(By.id("accountLink"));
        operationLink = driver.findElement(By.id("operationLink"));
        statisticLink = driver.findElement(By.id("statisticLink"));
    }

    @Test
    public void linksTest() throws InterruptedException {
        assertNotNull(accountLink);
        assertNotNull(operationLink);
        assertNotNull(statisticLink);
    }

    @Test
    public void contextChange(){
        accountLink.click();
        final WebElement accountLabel = driver.findElement(By.id("accountLabel"));
        assertNotNull(accountLabel);
        assertEquals(
                messageSource.getMessage("menu.links.account", null, Locale.getDefault()),
                accountLabel.getText()
        );

        operationLink.click();
        final WebElement operationLabel = driver.findElement(By.id("operationLabel"));
        assertNotNull(operationLabel);
        assertEquals(
                messageSource.getMessage("menu.links.operation", null, Locale.getDefault()),
                operationLabel.getText()
        );

        statisticLink.click();
        final WebElement statisticLabel = driver.findElement(By.id("statisticLabel"));
        assertNotNull(statisticLabel);
        assertEquals(
                messageSource.getMessage("menu.links.statistic", null, Locale.getDefault()),
                statisticLabel.getText()
        );
    }
}
