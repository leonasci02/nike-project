package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PageCart {

	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	private DSL dsl;

	public PageCart() {
		this.driver = Hooks.getDriver();
		dsl = new DSL();
	}
	
	public void concludeBuy() throws InterruptedException{
		Thread.sleep(1000);
		//dsl.clickButtonByXpath("//a[contains(text(),'Concluir compra')]");
		dsl.moveToElementClick("//a[contains(text(),'Concluir compra')]");
		Thread.sleep(1000);
	}
}
