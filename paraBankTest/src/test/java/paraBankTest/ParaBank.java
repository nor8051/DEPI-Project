package paraBankTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBank {
    WebDriver driver;
    WebDriverWait wait;
    String baseURL = "https://parabank.parasoft.com/parabank/index.htm";

    @BeforeMethod
    public void beforeTest() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }
    
    @Test(priority = 1)
    public void testPositiveRegistration() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Group2");
        driver.findElement(By.id("customer.lastName")).sendKeys("MBNOT");
        driver.findElement(By.id("customer.address.street")).sendKeys("street 100");
        driver.findElement(By.id("customer.address.city")).sendKeys("Cairo");
        driver.findElement(By.id("customer.address.state")).sendKeys("Cairo");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("110011");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123456789");
        driver.findElement(By.id("customer.ssn")).sendKeys("123-45-6789");
        driver.findElement(By.id("customer.username")).sendKeys("Gro_uppp02");
        driver.findElement(By.id("customer.password")).sendKeys("MBNOT");
        driver.findElement(By.id("repeatedPassword")).sendKeys("MBNOT");
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        String actualMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText();
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        assertEquals(actualMessage, expectedMessage);
    }
    
    @Test(priority = 2)
    public void testNegativeRegistration() throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Nour");
        driver.findElement(By.id("customer.lastName")).sendKeys("Han");
        driver.findElement(By.id("customer.address.street")).sendKeys("Street 100");
        driver.findElement(By.id("customer.address.city")).sendKeys("Cqiro");
        driver.findElement(By.id("customer.address.state")).sendKeys("Cqiro");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("110011");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("0987654321");
        driver.findElement(By.id("customer.ssn")).sendKeys("987-65-4321");
        driver.findElement(By.id("customer.username")).sendKeys("Noara");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String actualMessage = driver.findElement(By.id("customer.password.errors")).getText();
        String expectedMessage = "Password is required.";
        String actualMessage1 = driver.findElement(By.id("repeatedPassword.errors")).getText();
        String expectedMessage1 = "Password confirmation is required.";

        assertEquals(actualMessage, expectedMessage);
        assertEquals(actualMessage1, expectedMessage1);
    }


   
    @Test(priority = 3, dependsOnMethods = {"testPositiveRegistration"})
    public void testPositiveLogin() {
        driver.findElement(By.name("username")).sendKeys("Gro_uppp02");
        driver.findElement(By.name("password")).sendKeys("MBNOT");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        String actualMessage = driver.findElement(By.xpath("//*[@id=\"showOverview\"]/h1")).getText();
        String expectedMessage = "Accounts Overview";
        assertEquals(actualMessage, expectedMessage);
    }
    
    @Test(priority = 4)
    public void testNegativeLogin() {
        driver.findElement(By.name("username")).sendKeys("wrong_user");
        driver.findElement(By.name("password")).sendKeys("wrong_password");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        String actualMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1")).getText();
        String expectedMessage = "Error!";
        assertEquals(actualMessage, expectedMessage);
    }
    

    @Test(priority = 5 , dependsOnMethods =  {"testPositiveLogin"})
    public void testOpenNewAccount() throws InterruptedException {
    	getLoginElements("Gro_uppp02", "MBNOT"); // Reusable login method

        driver.findElement(By.linkText("Open New Account")).click();
        driver.findElement(By.id("type")).sendKeys("Savings");
        driver.findElement(By.id("fromAccountId")).sendKeys("24888"); // Select a valid account
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"openAccountForm\"]/form/div/input")).click();

        Thread.sleep(1000);
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"openAccountResult\"]/p[1]")).getText();
        String expectedMessage = "Congratulations, your account is now open.";
        AssertJUnit.assertEquals(actualMessage, expectedMessage);
    }

    
    @Test(priority = 6 , dependsOnMethods =  {"testPositiveLogin"})
    public void testAccountsOverview() {
    	getLoginElements("Gro_uppp02", "MBNOT");

        driver.findElement(By.linkText("Accounts Overview")).click();
        String actualMessage = driver.findElement(By.xpath("//*[@id='showOverview']/h1")).getText();
        String expectedMessage = "Accounts Overview";
        AssertJUnit.assertEquals(actualMessage, expectedMessage);
    }
   
   
    @Test(priority = 7 , dependsOnMethods =  {"testPositiveLogin"})
    public void testTransferFunds() throws InterruptedException {
    	getLoginElements("Gro_uppp02", "MBNOT");

        driver.findElement(By.linkText("Transfer Funds")).click();
        driver.findElement(By.id("amount")).sendKeys("1000");
        driver.findElement(By.id("fromAccountId")).sendKeys("13455"); // Select valid account
        driver.findElement(By.id("toAccountId")).sendKeys("13455"); // Select valid account
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Transfer']")).click();
        
        Thread.sleep(1000);
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"showResult\"]/h1")).getText();
        String expectedMessage = "Transfer Complete!";
        AssertJUnit.assertEquals(actualMessage, expectedMessage);
    }

 
    
    @Test(priority = 8 , dependsOnMethods =  {"testPositiveLogin"})
    public void testBillPay() throws InterruptedException{
    	getLoginElements("Gro_uppp02", "MBNOT");
        driver.findElement(By.linkText("Bill Pay")).click();
        
        //Payee Name
        WebElement Payee_Name= driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[1]/td[2]/input"));
        Payee_Name.sendKeys("Utility Company");
        //Address
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[2]/td[2]/input")).sendKeys("123 Utility St");
        //City
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[3]/td[2]/input")).sendKeys("Utility City");
        //State
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[4]/td[2]/input")).sendKeys("CA");
        //Zip Code
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[5]/td[2]/input")).sendKeys("90001");
        
        //Phone #
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[6]/td[2]/input")).sendKeys("123456789");
        //Account #
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[8]/td[2]/input")).sendKeys("13455");
        //Verify Account #
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[9]/td[2]/input")).sendKeys("13455");
        
        //Amount
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[11]/td[2]/input")).sendKeys("1000");
        //From account #
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[13]/td[2]/select")).sendKeys("13455");
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[14]/td[2]/input")).click();

        /*
        Thread.sleep(2000);
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"billpayResult\"]/p[1]")).getText();
        String expectedMessage = "Bill Payment to Utility Company in the amount of $1000.00 from account 15231 was successful.";
        AssertJUnit.assertEquals(actualMessage, expectedMessage);*/
    }
    
    @Test(priority = 9 , dependsOnMethods =  {"testPositiveLogin"})
    public void testUpdateContactInfo() throws InterruptedException {
    	getLoginElements("Gro_uppp02", "MBNOT");

        driver.findElement(By.linkText("Update Contact Info")).click();
        WebElement addressField = driver.findElement(By.id("customer.address.street"));
        addressField.clear();
        addressField.sendKeys("New Address 123");
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Update Profile']")).click();

        Thread.sleep(1000);
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"updateProfileResult\"]/p")).getText();
        String expectedMessage = "Your updated address and phone number have been added to the system.";
        AssertJUnit.assertEquals(actualMessage, expectedMessage);
    }
    

    private void getLoginElements(String usernameTxt, String passwordTxt) {
        // Ensure the username and password fields are visible before interacting

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField =  driver.findElement(By.name("password"));
        
        // Input the username and password
        usernameField.sendKeys(usernameTxt);
        passwordField.sendKeys(passwordTxt);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginBtn.click();
    }
    
    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}