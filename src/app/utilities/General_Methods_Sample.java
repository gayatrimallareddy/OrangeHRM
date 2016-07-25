package app.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class General_Methods_Sample {
		
	WebDriver driver;
	FileInputStream fis = null;
	Properties config = new Properties();
	Properties OR = new Properties();

	
	public General_Methods_Sample(WebDriver driver) {
		this.driver=driver;
		try {
			FileInputStream fisConfig = new FileInputStream(System.getProperty("user.dir")+"\\src\\app\\property\\files\\config.properties");
			FileInputStream fisOr = new FileInputStream(System.getProperty("user.dir")+"\\src\\app\\property\\files\\OR.properties");
			config.load(fisConfig);
			OR.load(fisOr);
		} catch (Exception E) {
			System.out.println("Exception : " + E);
		}
		
		if(config.getProperty("browserType").equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(config.getProperty("browserType").equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(config.getProperty("browserType").equals("IE")) {
			driver = new InternetExplorerDriver();
		}
		else{
			System.out.println("Please choose Firefox or Chrome or IE");
		}
		driver.manage().window().maximize();
		
	}
	
	public WebElement id(String idVar){
		try {
			System.out.println("I'm from general method "+OR.getProperty(idVar));
			System.out.println("WebElement "+driver.findElement(By.id(OR.getProperty(idVar))));
			return driver.findElement(By.id(OR.getProperty(idVar)));
		}
		catch(Exception E) {
			System.out.println("Exception : " + E);
			return null;
		}
	}
	
	public WebElement getElementByID(String Key){
	   try{
		   System.out.println(OR.getProperty(Key));
		   return driver.findElement(By.id(OR.getProperty(Key)));
	   }catch(Throwable t){
		   System.out.println("Object not found for key -- "+Key);
		   return null;
	   }
	}
	
	public WebElement name(String nameVar){
		try {
			return driver.findElement(By.name(OR.getProperty(nameVar)));
		}
		catch(Exception E) {
			System.out.println("Exception : " + E);
			return null;
		}
	}
	
	public WebElement className(String classNameVar){
		try {
			return driver.findElement(By.className(OR.getProperty(classNameVar)));
		}
		catch(Exception E) {
			System.out.println("Exception : " + E);
			return null;
		}
	}
	
	public WebElement linkText(String linkTextVar){
		try {
			return driver.findElement(By.linkText(OR.getProperty(linkTextVar)));
		}
		catch(Exception E) {
			System.out.println("Exception : " + E);
			return null;
		}
	}
	
	public WebElement cssSelector(String cssSelectorVar){
		try {
			return driver.findElement(By.cssSelector(OR.getProperty(cssSelectorVar)));
		}
		catch(Exception E) {
			System.out.println("Exception : " + E);
			return null;
		}
	}
	
	public WebElement xpath(String xpathVar){
		try {
			return driver.findElement(By.xpath(OR.getProperty(xpathVar)));
		}
		catch(Exception E) {
			System.out.println("Exception : " + E);
			return null;
		}
	}
	
	
	
	public String demo(){
		return OR.getProperty("userNameId");
	}
		 
	
}
