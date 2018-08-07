package br.com.nike.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;
import br.com.nike.pageobject.*;


@RunWith(value = Parameterized.class)
public class TestNikeBuyProduct {

	private String numberCard;
	private String nameCard;
	private String codeCard;
	private String monthCard;
	private String yearCard;
	private String parcelCard;
	
	protected DSL dsl;
	private PageProduct product;
	private Hooks hooks = new Hooks();

	public TestNikeBuyProduct(String numberCard,String nameCard, String codeCard, String monthCard, String yearCard, String parcelCard){
		
		super();
		this.numberCard = numberCard;
		this.nameCard = nameCard;
		this.codeCard = codeCard;
		this.monthCard = monthCard;
		this.yearCard = yearCard;
		this.parcelCard = parcelCard;
	}
	
	@Parameterized.Parameters
	public static List<Object[]> setInput(){
		return Arrays.asList(new Object[][] {
			{"5226049697794257","Vagner wagner","439","01","19"," 1x "},
			{"5358098532239804","Ramon ramon","464","11","19"," 1x "},
			{"4011090452635683","Wal wal","579","02","19"," 2x "}
		});
	}
	
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
	public void buyProduct(){

	}
	
}
