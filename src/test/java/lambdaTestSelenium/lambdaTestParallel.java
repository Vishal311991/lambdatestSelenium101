package lambdaTestSelenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class lambdaTestParallel {
	

	public String url = "https://www.lambdatest.com/selenium-playground/";
    public String username = "mr.vishalsharma31";
    public String accesskey = "leRniBj3FiJpgmERw7OCxZS9T7XwUQv1bpGmURFbvuwFpmJwJR";
    public static RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
	
	@BeforeTest
	@Parameters ({"browser"})
	public void setUp(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {
			
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("win10");
			browserOptions.setBrowserVersion("123.0");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "mr.vishalsharma31");
			ltOptions.put("accessKey", "leRniBj3FiJpgmERw7OCxZS9T7XwUQv1bpGmURFbvuwFpmJwJR");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("build", "ParallelTest");
			ltOptions.put("project", "LambdatestWindows");
			ltOptions.put("smartUI.project", "Selenium101");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("w3c", true);
			browserOptions.setCapability("LT:Options", ltOptions);
			
	        try {
	            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
	        } catch (MalformedURLException e) {
	            System.out.println("Invalid grid URL");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
			
		}else if (browser.equalsIgnoreCase("safari")){
			SafariOptions browserOptions = new SafariOptions();
			browserOptions.setPlatformName("macOS Ventura");
			browserOptions.setBrowserVersion("16.0");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "mr.vishalsharma31");
			ltOptions.put("accessKey", "leRniBj3FiJpgmERw7OCxZS9T7XwUQv1bpGmURFbvuwFpmJwJR");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("build", "ParallelTest");
			ltOptions.put("project", "Selenium101");
			ltOptions.put("smartUI.project", "Selenium101");
			ltOptions.put("w3c", true);
			browserOptions.setCapability("LT:Options", ltOptions);
			
	        try {
	            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
	        } catch (MalformedURLException e) {
	            System.out.println("Invalid grid URL");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		
	}
	
	
	@AfterTest
	
	public void tearDown() throws Exception {
	    driver.quit();
	  }
	
	
	@Test
	
	public void testScenario1() throws Exception {
		    driver.get(url);
//				Thread.sleep(3000);
			   	WebElement popUp = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
			   	if(popUp.isDisplayed()) {
		   			popUp.click();
		   		}
//			   	try {
//			   		if(popUp.isDisplayed()) {
//			   			popUp.click();
//			   		}
//			   		
//			   	}catch (Exception e) {
//			   		e.printStackTrace();
//			   	}
//			
		   	
		   	
		    driver.findElement(By.linkText("Simple Form Demo")).click();
		    String currentUrl = driver.getCurrentUrl();
		    Thread.sleep(3000);
		    driver.findElement(By.id("user-message")).clear();
		    String inputMessage = "Selenium_101";
		    driver.findElement(By.id("user-message")).sendKeys(inputMessage);
		    driver.findElement(By.id("showInput")).click();
		    String displayMessage = driver.findElement(By.id("message")).getText();
		    Assert.assertTrue(currentUrl.contains("simple-form-demo"), "URL does not contain 'simple-form-demo'");
		    Assert.assertEquals(inputMessage, displayMessage, "Display message is not same");
		    System.out.println("Scenario 1 test passed!");
		  }
		
	

	@Test
	
	public void testScenario2() throws InterruptedException {
		
	    driver.get(url);
//	   	Thread.sleep(3000);
	   	WebElement popUp = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
	   	if(popUp.isDisplayed()) {
   			popUp.click();
   		}
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
		int xOffset = 215; 
        new org.openqa.selenium.interactions.Actions(driver).dragAndDropBy(slider, xOffset, 0).build().perform();
        String rangeValue = driver.findElement(By.id("rangeSuccess")).getAttribute("value");
        Assert.assertEquals(rangeValue, "95", "Slider range value is not as expected");
        System.out.println("Senario 2 test passed!");
	}
	




@Test

	public void testScenario3() throws InterruptedException {
	
	driver.get(url);
 
//   	Thread.sleep(3000);
   	WebElement popUp = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
   	if(popUp.isDisplayed()) {
			popUp.click();
		}

    driver.findElement(By.linkText("Input Form Submit")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Vishal Sharma");
    driver.findElement(By.id("inputEmail4")).click();
    driver.findElement(By.id("inputEmail4")).clear();
    driver.findElement(By.id("inputEmail4")).sendKeys("mr.vishalsharma31@gmail.com");
    driver.findElement(By.id("inputPassword4")).click();
    driver.findElement(By.id("inputPassword4")).clear();
    driver.findElement(By.id("inputPassword4")).sendKeys("password");
    driver.findElement(By.id("company")).click();
    driver.findElement(By.id("company")).clear();
    driver.findElement(By.id("company")).sendKeys("testCompany");
    driver.findElement(By.id("websitename")).click();
    driver.findElement(By.id("websitename")).clear();
    driver.findElement(By.id("websitename")).sendKeys("lambdatest.com");
    driver.findElement(By.name("country")).click();
    new Select(driver.findElement(By.name("country"))).selectByVisibleText("India");
    driver.findElement(By.id("inputCity")).click();
    driver.findElement(By.id("inputCity")).clear();
    driver.findElement(By.id("inputCity")).sendKeys("Gurugram");
    driver.findElement(By.id("inputAddress1")).click();
    driver.findElement(By.id("inputAddress1")).clear();
    driver.findElement(By.id("inputAddress1")).sendKeys("Address1");
    driver.findElement(By.id("inputAddress2")).clear();
    driver.findElement(By.id("inputAddress2")).sendKeys("Address2");
    driver.findElement(By.id("inputState")).click();
    driver.findElement(By.id("inputState")).clear();
    driver.findElement(By.id("inputState")).sendKeys("Haryana");
    driver.findElement(By.id("inputZip")).click();
    driver.findElement(By.id("inputZip")).clear();
    driver.findElement(By.id("inputZip")).sendKeys("122001");
    driver.findElement(By.xpath("//form[@id='seleniumform']/div[6]/button")).click();
    String sucessMessage = driver.findElement(By.xpath("//div[@id='__next']/div/section[2]/div/div/div/div/p")).getText();
    String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";
    Assert.assertEquals(sucessMessage, expectedMessage, "Display message is not as expected");
    System.out.println("Scenario 3 test passed!");

    
}
	
}
