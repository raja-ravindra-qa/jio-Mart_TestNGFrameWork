package abstractcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.landingpage;

public class baseclass {
	public WebDriver driver;
	public landingpage lp;
	

	public WebDriver initializeDriver() throws IOException

	{
		// properties class

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/Src/main_java/resources/GlobalData.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));// full screen

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			// Firefox
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	public String takescreenshot(String title, WebDriver driver) throws IOException {
		
//		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		   LocalDateTime now = LocalDateTime.now();  
//		   String dt=dtf.format(now);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File fl = new File(System.getProperty("user.dir") + "/reports/"+ title + ".png");
		FileUtils.copyFile(source, fl);
		return System.getProperty("user.dir") + "/reports/"+ title + ".png";
	}
	
	public static ExtentReports extentconfig() {

System.out.println("hhi i am available here");
		String pathx =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(pathx);
		reporter.config().setReportName("my BSE report");
		reporter.config().setDocumentTitle("testNG report");
		reporter.config().setReportName("Me");
		
		ExtentReports extent = new ExtentReports();
		extent.setSystemInfo("Tester", "Raveendra");
		extent.attachReporter(reporter);
		return extent;
		
	}

	@BeforeMethod(alwaysRun = true)
	public landingpage launching() throws IOException {
		driver = initializeDriver();
		lp = new landingpage(driver);
		lp.launch();
		return lp;
	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() throws InterruptedException {
	//	Thread.sleep(2000);
		driver.close();
	}

}
