package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PageLogin {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    private DSL dsl;

	public PageLogin() {
		this.driver = Hooks.getDriver();
		dsl = new DSL();
	}

	public void myAccount(String email, String senha){
		dsl.writeXpath("//input[@type='email' and @tabindex='1']", email);
		dsl.writeXpath("//input[@type='password' and @tabindex='2']", senha);
		dsl.clickButtonByXpath("//button[contains(text(),'Continuar')]");
	}
}
