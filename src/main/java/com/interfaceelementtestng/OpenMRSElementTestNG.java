package com.interfaceelementtestng;

public interface OpenMRSElementTestNG {

	
	
	// Login Page Elements //Scenario 1
	
		String userName_id = "username";
		String password_id = "password";
		String location_id = "Inpatient Ward";
		String login_id = "loginButton";


		//|Register Page Elements //Scenario 2


		String registerapatient_xpath = "(//a[@class='btn btn-default btn-lg button app big align-self-center'])[4]";
		
		
		// page 3 all details
		String patient_name = "givenName";	
//		String patient_mname = "middleName";
		String patient_Lname = "familyName";
		
		String allNext_button_id_gn = "next-button";
		
		String gender_id = "gender-field";					//"//option[text()='Male']";
		
		String birthdate_name = "birthdateDay";
		String birthmonth_id = "birthdateMonth-field";
		String birthyear_name = "birthdateYear";
	
		String addressline1_id = "address1";
		String addressline2_id = "address2";
		
		String cityvillage_id = "cityVillage";
		String state_id = "stateProvince";
		String country_id = "country";
		String postalcode_id = "postalCode";
		
		String	phonenumber_name = "phoneNumber";
		String relationship_id = "relationship_type";						//"//option[normalize-space(text())='Sibling']";
		String personnamePlaceholder_xpath = "//input[@placeholder='Person Name']";
		
		String submitbutton_id = "submit";
		

//		String confirmvisit_id = "start-visit-with-visittype-confirm";
//		String attachmentvisit_xpath = "(//a[@class='button task activelist'])[5]";

		String startvist_xpath = "(//div[@class='col-11 col-lg-10'])[1]";
	    String confirmvisit_xpath = "(//button[@class='confirm right'])[6]";
	    String attachmentvisit_xpath = "//*[@class='button task activelist'][5]";

	    String dropfile_xpath = "//div[text()='Click or drop a file here.']";
	    String dropfilecaption_xpath= "//textarea[@placeholder='Enter a caption']";
	    String uploadfilebutton_xpath = "//button[@class='confirm ng-binding']";

	 
}
