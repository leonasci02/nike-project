package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class PageLogin {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    private DSL dsl;
	
	@FindBy(how=How.XPATH,using="//input[@type='email' and @tabindex='1']")
	private String txtLogin;

	@FindBy(how=How.XPATH,using="//input[@type='password' and @tabindex='2']")
	private String txtSenha;

	@FindBy(how=How.XPATH,using="//button[contains(text(),'Continuar')]")
	private String btnLogar;
	
	public PageLogin() {
		this.driver = Hooks.getDriver();
	}

	public void myAccount(String email, String senha){
		this.dsl.writeXpath(txtLogin, email);
		this.dsl.writeXpath(txtSenha, senha);
		this.dsl.clickButtonByXpath(btnLogar);
	}
}
