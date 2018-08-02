package br.com.nike.definitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.exceptions.DriverInstanceKillException;
import br.com.nike.util.PropertiesUtil;

/**
 * Classe responsável por definições que gerenciam o funcionamento do projeto.
 * @author thiago-castilho
 *
 */
public class Hooks {

	// Selenium
	private static ThreadLocal<WebDriver> driver;
	private static ThreadLocal<Wait<WebDriver>> wait;
	private String baseUrl;
	
	public String getBaseUrl() throws FileNotFoundException, IOException {
		this.baseUrl = PropertiesUtil.getProjectProperty("SITE");
		return baseUrl;
	}


	public static Wait<WebDriver> getWait() {
		return wait.get();
	}

	// Selenium methods
	public static WebDriver getDriver() {
		if (driver == null) {
			configureBrowser();
		}
		return driver.get();
	}
	
	private static void configureBrowser() {
        //System.setProperty("webdriver.gecko.driver", "/home/user/bin");
        //System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");

        driver = ThreadLocal.withInitial(() -> {
            //return new FirefoxDriver();
            try {
                return new ChromeDriver();
            }catch (Exception e) {
                return new ChromeDriver();
            }
        });

        wait = ThreadLocal.withInitial(() -> {
            return new FluentWait<WebDriver>(driver.get())
            		.withTimeout(Duration.ofSeconds(40))
            		.ignoring(NoSuchElementException.class)
            		.ignoring(StaleElementReferenceException.class)
            		.pollingEvery(Duration.ofSeconds(2));
            
        });
        //System.out.println("Called openBrowser");
        //driver.get().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get().manage().deleteAllCookies();
        driver.get().manage().window().maximize();
    }
	
	public static void closeBrowser() {
        try {
            driver.get().quit();
            driver = null;
        } catch (DriverInstanceKillException e) {
        	e.printStackTrace();
        }
    }
}
