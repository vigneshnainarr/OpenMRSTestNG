package com.pageobjectmanagertestng;

import com.baseclasstestng.BaseclassTestNG;
import com.pageobjectmodeltestng.OpenMRSLoginPageTestNG;
import com.pageobjectmodeltestng.OpenMRSRegisterPageTestNG;
import com.pageobjectmodeltestng.OpenMRSStartVistPageTestNg;
import com.propertytestng.FileReaderManagerMRSTestNG;


public class PageObjectManagerMRSTestNG extends BaseclassTestNG {


	    
		private OpenMRSLoginPageTestNG loginPage;
	    private OpenMRSRegisterPageTestNG registerPage;
	    private OpenMRSStartVistPageTestNg startVisitPage;
	    private FileReaderManagerMRSTestNG fileReader;
	    // private OpenMRSEndVisitPage endVisitPage;
	    // private OpenMRSPatientRecordDeletePage patientRecordDeletePage;

	    public OpenMRSLoginPageTestNG getLoginPage() {
	        if (loginPage == null) {
	            loginPage = new OpenMRSLoginPageTestNG(driver);
	        }
	        return loginPage;
	    }

	    public OpenMRSRegisterPageTestNG getRegisterPage() {
	        if (registerPage == null) {
	            registerPage = new OpenMRSRegisterPageTestNG(driver);
	        }
	        return registerPage;
	    }

	    public OpenMRSStartVistPageTestNg getStartVisitPage() {
	        if (startVisitPage == null) {
	            startVisitPage = new OpenMRSStartVistPageTestNg(driver);
	        }
	        return startVisitPage;
	    }

	    // public OpenMRSEndVisitPage getEndVisitPage() {
	    //     if (endVisitPage == null) {
	    //         endVisitPage = new OpenMRSEndVisitPage(driver);
	    //     }
	    //     return endVisitPage;
	    // }

	    // public OpenMRSPatientRecordDeletePage getPatientRecordDeletePage() {
	    //     if (patientRecordDeletePage == null) {
	    //         patientRecordDeletePage = new OpenMRSPatientRecordDeletePage(driver);
	    //     }
	    //     return patientRecordDeletePage;
	    // }

	    public FileReaderManagerMRSTestNG getFileReader() {
	        if (fileReader == null) {
	        	fileReader = new FileReaderManagerMRSTestNG();
	        }
			return fileReader;
	    } 
	    }        

