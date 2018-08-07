package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PagePurchase {

	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	private DSL dsl;

	@FindBy(how = How.XPATH, using = "//input[@id='cardNumber1']")
	private String txtNumCard;

	@FindBy(how = How.XPATH, using = "//input[@id='cardName1']")
	private String txtNameCard;

	@FindBy(how = How.XPATH, using = "//input[@id='cardSecurity1']")
	private String txtCodeSecurity;
		
	@FindBy(how = How.XPATH, using = "//select[@id='cardMonth1']")
	private String cbxMonth;

	@FindBy(how = How.XPATH, using = "//select[@id='cardYear1']")
	private String cbxYear;

	@FindBy(how = How.XPATH, using = "//select[@id='parcelOptions1']")
	private String cbxParcel;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Finalizar compra') and @_ngcontent-c3]")
	private String btnFinish;

	public PagePurchase() {
		this.driver = Hooks.getDriver();
	}
	
	public void finalizeBuy(String numCard,String name, String code,String month, String year, String parcel){
		
		this.dsl.writeXpath(txtNumCard, numCard);
		this.dsl.writeXpath(txtNameCard, name);
		this.dsl.writeXpath(txtCodeSecurity, code);
		this.dsl.selectComboByXpath(cbxMonth, month);
		this.dsl.selectComboByXpath(cbxYear, year);
		this.dsl.selectComboByXpath(cbxParcel, parcel);
		//this.dsl.clickButtonByXpath(btnFinish);
	}

}
