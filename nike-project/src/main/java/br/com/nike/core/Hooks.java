package br.com.nike.core;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import br.com.nike.exceptions.DriverInstanceKillException;
import br.com.nike.util.PropertiesUtil;

/**
 * Class responsible for definitions that manage the operation of the project.
 * 
 * @author thiago-castilho
 * @since 2018-08-03
 *
 */
public class Hooks {

	private static WebDriver driver;
	private String baseUrl;

	public String getBaseUrl(String url) throws FileNotFoundException, IOException {
		this.baseUrl = url;
		return baseUrl;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (BrowserConfiguration.browser) {
			case FIREFOX:setGeckoDriver();break;
			case CHROME:setChromeDriver();break;
			case IE:setIEDriver();break;
			default:setChromeDriver();break;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}

	private static void setIEDriver() {
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

	private static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	private static void setGeckoDriver() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	public static void closeBrowser() {
		try {
			driver.quit();
			driver = null;
		} catch (DriverInstanceKillException e) {
			e.printStackTrace();
		}
	}
}
