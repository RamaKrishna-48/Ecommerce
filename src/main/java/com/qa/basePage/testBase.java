package com.qa.basePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class testBase implements IReporter {
	public static WebDriver driver;
	public static Properties prop;
	public static com.qa.utility.WebEventListener eventListener;
	public static EventFiringWebDriver eventdriver;
	String currrntDirectory;
	ExtentHtmlReporter htmlReporter;

	public static ExtentReports extent;
	// helps to generate the logs in test report.
	public static ExtentTest test;

	public static Calendar cal = Calendar.getInstance();

	public testBase() {
		currrntDirectory = System.getProperty("user.dir");
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					"C:\\Users\\ramak\\OneDrive\\Desktop\\New folder\\NextClick\\planitTesting\\src\\main\\resources\\config.properties");
			prop.load(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void startReport(String browser, String chrome) {
		SimpleDateFormat emailDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports" + "/Reports_" + "_"
				+ emailDateFormat.format(cal.getTime()) + "/testReport.html");

		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// To add system or environment info by using the setSystemInfo method.
		extent.setSystemInfo("OS", browser);
		extent.setSystemInfo("Browser", chrome);

		// configuration items to change the look and feel
		// add content, manage tests etc
		htmlReporter.config().setDocumentTitle("Extent Report ");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	public void linkTest() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ramak\\OneDrive\\Desktop\\New folder\\NextClick\\planitTesting\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("ff")) {
			System.setProperty("webdriver.gecho.driver", "");
			driver = new FirefoxDriver();

		}
		eventdriver = new EventFiringWebDriver(driver);
		eventListener = new com.qa.utility.WebEventListener();
		eventdriver.register(eventListener);
		driver = eventdriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void tearDown() {
		// to write or update test information to reporter
		extent.flush();
		driver.close();
	}
}
