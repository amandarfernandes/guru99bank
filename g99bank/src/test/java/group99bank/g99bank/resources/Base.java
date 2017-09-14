package group99bank.g99bank.resources;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


	public class Base {

		public static WebDriver driver;
		private static String URL ="http://www.demo.guru99.com/V4/";
		private static String DRIVER_PATH = "/Users/admin/selenium/";
		protected static String myPath = "/Users/admin/selenium/";
		//login user data
		public static final String FILE_NAME="/Users/admin/apps/guru99bank/g99bank/guru99.xlsx";
		public static final String SHEET_NAME="users";
		
		
		//expected results
		  public static final String MGR_TITLE = "Guru99 Bank Manager HomePage";
		  public static final String LOGIN_ERRMSG = "User or Password is not valid";
		  
		  
		public void getScreenshot(String failedTest) throws IOException {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("/Users/admin/apps/guru99bank/"+failedTest+".png"));
		}

		public WebDriver initializeDriver() {
			System.setProperty("webdriver.gecko.driver",DRIVER_PATH+"geckodriver");
			driver= new FirefoxDriver();
			
			//set implicit wait time to 10 secs
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get(URL);
			return driver;
		}
		
	
		@AfterMethod
		public void tearDown() {
			  driver.close();
			  driver=null;
		}
			
		public String[][] getUserData(String fileName, String sheetName) throws IOException  {
			
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetName);
			int rowCount =sheet.getLastRowNum()+1;
			int colCount  = sheet.getRow(0).getLastCellNum();
			String[][] user = new String[rowCount][colCount];
			for (int i=0; i < rowCount; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
		           user[i][j]=row.getCell(j).getStringCellValue();
		        }
			}
			wb.close();
			return user;
	}
}
