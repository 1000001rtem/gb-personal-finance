package ru.gd.dev.spring.pfs.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class PfsUiApplicationTests {

    private WebDriver driver;

    @Before
    public void init() {
        final String path = TestUtils.getDriverPath();
        System.setProperty("webdriver.gecko.driver", path);
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/accounts");
    }

    @Test
    public void contextLoads() throws InterruptedException {
        Thread.sleep(4000);
        final WebElement element = driver.findElement(By.id("mainView"));
        assertNotNull(element);
    }

}
