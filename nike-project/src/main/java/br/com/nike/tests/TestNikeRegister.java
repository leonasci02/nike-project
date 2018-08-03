package br.com.nike.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;

public class TestNikeRegister {

	private DSL dsl;
	private Hooks hooks = new Hooks();

	@Before
	public void inicializa() throws FileNotFoundException, IOException{
		Hooks.getDriver().get(hooks.getBaseUrl());
		this.dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		Hooks.closeBrowser();
	}
	
	@Test
	public void fazerLogin() throws FileNotFoundException, IOException {
		dsl.write(By.id("an_id"), "test");
	}
	
	
}
