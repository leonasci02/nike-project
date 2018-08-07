package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PageCart {

	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	private DSL dsl;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Concluir compra')]")
	private String btnConcludeBuy;

	public PageCart() {
		this.driver = Hooks.getDriver();
	}
	
	public void concludeBuy(){
		this.dsl.clickButtonByXpath(btnConcludeBuy);
	}
}
