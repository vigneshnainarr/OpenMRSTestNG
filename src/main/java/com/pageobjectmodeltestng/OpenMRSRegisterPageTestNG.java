package com.pageobjectmodeltestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
import com.baseclasstestng.BaseclassTestNG;
import com.excelutilitytestng.ExcelUtilityTestNG;
import com.interfaceelementtestng.OpenMRSElementTestNG;
import com.propertytestng.FileReaderManagerMRSTestNG;

public class OpenMRSRegisterPageTestNG  extends BaseclassTestNG implements OpenMRSElementTestNG{

	@FindBy(xpath = registerapatient_xpath)
	private WebElement register;
	@FindBy(name = patient_name)
	private WebElement pf_name;
	//	@FindBy(name = patient_mname)
	//	private WebElement pm_name;
	@FindBy(name = patient_Lname)
	private WebElement pl_name;

	@FindBy(id = allNext_button_id_gn)
	private WebElement next_button;

	@FindBy(id = gender_id)
	private WebElement gender_male;


	@FindBy(name = birthdate_name)
	private WebElement b_date;
	@FindBy(id= birthmonth_id)
	private WebElement b_month;
	
	
	@FindBy(name = birthyear_name)
	private WebElement b_year;

	@FindBy(id = addressline1_id)
	private WebElement address1;
	@FindBy(id = addressline2_id)
	private WebElement address2;
	@FindBy(id = cityvillage_id)
	private WebElement city;
	@FindBy(id = state_id)
	private WebElement stateProvince;
	@FindBy(id = country_id)
	private WebElement country;
	@FindBy(id = postalcode_id)
	private WebElement postalCode;
	
	@FindBy(name = phonenumber_name)
	private WebElement phonenumber;
	
	@FindBy(id = relationship_id)
	private WebElement Sibling;
	@FindBy(xpath = personnamePlaceholder_xpath)
	private WebElement personname;
	
	@FindBy(id = submitbutton_id)
	private WebElement submit_button;
	
	
	
	public OpenMRSRegisterPageTestNG(WebDriver driver) { // Change to Constructor
		PageFactory.initElements(driver, this); // POM class methods initialised
	}

	public void validRegister() throws Throwable {
		// Scenario 2: Demographics

		FileReaderManagerMRSTestNG data = new FileReaderManagerMRSTestNG ();
		
		clickElement(register);

	String patient_name = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "patient_name");	
	passInput(pf_name, patient_name);	
	
	String patient_Lname = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "patient_Lname");	
	passInput(pl_name, patient_Lname);	
	clickElement(next_button);
	
//	clickElement(g_male);
//	selectByIndex(g_male, 1);
//	DropDownObject(g_male).selectByIndex(1);
	selectByVisibleText(gender_male, "Male");
	clickElement(next_button);
		
	String birthdate_name = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "birthdate_name");	
	passInput(b_date, birthdate_name);
	
//	clickElement(b_month);
//	selectByIndex(b_month, 5);
	DropDownObject(b_month).selectByIndex(5);
	
	String birthyear_name = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "birthyear_name");	
	passInput(b_year, birthyear_name);
	clickElement(next_button);
	
	String addressline1_id = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "addressline1_id");	
	passInput(address1, addressline1_id);
	String addressline2_id = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "addressline2_id");	
	passInput(address2, addressline2_id);
	String cityvillage_id = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "cityvillage_id");	
	passInput(city, cityvillage_id);
	String state_id = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "state_id");	
	passInput(stateProvince, state_id);
	String country_id = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "patient_Lname");	
	passInput(country, country_id);
	String postalcode_id = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "postalcode_id");	
	passInput(postalCode, postalcode_id);
	clickElement(next_button);
	
	String phonenumber_name = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "phonenumber_name");	
	passInput(phonenumber, phonenumber_name);
	clickElement(next_button);
	
//	clickElement(Sibling);
	DropDownObject(Sibling).selectByIndex(2);
	String personnamePlaceholder_xpath = ExcelUtilityTestNG.getCellValue("data", "userDataAll", "personnamePlaceholder_xpath");	
	passInput(personname, personnamePlaceholder_xpath);
	clickElement(next_button);
	
	clickElement(submit_button);
	
	

	/// Scenario 3: Demographics



	}
	
}
	

