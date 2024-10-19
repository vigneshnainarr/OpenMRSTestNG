package com.baseclasstestng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class BaseclassTestNG {

	//	public static ExtentReports extentReports;
	//	public static File file;

	public static WebDriver	driver;

	protected static WebDriver launchBrowser (String browserName) {

		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING launchBrowser");
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchUrl (String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING launchUrl");
		}
		return driver;
	}

	protected static void passInput (WebElement element, String input ) {
		try {
			element.sendKeys(input);
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING passInput");
		}
	}
	protected static void navigatePageto (String url ) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING navigatePageto");
		}
	}
	protected static void pageRefresh () {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING pageRefresh");
		}
	}
	protected static void pageBack () {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING pageBack");
		}	
	}
	protected static void pageForward () {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING pageForward");
		}
	}

	protected static Select DropDownObject(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	protected static void selectByVisibleText (WebElement element, String text) {
		try {
			DropDownObject(element).selectByVisibleText(text);
		}  catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING selectByVisibleText");
		}
	}
	protected static void selectByIndex(WebElement element, int num) {
		try {
			DropDownObject(element).selectByIndex(num);
		}  catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING selectByIndex");
		}
	}
	protected static void windowhandles(int num) {
		try {
			Set<String> windowhandles = driver.getWindowHandles();	
			List<String> allWindows = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindows.get(num));
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING windowhandles");
		}
	}

	protected static void getCurrentUrl () {		
		try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING getCurrentUrl");
			return;
		}

	}

	protected static String getTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING getTitle");
			return (null);
		}
	}	
	protected static String getText(WebElement driver) {
		try {
			return driver.getText();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING getText");
			return (null);
		}
	}	
	protected static void clickElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING clickElement");   
		}
	}

	protected static void clearElement(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING clearElement");   
		}
	}

	protected static void scrollDown(int x, int y) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scroll(" +x+ " , " +y+ ")");
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING scrollDown");
		}
	} 
	protected static void scrollUp(int x, int y) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scroll(" +x+ " , " +y+ ")");
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING scrollUp");
		}
	}

	//	protected static void getScreenshot(String valueby_png) throws Exception {
	//		TakesScreenshot screenshot = (TakesScreenshot)driver;
	//		File srcFile =  screenshot.getScreenshotAs(OutputType.FILE);
	//
	//		File destFile = new File(valueby_png);
	//		try {
	//			//			FileHandler.copy(srcFile , destFile);
	//			FileUtils.copyFile(srcFile , destFile);
	//		} catch (IOException e) {
	//			Assert.fail("ERROR ; OCCUR DURING TAKING SCREENSHOT AND SAVING IT");
	//		}
	//	}
	protected static void takeScreenshot(String fileName) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File Source = screenshot.getScreenshotAs(OutputType.FILE);

		File Destination = new File(
				"C:\\Users\\vicky\\eclipse-workspace\\Maven_Project\\Screenshot_pics\\ " + fileName + ".png");
		try {
			FileHandler.copy(Source, Destination);
		} catch (IOException e) {
			Assert.fail("ERROR : OCCURED DURING TAKESCREENSHOT AND SAVING IT");

		}
	}


	//	public static void extentReportStart(String location) {
	//		extentReports = new ExtentReports();
	//		file = new File(location);
	//		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
	//		extentReports.attachReporter(sparkReporter);
	//		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
	//		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	//	}
	//
	//	public static void extentReportTearDown(String location) throws IOException {
	//		extentReports.flush();
	//		file = new File(location);
	//		Desktop.getDesktop().browse((file).toURI());
	//	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}


	protected static  String getAttribute(WebElement element, String attribute) {
		try {
			return element.getAttribute(attribute);
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING getAttribute");
			return null;
		}
	}

	//		@SuppressWarnings("unused")
	protected static void Threadsleep(int i) {
		try {

		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING Threadsleep");
		}
	}


	protected static void implicitlywait (int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING implicitlywait");
		}
	}
	protected WebElement explicitwait (int sec, String locator ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		return element;
	}


	// static file upload
	protected static void fileUploadStatic()throws InterruptedException, AWTException {
		try {

			//WebDriver driver =new-ChromeDriver();
			//driver.get("https://demo.openmrs.org/openmrs/attachments/attachments.page?patient=0b26bf11-89a9-4ela-bfb7-d9d018b
			driver.findElement(By.xpath("//div[text()='Click or drop a file here.']")).click();
			Robot robo = new Robot();			// copy the-file- //Keyboardevents
			robo.delay (2000);
			StringSelection stringselect  = new StringSelection  ("C:\\Users\\vicky\\OneDrive\\Documents\\TestNGlogo.png");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselect, null);
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V); //paste
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_V);
		}	catch (Exception e) {
			Assert.fail("ERROR OCCUR-DURING FILEUPLOAD"); 
		}	
	}	

	// Dynamic file upload method
	public static void fileUploadDynamic(WebDriver driver, String filePath, String uploadButtonXPath) throws InterruptedException, AWTException {
		try {
			// Click on the upload button
			driver.findElement(By.xpath(uploadButtonXPath)).click();

			// Initialise Robot class
			Robot robo = new Robot();
			robo.delay(2000);

			// Copy the file path to the clipboard
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Perform paste operation
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyRelease(KeyEvent.VK_V);
			robo.delay(2000);

			// Press Enter to complete the upload
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("ERROR OCCURRED DURING FILE UPLOAD: " + e.getMessage());
		}
	}



	protected static String getParticularExcelCell(int sheetIndexNo,int rows, int column) throws InvalidFormatException, IOException  {
		//		File file = new File ("C:\\Users\\vicky\\OneDrive\\Documents\\sql xcel\\data driven oct ipt .xlsx");
		File file = new File ("C:\\Users\\vicky\\OneDrive\\Documents\\omrs excel\\omrs.xlsx");
		Workbook book = new XSSFWorkbook(file);

		Sheet sheet = book.getSheetAt(sheetIndexNo);
		Row row = sheet.getRow(rows);
		Cell cell = row.getCell(column);

		DataFormatter dataformat = new DataFormatter();
		String data = dataformat.formatCellValue(cell);
		return data;
	}


	public static String getParticularExcelCellDynamic(String filePath, int sheetIndex, int rowNum, int cellNum) {
		try (FileInputStream fileexcel = new FileInputStream(new File(filePath));
				Workbook workbook = new XSSFWorkbook(fileexcel)) {

			Sheet sheet = workbook.getSheetAt(sheetIndex);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);

			DataFormatter dataFormatter = new DataFormatter();
			String data = dataFormatter.formatCellValue(cell);

			System.out.println(data);
			return data;

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("ERROR: OCCURRED DURING GETTING THE DYNAMIC EXCEL DATA: " + e.getMessage());
		}
		return null;
	}



	//	    public static void main(String[] args) {
	//	        String filePath = ".............path.xlsx";
	//	        String data = Base_Class.getExcelData(filePath, 0, 0, 0);
	//	        System.out.println("Retrieved data: " + data);
	//	    }




	//	protected static void validation(WebElement actual, String expected) {
	//		try {
	//			Assert.assertEquals(actual,expected);
	//		} catch (Exception e) {
	//			Assert.fail("ERROR : OCCURED DURING VALIDATION");
	//		}
	//	}

	protected static void validation(String actual, String excepected) {
		try {
			Assert.assertEquals(actual, excepected);
		} catch (Exception e) {

			Assert.fail("ERROR : OCCUR DURING VALIDATION");
		}
	}


	// Method to check if an element is enabled
	protected static void elementIsEnabled(WebElement element) {
		try {
			if (!element.isEnabled()) {
				Assert.fail("Element is not enabled");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING ELEMENT ENABLED CHECK");
		}
	}


	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING closeBrowser");
		}
	}
	protected static void terminateBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR ; OCCUR DURING terminateBrowser");
			//e.printStackTrace();
		}
	}


}
