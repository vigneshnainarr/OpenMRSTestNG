package com.pageobjectmodeltestng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclasstestng.BaseclassTestNG;
import com.excelutilitytestng.ExcelUtilityTestNG;
import com.interfaceelementtestng.OpenMRSElementTestNG;
import com.propertytestng.FileReaderManagerMRSTestNG;

public class OpenMRSStartVistPageTestNg extends BaseclassTestNG implements OpenMRSElementTestNG {

	
	@FindBy(xpath = startvist_xpath )
	private WebElement startvisiting;
	@FindBy(xpath = confirmvisit_xpath)
	private WebElement confirmvisiting;
	@FindBy(xpath = attachmentvisit_xpath)
	private WebElement attachment;
	
	@FindBy(xpath = dropfile_xpath)
	private WebElement uploadfile;
	@FindBy(xpath = dropfilecaption_xpath)
	private WebElement caption;
	@FindBy(xpath = uploadfilebutton_xpath)
	private WebElement uploadbutton;
	
	
	
	
	
	public OpenMRSStartVistPageTestNg(WebDriver driver) {
        PageFactory.initElements(driver, this);
	}
	
	public void validVisitPage() throws Throwable {
		// Scenario 2: Demographics

		FileReaderManagerMRSTestNG data = new FileReaderManagerMRSTestNG ();
		
		Threadsleep(7);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		confirmvisiting.click();
//		attachment.click();
		
		clickElement(startvisiting);
		clickElement(confirmvisiting);
		Threadsleep(5);
		clickElement(attachment);

		String filePath = ("C:\\Users\\vicky\\OneDrive\\Documents\\TestNGlogo.png");
		String uploadButtonXPath = "//div[text()='Click or drop a file here.']" ;
		
	
		fileUploadDynamic(driver, filePath, uploadButtonXPath);
	
		String dropfilecaption_xpath = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "dropfilecaption_xpath");	
		passInput(caption, dropfilecaption_xpath);
	
		
		implicitlywait(15);
		clickElement(uploadbutton);
		
		
		
		
		
	}	
}
