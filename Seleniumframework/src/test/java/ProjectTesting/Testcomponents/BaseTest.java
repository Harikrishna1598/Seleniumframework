package ProjectTesting.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ProjectTesting.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;

	public WebDriver initializeBrowser() throws IOException {

		// class to read properties file
		Properties prop = new Properties();

		// class to covert input to stream
		FileInputStream fis = new FileInputStream("C:\\Users\\LINGU\\eclipse-workspace\\Seleniumframework\\src\\main\\"
				+ "java\\ProjectTesting\\Resources\\GlobalData.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();
		}

		return driver;

	}

	public LandingPage launchApplication() throws IOException {

		driver = initializeBrowser();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.reachWebsite();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return landingPage;
	}

	public void tearDown() {
		driver.quit();
	}

	public String takeScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		 
		//convert json to string
		String data = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//convert string to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> extractedData =mapper.readValue(data, 
				new TypeReference<List<HashMap<String,String>>>(){});
		return extractedData;

}
}
