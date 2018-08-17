package br.com.nike.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import br.com.nike.core.DSL;
import br.com.nike.core.Hooks;
import br.com.nike.pageobject.*;

public class TestNikeBuyProduct {

	private String url;
	private String size;
	private String type;
	private String email;
	private String senha;
	private String numberCard;
	private String nameCard;
	private String codeCard;
	private String monthCard;
	private String yearCard;
	private String parcelCard;

	protected static DSL dsl;
	private static PageProduct product = new PageProduct();
	private static PageAddress address = new PageAddress();
	private static PageCart cart = new PageCart();
	private static PageLogin login = new PageLogin();
	private static PagePurchase pay = new PagePurchase();
	private static Hooks hooks = new Hooks();

	public void receiveParameters(String urlList, String emailList, String senhaList, String sizeList, String typeList,
			String numberCardList, String nameCardList, String codeSecurityList, String monthCardList,
			String yearCardList, String parceList) {

		this.url = urlList;
		this.email = emailList;
		this.senha = senhaList;
		this.size = sizeList;
		this.type = typeList;
		this.numberCard = numberCardList;
		this.nameCard = nameCardList;
		this.codeCard = codeSecurityList;
		this.monthCard = monthCardList;
		this.yearCard = yearCardList;
		this.parcelCard = parceList;
	}

	public void executeScritp() throws FileNotFoundException, IOException, InterruptedException {

		inicializa();
		buyProduct();
		finaliza();
	}

	private void inicializa() throws FileNotFoundException, IOException {
		Hooks.getDriver().get(hooks.getBaseUrl(url));
		dsl = new DSL();
	}

	private void finaliza() {
		Hooks.closeBrowser();
	}

	private void buyProduct() throws InterruptedException {
		product.selectSizeProduct(size);
		product.clickButtonBuy();
		cart.concludeBuy();
		login.myAccount(email, senha);
		address.setAddress(type);
		pay.finalizeBuy(numberCard, nameCard, codeCard, monthCard, yearCard, parcelCard);
	}
}
