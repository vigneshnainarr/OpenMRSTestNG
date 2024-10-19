package com.runnertestng;

import org.junit.Test;
import org.testng.annotations.BeforeTest;

import com.baseclasstestng.BaseclassTestNG;
import com.pageobjectmanagertestng.PageObjectManagerMRSTestNG;

public class OpenMRSTestNGRunner extends BaseclassTestNG {



	public static void main(String[] args) throws Throwable {
		PageObjectManagerMRSTestNG pageObjectManager = new PageObjectManagerMRSTestNG();
		launchBrowser(pageObjectManager.getFileReader().getDataProperty("browser"));
		launchUrl(pageObjectManager.getFileReader().getDataProperty("url"));
		pageObjectManager.getLoginPage().validLogin();
		pageObjectManager.getRegisterPage().validRegister();
		pageObjectManager.getStartVisitPage().validVisitPage();
//		pageObjectManager.getEndVisitPage().validEndPage();
		
		
		
//
//	    PageObjectManagerMRSTestNG pageObjectManager = new PageObjectManagerMRSTestNG();;
//
//	    @BeforeTest
//	    public void setUp() throws Throwable {
//	        pageObjectManager = new PageObjectManagerMRSTestNG();
//	        launchBrowser(pageObjectManager.getFileReader().getDataProperty("browser"));
//	        launchUrl(pageObjectManager.getFileReader().getDataProperty("url"));	    }
//
//	    @Test
//	    public void testOpenMRSFlow() throws Throwable {
//	        PageObjectManagerMRSTestNG.getLoginPage().validLogin();
//	        PageObjectManagerMRSTestNG.getRegisterPage().validRegister();
//	        PageObjectManagerMRSTestNG.getStartVisitPage().validVisitPage();
//	        // Uncomment and use this when the method is implemented
//	        // pageObjectManager.getEndVisitPage().validEndPage();
//	    }
//
//	    @AfterTest
//	    public void tearDown() {
//	        terminateBrowser();
//	    }
//	}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}	
}
