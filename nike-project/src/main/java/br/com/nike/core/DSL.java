package br.com.nike.core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import br.com.nike.util.WaitHelper;

public class DSL {

	/********* TextField and TextArea ************/
	
	public void write(By by, String text){
		Hooks.getDriver().findElement(by).clear();
		Hooks.getDriver().findElement(by).sendKeys(text);
	}

	public void write(String field_id, String text){
		write(By.id(field_id), text);
	}

	public void writeXpath(String field_xpath,String text){
		write(By.xpath(field_xpath),text);
	}
	
	public String getFieldValue(String field_id) {
		return Hooks.getDriver().findElement(By.id(field_id)).getAttribute("value");
	}
	
	/********* RadioButton and CheckBox ************/
	
	public void clickRadio(By by) {
		Hooks.getDriver().findElement(by).click();
	}
	
	public void clickRadio(String id) {
		clickRadio(By.id(id));
	}
	
	public boolean isRadioMarked(String id){
		return Hooks.getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clickCheckBox(String id) {
		Hooks.getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarked(String id){
		return Hooks.getDriver().findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	public void selectCombo(String id, String value) {
		WebElement element = Hooks.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(value);
	}

	public void selectComboByXpath(String xpath, String value) {
		WebElement element = Hooks.getDriver().findElement(By.id(xpath));
		Select combo = new Select(element);
		combo.selectByVisibleText(value);
	}
	
	public void deselectCombo(String id, String value) {
		WebElement element = Hooks.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(value);
	}

	public String getComboValue(String id) {
		WebElement element = Hooks.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public String returnStringValue(String Xpath, String Valor) {
		String Itens = new String();
		List<WebElement> ReturnList = returnElementsByXpath(Xpath);
		for (WebElement listWebElement : ReturnList) {
			if (listWebElement.getText().equals(Valor)) {
				Itens = listWebElement.getText();
				listWebElement.click();
				break;
			}
		}
		return Itens;
	}
	
	private List<WebElement> returnElementsByXpath(String XpathExpression) {
		List<WebElement> Elementos = Hooks.getDriver().findElements(By.xpath(XpathExpression));
		return Elementos;
	}
	
	public List<String> getComboValues(String id) {
		WebElement element = Hooks.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> values = new ArrayList<String>();
		for(WebElement option: allSelectedOptions) {
			values.add(option.getText());
		}
		return values;
	}
	
	public int getQuantityOptionsCombo(String id){
		WebElement element = Hooks.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verifyOptionCombo(String id, String optionValue){
		WebElement element = Hooks.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(optionValue)){
				return true;
			}
		}
		return false;
	}
	
	public void selectPrimeCombo(String radical, String value) {
		clickRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
		clickRadio(By.xpath("//*[@id='"+radical+"_items']//li[.='"+value+"']"));
	}
	
	/********* Button ************/
	
	public void clickButton(String id) {
		Hooks.getDriver().findElement(By.id(id)).click();
	}
	
	public void clickButtonByXpath(String xpath){
		Hooks.getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public String getElementValue(String id) {
		return Hooks.getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/********* Link ************/
	
	public void clickLink(String link) {
		Hooks.getDriver().findElement(By.linkText(link)).click();
	}
	
	/********* Texts ************/
	
	public String getText(By by) {
		return Hooks.getDriver().findElement(by).getText();
	}
	
	public String getText(String id) {
		return getText(By.id(id));
	}
	
	/********* Alerts ************/
	
	public String getAlertText(){
		Alert alert = Hooks.getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String getAlertTextAndAccept(){
		Alert alert = Hooks.getDriver().switchTo().alert();
		String value = alert.getText();
		alert.accept();
		return value;
		
	}
	
	public String getAlertTextAndDismiss(){
		Alert alert = Hooks.getDriver().switchTo().alert();
		String value = alert.getText();
		alert.dismiss();
		return value;
		
	}
	
	public void writeAlert(String value) {
		Alert alert = Hooks.getDriver().switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}
	
	/********* Frames and Windows ************/
	
	public void enterFrame(String id) {
		Hooks.getDriver().switchTo().frame(id);
	}
	
	public void leaveFrame(){
		Hooks.getDriver().switchTo().defaultContent();
	}
	
	public void switchWindow(String id) {
		Hooks.getDriver().switchTo().window(id);
	}
	
	/************** JS *********************/
	
	public Object executeJS(String command, Object... parameter) {
		JavascriptExecutor js = (JavascriptExecutor) Hooks.getDriver();
		return js.executeScript(command, parameter);
	}
	
	/************** Table *********************/
	
	public void clickButtonTable(String columnSearch, String value, String columnButton, String idTable){
		//search registry column
		WebElement table = Hooks.getDriver().findElement(By.xpath(idTable));
		int idColumn = getColumnIndex(columnSearch, table);
		
		//search registry line
		int idLine = getLineIndex(value, table, idColumn);
		
		//search button column
		int idColumnButton = getColumnIndex(columnButton, table);
		
		//click on the cell button found
		WebElement cell = table.findElement(By.xpath(".//tr["+idLine+"]/td["+idColumnButton+"]"));
		cell.findElement(By.xpath(".//input")).click();
		
	}

	protected int getLineIndex(String value, WebElement table, int idColumn) {
		List<WebElement> lines = table.findElements(By.xpath("./tbody/tr/td["+idColumn+"]"));
		int idLine = -1;
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).getText().equals(value)) {
				idLine = i+1;
				break;
			}
		}
		return idLine;
	}

	protected int getColumnIndex(String column, WebElement table) {
		List<WebElement> columns = table.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < columns.size(); i++) {
			if(columns.get(i).getText().equals(column)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
	public void moveToElement(String xpath) {
		new Actions(Hooks.getDriver()).moveToElement(Hooks.getDriver().findElement(By.xpath(xpath))).perform();
	}
	
	public void moveToElementClick(String xpath) {
		new Actions(Hooks.getDriver()).moveToElement(Hooks.getDriver().findElement(By.xpath(xpath))).click().perform();
	}
	
	public WaitHelper getWaitHelper() {
		return new WaitHelper(Hooks.getDriver());
	}

}
