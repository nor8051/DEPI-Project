package paraBankTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ParaBankM {
	
	WebDriver driver;
    String baseURL = "https://parabank.parasoft.com/parabank/index.htm";

    @BeforeMethod
    public void beforeTest() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }
    /*
  @Test
  public void ContactUs() throws InterruptedException {
	  WebElement AboutUs= driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[2]/a"));
	  AboutUs.click();
	  
	  WebElement DemoTxt= driver.findElement(By.className("title"));
	  Assert.assertEquals(DemoTxt.getText(),"ParaSoft Demo Website");
	  Thread.sleep(1000);
	  
	  WebElement WebSiteURL = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p[3]/a"));
	  WebSiteURL.click();
	  
	  WebElement ContactUsButton= driver.findElement(By.xpath("/html/body/div[3]/header/div/div/div/nav[1]/ul/li[6]/a"));
	  ContactUsButton.click();
	  Thread.sleep(1000);
      
      WebElement Email= driver.findElement(By.id("email-7e18a454-1995-49f5-a907-ddc7be450646"));
      Email.sendKeys("marriammohii@gmail.com");
      
      WebElement FirstName = driver.findElement(By.id("firstname-7e18a454-1995-49f5-a907-ddc7be450646"));
      FirstName.sendKeys("Mariam");
      
      WebElement LastName = driver.findElement(By.id("lastname-7e18a454-1995-49f5-a907-ddc7be450646"));
      LastName.sendKeys("Mohi");
      
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0, 200);");
      Thread.sleep(2000);
      
      WebElement Cop = driver.findElement(By.id("company-7e18a454-1995-49f5-a907-ddc7be450646"));
      Cop.sendKeys("SIT");
      
      WebElement JobTitle = driver.findElement(By.id("jobtitle-7e18a454-1995-49f5-a907-ddc7be450646"));
      JobTitle.sendKeys("Software Tester");
      
      WebElement Phone = driver.findElement(By.id("phone-7e18a454-1995-49f5-a907-ddc7be450646"));
      Phone.sendKeys("01110524072");
      
      
      WebElement Country = driver.findElement(By.id("country-7e18a454-1995-49f5-a907-ddc7be450646"));
	  Select EgyCountry=new Select(Country);
	  EgyCountry.selectByVisibleText("Egypt");
	  Thread.sleep(3000);
	  
	  WebElement Comments= driver.findElement(By.id("comments-7e18a454-1995-49f5-a907-ddc7be450646"));
	  Comments.sendKeys("bla bla bla");
	  Thread.sleep(1000);
	  
      js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0, 300);");
      Thread.sleep(2000);
	  
	  WebElement ContactUs= driver.findElement(By.xpath("//*[@id=\"hsForm_7e18a454-1995-49f5-a907-ddc7be450646\"]/div/div[2]/input"));
	  ContactUs.click();
	  Thread.sleep(2000);
	  
	  
      WebElement ThankYou= driver.findElement(By.xpath("//*[@id=\"main\"]/section[2]/div/div/h2"));
	  Assert.assertEquals(ThankYou.getText(),"Thank You!");
	  Thread.sleep(1000);  
  }
  
 */
  @Test
  public void ProductsRequist() throws InterruptedException{
	  WebElement ProductsSelection= driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[1]/li[4]/a"));
	  ProductsSelection.click();
	  
	  Thread.sleep(1000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0, 2000);");
      Thread.sleep(2000);
      
      WebElement ReqDemo= driver.findElement(By.xpath("//*[@id=\"results\"]/div/div[1]/div[1]/div[2]/a"));
      ReqDemo.click();
      
      Thread.sleep(2000);
      
      WebElement CompName= driver.findElement(By.id("email-ac031725-1541-4bcb-a4b1-baf748fba09b"));
      CompName.sendKeys("maryam@sitksa-eg.com");
      
      WebElement FirstName = driver.findElement(By.id("firstname-ac031725-1541-4bcb-a4b1-baf748fba09b"));
      FirstName.sendKeys("Mariam");
      
      WebElement LastName = driver.findElement(By.id("lastname-ac031725-1541-4bcb-a4b1-baf748fba09b"));
      LastName.sendKeys("Mohi");
      
      Thread.sleep(1000);
	  js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0, 500);");
      Thread.sleep(1000);
      
      WebElement Cop = driver.findElement(By.id("company-ac031725-1541-4bcb-a4b1-baf748fba09b"));
      Cop.sendKeys("SIT");
      
      WebElement JobTitle = driver.findElement(By.id("jobtitle-ac031725-1541-4bcb-a4b1-baf748fba09b"));
      JobTitle.sendKeys("Software Tester");
      
      WebElement Phone = driver.findElement(By.id("phone-ac031725-1541-4bcb-a4b1-baf748fba09b"));
      Phone.sendKeys("01110524072");
      
      
      WebElement Country = driver.findElement(By.id("country-ac031725-1541-4bcb-a4b1-baf748fba09b"));
	  Select EgyCountry=new Select(Country);
	  EgyCountry.selectByVisibleText("Egypt");
	  Thread.sleep(3000);
	  
	  
	  js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0, 200);");
      Thread.sleep(1000);
      
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement demoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hsForm_ac031725-1541-4bcb-a4b1-baf748fba09b\"]/div[15]/div[2]/input")));
      demoButton.click();
      Thread.sleep(2000);
      
      WebElement ThankYou= driver.findElement(By.xpath("//*[@id=\"main\"]/section[2]/div/div/h2"));
	  Assert.assertEquals(ThankYou.getText(),"Thank You!");
	  Thread.sleep(1000);
       
  }
  
  @AfterMethod
  public void afterTest() {
      driver.quit();
  }
}
