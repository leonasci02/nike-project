package br.com.nike.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finalizeEverything() throws IOException{
		TakesScreenshot screenshot = (TakesScreenshot) Hooks.getDriver();
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));
		
		if(BrowserConfiguration.CLOSE_BROWSER) {
			Hooks.closeBrowser();
		}
	}
}
