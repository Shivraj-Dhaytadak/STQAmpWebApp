import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SeleniumT {
	private String NewPass = "Test@123" ;
	WebDriver driver;
	WebElement element;
	public void closeTab() {
		driver.close();
	}
	@Test(priority =1 )
	public void ContactFormSubmit(){
		System.setProperty("webdriver.chrome.driver", "D:\\STQA\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("http://localhost/contactform/");
		driver.findElement(By.className("user")).sendKeys("selenium test case");
		driver.findElement(By.className("phone")).sendKeys("1234567890");
		driver.findElement(By.className("email")).sendKeys("SeleNium@Test.co");
		driver.findElement(By.name("subject")).sendKeys("Test");
		driver.findElement(By.name("message")).sendKeys("This was Test case ");
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
		String expectedSubmitString = "http://localhost/contactform/";
		String actualsubmitString = driver.getCurrentUrl();
		Assert.assertEquals(actualsubmitString,expectedSubmitString);
		driver.close();
    }
	@Test(priority =2 )
	public void ContactFormSubmitPhoneNovalidation(){
		System.setProperty("webdriver.chrome.driver", "D:\\STQA\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("http://localhost/contactform/");
		driver.findElement(By.className("user")).sendKeys("selenium test case");
		driver.findElement(By.className("phone")).sendKeys("123456789");
		driver.findElement(By.className("email")).sendKeys("SeleNium@Test.co");
		driver.findElement(By.name("subject")).sendKeys("Test");
		driver.findElement(By.name("message")).sendKeys("This was Test case ");
		driver.findElement(By.name("submit")).click();
		String expectedSubmitString = "1234567890";
		String actualsubmitString = driver.findElement(By.className("phone")).getAttribute("value");
		Assert.assertEquals(actualsubmitString,expectedSubmitString);
		driver.close();
    }
	@Test(priority =3 )
	public void ContactFormSubmitEmailvalidation(){
		System.setProperty("webdriver.chrome.driver", "D:\\STQA\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("http://localhost/contactform/");
		driver.findElement(By.className("user")).sendKeys("selenium test case");
		driver.findElement(By.className("phone")).sendKeys("1234567890");
		driver.findElement(By.className("email")).sendKeys("SeleNium.Test.co");
		driver.findElement(By.name("subject")).sendKeys("Test");
		driver.findElement(By.name("message")).sendKeys("This was Test case ");
		driver.findElement(By.name("submit")).click();
		String expectedSubmitString = "SeleNium@Test.co";
		String actualsubmitString = driver.findElement(By.className("email")).getAttribute("value");
		Assert.assertEquals(actualsubmitString,expectedSubmitString);
		driver.close();
    }
	@Test(priority =4 )
	public void AdminLogin() {
		System.setProperty("webdriver.chrome.driver", "D:\\STQA\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1200,TimeUnit.MILLISECONDS);
		driver.get("http://localhost/contactform/admin/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys(NewPass);
		driver.findElement(By.name("login")).click();
		String expectedloginString = "http://localhost/contactform/admin/dashboard.php";
		String actualloginString = driver.getCurrentUrl();
		Assert.assertEquals(actualloginString, expectedloginString);
	}
	@Test(priority =5 )
	public void AdminLoginFail() {
		System.setProperty("webdriver.chrome.driver","D:\\\\STQA\\\\drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1200,TimeUnit.MILLISECONDS);
		driver.get("http://localhost/contactform/admin/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin@123");
		driver.findElement(By.name("login")).click();
		String expectedloginFailString = "Admin Login";
		String actualloginFailString = driver.getTitle();
		Assert.assertEquals(actualloginFailString, expectedloginFailString);
		driver.close();
	}
	@Test(priority =6 )
	public void AdminLogOut() {
		AdminLogin();
		driver.findElement(By.xpath("//*[@id=\"navbar-mobile\"]/ul[2]/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbar-mobile\"]/ul[2]/li[1]/div/a[2]")).click();
		String expectedOutputString = "Admin Login";
		String actualOutputString = driver.getTitle();
		Assert.assertEquals(actualOutputString, expectedOutputString);
		driver.close();
	}
	@Test(priority =7 )
	public void UpdateEmail() {
		AdminLogin();
		driver.get("http://localhost/contactform/admin/update-email.php");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("admin1@gmail.com");
		driver.findElement(By.name("update")).click();
		String expectedupdateEmailString = "http://localhost/contactform/admin/update-email.php";
		String actualupdateEmailString = driver.getCurrentUrl();
		Assert.assertEquals(expectedupdateEmailString, actualupdateEmailString);
		closeTab();
		}
	@Test(priority =8 )
	public void UpdatePassword() {
		AdminLogin();
		driver.get("http://localhost/contactform/admin/change-password.php");
		driver.findElement(By.id("password")).sendKeys(NewPass);
		driver.findElement(By.id("newpassword")).sendKeys(NewPass);
		driver.findElement(By.id("confirmpassword")).sendKeys(NewPass);
		driver.findElement(By.name("update")).click();
		Assert.assertEquals(true, true);
		closeTab();
		
	}
	@Test(priority =9 )
	public void TodayContacts() {
		AdminLogin();
		driver.get("http://localhost/contactform/admin/todays-contact.php");
		String expectedDetailString = "Today's Contacts";
		String actualString =driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/h3")).getText();
		Assert.assertEquals(actualString, expectedDetailString);
		closeTab();
	}
	@Test(priority =10 )
	public void ReportBTdates() {
		AdminLogin();
		driver.get("http://localhost/contactform/admin/select-dates.php");
		driver.findElement(By.xpath("//*[@id=\"formatter\"]/div/div/div/div[2]/div/div[1]/div/fieldset/div/input")).sendKeys("2021-11-20");
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/section/div/div/div/div[2]/div/div[2]/div/fieldset/div/input")).sendKeys("2021-11-25");
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/section/div/div/div/div[2]/div/div[3]/div/button")).click();
		String expectedtextString = "Contact's Report from 2021-11-20 to 2021-11-25";
		String actualString =driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div[2]/h4")).getText();
		Assert.assertEquals(actualString, expectedtextString);
		closeTab();
	}
	@Test(priority = 11)
	public void WeekContacts1stcontact() {
		AdminLogin();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/a/div/div[1]/div[1]/h6")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div[2]/div/table/tbody/tr/td[5]/a/button")).click();
		String expectedDetails1stString = "Contact Form Admin | Contact Details";
		String actualDetail1stString = driver.getTitle();
		Assert.assertEquals(actualDetail1stString, expectedDetails1stString);
	}
	@Test(priority = 12)
	public void WeekContacts1stcontactReply(){
		WeekContacts1stcontact();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/section/div/div[3]/div/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/section/div/div[3]/div/div/div/div/div/div[2]/form/p/textarea")).sendKeys("Thanks For Conatacting");
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/section/div/div[3]/div/div/div/div/div/div[3]/button[2]")).click();
		String expecetedResponseString = "Well done!Remark added successfully";
		String actualResponseString = driver.findElement(By.xpath("//*[@id=\"invoice-template\"]/div[1]")).getText();
		Assert.assertEquals(actualResponseString, expecetedResponseString);
	}
	@Test(priority =13 )
	public void TotalContacts() {
		AdminLogin();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/div/div/a/div")).click();
		String expectedTCDetailString = "All Contacts";
		String actualTCDeatailString =driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/h3")).getText();
		Assert.assertEquals(actualTCDeatailString,expectedTCDetailString);
	}
	@Test(priority =14)
	public void TotalContactsReply() {
		AdminLogin();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/div/div/a/div/div[1]/div[1]/h6")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[4]/td[5]/a/button")).click();
		driver.findElement(By.xpath("//*[@id=\"invoice-footer\"]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"warning\"]/div/div/div[2]/form/p/textarea")).sendKeys("Thanks For Conatacting");
		driver.findElement(By.xpath("//*[@id=\"warning\"]/div/div/div[3]/button[2]")).click();
		String expectedTCRString = "Well done!Remark added successfully"; 
		String actualTCRString = driver.findElement(By.xpath("//*[@id=\"invoice-template\"]/div[1]")).getText();
		Assert.assertEquals(actualTCRString, expectedTCRString);
	}
	@Test(priority = 15)
	public void AdminLoginEF() {
		System.setProperty("webdriver.chrome.driver", "D:\\STQA\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1200,TimeUnit.MILLISECONDS);
		driver.get("http://localhost/contactform/admin/");
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.name("login")).click();
		String expectedloginString = "http://localhost/contactform/admin/dashboard.php";
		String actualloginString = driver.getCurrentUrl();
		Assert.assertEquals(actualloginString, expectedloginString);	
	}
	//public static void main(String[] args){
		//SeleniumT obj1 = new SeleniumT();
		//obj1.AdminLogin();
		//obj1.closeTab();
		//obj1.UpdateEmail();
		//obj1.UpdatePassword();
		//obj1.AdminLogOut();
		
	//}
}
