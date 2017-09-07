package group99bank.g99bank.resources;

	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;

	public class Base {
		public static WebDriver driver;
		String url ="http://www.demo.guru99.com/V4/";
		
		public void getScreenshot(String failedTest) throws IOException {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("/Users/admin/apps/guru99bank/"+failedTest+".png"));
		}

		@BeforeClass
		public WebDriver initializeDriver() {
								
			System.setProperty("webdriver.gecko.driver","/Users/admin/selenium/geckodriver");
			driver= new FirefoxDriver();
					
			//driver.manage().window().maximize();
			
			//set implicit wait time to 10 secs
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get(url);
			return driver;
		}
		
		@AfterClass
		  public void afterTest() {
			  driver.close();
			  driver=null;
		  }
	

}
