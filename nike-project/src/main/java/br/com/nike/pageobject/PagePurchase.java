package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PagePurchase {

	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	private DSL dsl;

	public PagePurchase() {
		this.driver = Hooks.getDriver();
		dsl = new DSL();
	}
	
	public void finalizeBuy(String numCard,String name, String code,String month, String year, String parcel){
		
		dsl.writeXpath("//input[@id='cardNumber1']", numCard);
		dsl.writeXpath("//input[@id='cardName1']", name);
		dsl.writeXpath("//input[@id='cardSecurity1']", code);
		dsl.selectComboByXpath("//select[@id='cardMonth1']", month);
		dsl.selectComboByXpath("//select[@id='cardYear1']", year);
		dsl.selectComboByXpath("//select[@id='parcelOptions1']", parcel);
		//dsl.clickButtonByXpath("//button[contains(text(),'Finalizar compra') and @_ngcontent-c3]");
	}

}
