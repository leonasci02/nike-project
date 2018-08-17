package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PageAddress {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    private DSL dsl;
	
	public PageAddress() {
		this.driver = Hooks.getDriver();
		dsl = new DSL();
	}
	
	public void setAddress(String Type){
		dsl.clickButtonByXpath("//strong[contains(text(),'"+Type+"')]");
		dsl.clickButtonByXpath("//a[contains(text(),'Continuar')]");
	}
	
}
