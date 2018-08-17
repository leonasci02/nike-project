package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PageProduct {
	
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    DSL dsl;

	public PageProduct() {
		this.driver = Hooks.getDriver();
		dsl = new DSL();	
	}
	
	public void selectSizeProduct(String Size) throws InterruptedException{
		
		String Result = dsl.returnStringValue("//div[@class='combobox sel-tamanho']/div[@class='optionBox hide']/ul/li[@class='it-option']", Size);
		if(!Result.equals(Size)){
			System.out.println("Não foi possível localizar o tamanho");
		}
		
		
		//dsl.getWaitHelper().waitForInvisibilityOfElement("//div[@id='ctl00_Conteudo_divLoad'  and @style='display: block;']");		
	}
	
	public void clickButtonBuy() throws InterruptedException{
		
		Thread.sleep(1000);
		//dsl.getWaitHelper().waitElementClickable("//*[@id='divProdutoFrete']");
		dsl.moveToElement("//*[@id='divProdutoFrete']");
		dsl.moveToElementClick("//*[@id='ctl00_Conteudo_ctl34_Content']//a[contains(text(),'Comprar')]");
		//dsl.clickButtonByXpath();
	}
	
}
