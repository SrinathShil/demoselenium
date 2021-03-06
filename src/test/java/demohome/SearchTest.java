package demohome;


	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.junit.*;
	import static org.junit.Assert.*;
	import static org.hamcrest.CoreMatchers.*;
	import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class SearchTest {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	   // driver = new FirefoxDriver();
		  System.setProperty("webdriver.chrome.driver",
				  Thread.currentThread().getContextClassLoader().getResource("drivers/chromedriver.exe").getFile());
		    driver = new ChromeDriver();
	    baseUrl = "http://52.42.180.137:8087/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testHome() throws Exception {
	    driver.get(baseUrl + "/webapps/home.jsp");
	    assertEquals("Insert title heres", driver.getTitle());
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
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
