package br.com.nike.suite;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.nike.core.Hooks;
import br.com.nike.tests.TestNikeBuyProduct;

@RunWith(Suite.class)
@SuiteClasses({

	TestNikeBuyProduct.class
	
})
public class TestsSuites {

		@AfterClass
		public static void finalizaTudo(){
			Hooks.closeBrowser();
		}

}
