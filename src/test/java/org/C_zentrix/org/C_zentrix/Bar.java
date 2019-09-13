package org.C_zentrix.org.C_zentrix;
import static org.testng.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Bar 
{
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @BeforeTest
	  public void setUp() throws Exception {
			System.setProperty("webdriver.gecko.driver", "D:\\himanshu\\driver\\firefoxdriver64\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "http://192.168.1.57/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void Bar_call() throws Exception {
	    driver.get(baseUrl + "czhandler/cti_handler.php?e=235");
	    Thread.sleep(2000);
	    System.out.println("Bar call start");
	    driver.switchTo().frame(driver.findElement(By.name("main_call_window")));
	   System.out.println("switch to iframe");
	   driver.findElement(By.id("n")).clear();
	  driver.findElement(By.id("n")).sendKeys("111111111");
	    driver.findElement(By.id("dial_phone")).click();
	    Thread.sleep(20000);
	    driver.navigate().refresh();
	    System.out.println("refresing the window");
	    Thread.sleep(2000);
	   
		System.out.println("dial");
		
	 /*if (driver.findElement(By.id("hold")).isElementPresent(By.id("hold")))
	    {   System.out.println("in if");
	    	driver.findElement(By.id("hold")).click();
        System.out.println("hold");  
	        Thread.sleep(2000);
	        driver.findElement(By.id("unhold")).click();	
	        System.out.println("unhold");
	    }*/
	    
	    //Thread.sleep(2000);
	    driver.findElement(By.id("take_break")).click();	    
	    new Select(driver.findElement(By.id("break_reason_dd"))).selectByVisibleText("BREAK");	    
	    driver.findElement(By.cssSelector("option[value=\"BREAK\"]")).click();	  
	    driver.findElement(By.id("final_take_break")).click(); 
	    System.out.println("out of break");
	   // driver.findElement(By.id("call_conference")).click(); 
	    System.out.println("click on conf");
	    
	   //driver.findElement(By.name("backToMain[3131]")).click(); 
	    System.out.println("back to main");
	    Thread.sleep(2000);
	    driver.findElement(By.id("get_disposition")).click();	   
	    driver.findElement(By.id("category_dd")).click();	   
	    driver.findElement(By.id("disposition_dd")).click();	   
	    driver.findElement(By.id("comments")).click();   
	    driver.findElement(By.id("comments")).clear();
	    driver.findElement(By.id("comments")).sendKeys("test");	   
	    driver.findElement(By.id("set_disposition")).click();	   
	    driver.findElement(By.id("disconnect")).click();	    
	    driver.findElement(By.id("back_from_break")).click();    
	  }

	  @AfterTest
	  public void tearDown() throws Exception {
	   // driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
