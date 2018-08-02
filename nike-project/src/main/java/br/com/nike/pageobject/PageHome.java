package br.com.nike.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import br.com.nike.definitions.Hooks;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class PageHome {

	
	// force check in
    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    @Name("Home Nike Logo")
    @FindBy(xpath="")
    private WebElement homeLogo;

    @Name("Username")
    @FindBy(name="username")
    private WebElement username;

    @Name("Password")
    @FindBy(name="password")
    private WebElement password;

    @Name("Access Login Button")
    @FindBy(xpath="")
    private WebElement accessBtn;

    public PageHome() {
        this.driver = Hooks.getDriver();
        this.wait = Hooks.getWait();
    }
	
	
}
