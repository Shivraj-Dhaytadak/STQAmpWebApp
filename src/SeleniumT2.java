import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumT2 {
	private String NewPass = "Test@123" ;
	WebDriver driver;
	WebElement element;
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
	@Test 
	public void TodayContacts() {
		AdminLogin();
		driver.get("http://localhost/contactform/admin/todays-contact.php");
		String expectedDetailString = "Today's Contacts";
		String actualString =driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/h3")).getText();
		Assert.assertEquals(actualString, expectedDetailString);
		
	}
}
