package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger; 
	public Properties p;
	
	   
		@BeforeClass(groups= {"sanity", "Regression", "Master", "DataDriven"})
	    @Parameters({"os","browser"})
		public void setup(String os, String br) throws IOException {
	    	
	    	FileReader file = new FileReader("./src//test//resources//config.properties");
	    	p=new Properties();
	    	p.load(file);
	    	
	    	logger=LogManager.getLogger(this.getClass());//Log4j2
	    	System.setProperty("Webdriver.http.factory", "jdk-http-client");
	  
	    	
	    	if(p.getProperty("execution_env").equalsIgnoreCase("remote")) 
            {
	    		DesiredCapabilities capabilities = new DesiredCapabilities();
	    		
	    		
	    		if(os.equalsIgnoreCase("Windows")) {
	    			capabilities.setPlatform(Platform.WIN10);
	    		}
	    		else if(os.equalsIgnoreCase("mac")) {
	    			capabilities.setPlatform(Platform.WIN10);
	    		}
	    		else {
	    			System.out.println("No Matching os");
	    			return;
	    		}
	    		switch(br.toLowerCase()) {
	    		case "chrome": capabilities.setBrowserName("chrome");
	    		WebDriverManager.chromedriver().browserVersion("131.0.6778.140").setup();
	    		driver =new ChromeDriver();break;
	    		
	    		case "edge"  : capabilities.setBrowserName("MicrosoftEdge");break;
	    		default: System.out.println("No Matching browser");return;
	    		}
	    		try {
	    		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	    		System.out.println("Driver initialized successfully.");
	    		}catch(MalformedURLException e){
	    			e.printStackTrace();
	    		}
	    		
		    	
	    	}
	    	
	    	if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
	    		switch(br.toLowerCase())
		    	{
		    	case "chrome": WebDriverManager.chromedriver().setup();driver = new ChromeDriver(); break;
		    	case "firefox": WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); break;
		    	case "edge": WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); break;
		    	default: System.out.println("Invalid browser name"); return;
		    	}
		    	
	    	}
	    	
	    	driver.manage().deleteAllCookies();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appurl2")); //Reading URL from properties file
			driver.manage().window().maximize();
	    
	    	
	    	
		}	
	    
	    @AfterClass(groups= {"Sanity","Regression","Master", "DataDriven"})
		public void teardown() {
		  driver.quit();
		}
	    
	    public String randomString() {
			String generatedString= RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		public String ranomNumber() {
			String generatedNum= RandomStringUtils.randomNumeric(10);
			return generatedNum;
		}	
		public String randomPassword() {
			String generatedNum= RandomStringUtils.randomNumeric(5);
			String generatedString= RandomStringUtils.randomAlphabetic(5);
			return generatedNum+generatedString;
		}	
		
		public String captureScreen(String tname) {
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
			File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetfilepath = System.getProperty("user.dir")+"\\screenshots"+tname+""+timeStamp + ".png";
			File targetFile = new File(targetfilepath);
			
			sourceFile.renameTo(targetFile);
			
			return targetfilepath;
		}

}
