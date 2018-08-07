package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PageProduct {
	
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    private DSL dsl;
	
	@FindBy(how=How.XPATH,using="//div[@class='combobox sel-tamanho']/div[@class='optionBox hide']/ul/li[@class='it-option']")
	private String setTamanho;

	@FindBy(how=How.XPATH,using="//div//a[contains(text(),'Comprar')]")
	private String btnComprar;

	public PageProduct() {
		this.driver = Hooks.getDriver();
	}
	
	public void selectSizeProduct(String Size){
		String Result = this.dsl.returnStringValue(setTamanho, Size);
		if(!Result.equals(Size)){
			System.out.println("Não foi possível localizar o tamanho");
		}
	}
	
	public void clickButtonBuy(){
		this.dsl.clickButtonByXpath(btnComprar);
	}
	
}
