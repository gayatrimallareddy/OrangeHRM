package app.utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Application_Methods_Sample extends General_Methods_Sample{

	WebDriver driver;

	public Application_Methods_Sample(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	Excel_Methods excelObj = new Excel_Methods();

	//	@BeforeSuite
	public void Launch() throws Exception {
		String URL1=config.getProperty("URL");
		System.out.println("URL MSG: "+URL1);
		if(URL1 != null) {
			System.out.println("inside if loop " + URL1);
			driver.get(URL1);
			System.out.println("launched");
		} else{
			System.out.println("Check Your URL in preperties file");
		}
		Reporter.log("Launched Successfully");
		/*WebElement loginButton = gmObj.cssSelector("loginButton");
		if(loginButton.isDisplayed()){
			Reporter.log("User Successfully Navigated to OrangeHRM");
		}
		else{
			Reporter.log("User Unable to Navigate to OrangeHRM");
		}*/
	}

	public void Login(String user) throws Exception {
		Sheet sheet = excelObj.Read_Excel_Sheet("OrangeHRM.xlsx", "Login_Credentials");
		String userName = excelObj.Read_Cell_Data(sheet, user, "User", "UserName");
		System.out.println("userName "+userName);
		String password = excelObj.Read_Cell_Data(sheet, user, "User", "Password");
		System.out.println("password "+password + "\n");
		//System.out.println(OR.getProperty("userNameId"));
		//System.out.println(gmObj.id("userNameId"));
		//driver.findElement(By.id(OR.getProperty("userNameId"))).sendKeys(userName);
		getElementByID("userNameId").sendKeys("demo");

		/*gmObj.id("userNameId").sendKeys(userName);
		gmObj.id("passwordId").sendKeys(password);
		gmObj.cssSelector("loginButton").click();
		if(gmObj.id("WelcomeAdmin").isDisplayed()){
			Reporter.log("User sucessfully logged in to orangeHRM");
		}
		else{
			Reporter.log("User failed to login to orangeHRM");
		}*/
	}

}
