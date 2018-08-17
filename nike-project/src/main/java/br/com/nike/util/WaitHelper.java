package br.com.nike.util;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.Hooks;
		
public class WaitHelper {
						
	private WebDriver driver = null;
	private Wait<WebDriver> wait;
			
	public WaitHelper(final WebDriver driver) {
		this.driver = driver;
		this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(35))
        .pollingEvery(Duration.ofMillis(2)).ignoring(NoSuchElementException.class);
		
	}

	/**
	 * Espera a aparição de um elemento através de seu atributo xpath
	 * 
	 * @param element
	 */

	public void waitByXpath(String xpath) {
		wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath(xpath))));
	}

	/**
	 * Espera a aparição de um elemento através de seu atributo id
	 * 
	 * @param element
	 */
	public void waitById(final WebElement element) {
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(element.getAttribute("id")));
			}
		});
	}

	/**
	 * Espera o texto presente em um elemento particular.
	 * 
	 * @author e-lanascimento
	 * @param element
	 * @param mensagem
	 */
	public void textToBePresentInElementValue(WebElement element, String mensagem) {
		// wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element,
		// mensagem)));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, mensagem));

	}

	/**
	 * Aguarda o alert ser apresentado na tela.
	 * 
	 * @author e-lanascimento
	 * @since 2017-12-28
	 */
	public void alertIsPresent() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Espera a aparição de um elemento através de seu atributo name
	 * 
	 * @param element
	 */
	public void waitByName(final WebElement element) {
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(element.getAttribute("name")));
			}
		});
	}

	public void waitElementClickable(String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	/**
	 * Espera por um elemento específico.
	 * 
	 * @param element
	 */
	public void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElement(String xpath) {
		wait.until(ExpectedConditions.visibilityOf(Hooks.getDriver().findElement(By.xpath(xpath))));
	}

	
	/**
	 * Espera a aparição de um elemento através de seu atributo cssSelector
	 * 
	 * @param element
	 */
	public void waitByCSSSelector(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Espera a aparição de um elemento através de seu atributo className
	 * 
	 * @param element
	 */
	public void waitByClassName(final WebElement element) {
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(element.getAttribute("className")));
			}
		});
	}

	/**
	 * Espera o elemento desaparecer.
	 * 
	 * @param element
	 */
	public void waitForInvisibilityOfElement(String xpath) {
		wait.until(ExpectedConditions.invisibilityOf(Hooks.getDriver().findElement(By.xpath(xpath))));
	}

	/**
	 * Espera por elemento visível.
	 * 
	 * @param elements
	 * @return
	 */

	public void waitForVisibleElement(String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	/**
	 * Espera pela visibilidade dos elementos.
	 * 
	 * @param xpath
	 */
	public void waitForElements(String xpath) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath(xpath))));
	}
}
