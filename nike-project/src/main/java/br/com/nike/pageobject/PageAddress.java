package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PageAddress {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    private DSL dsl;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Continuar')]")
	private String btnContinue;

	public PageAddress() {
		this.driver = Hooks.getDriver();
	}
	
	public void setAddress(String Type){
		this.dsl.clickButtonByXpath("//strong[contains(text(),'"+Type+"')]");
		this.dsl.clickButtonByXpath(btnContinue);
	}
	
}
