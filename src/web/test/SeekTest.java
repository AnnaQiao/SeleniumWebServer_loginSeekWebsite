package web.test;
//Author :  ANNA QIAO
//date:  4/3/2018

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeekTest {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.marionette", "C:/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.seek.co.nz/");
	}

	// ** Test Case ID : jobSearchTestCase001
	// *Test Case Summary : Searching job by using valid keywords
	// *Test Case Precondition: User is on the home page of Seek
	// *Test Case Step 1: User enter "test" in keywords
	// *Test Case Step 2: User click "SEEK" button
	// *Test Case Step 3: getting results and comparing with excepted resul
	// *Test Case postcondition: Closing the browse

	@Test
	public void jobSearchTestCase001() throws Exception {
		// step1
		WebElement element = driver.findElement(By.name("keywords"));
		element.sendKeys("test");
		// step2
		WebElement seek = driver.findElement(By.xpath("//button[@type='submit']"));
		seek.click();
		// getting the result
		String getSearchResult = null;
		getSearchResult = driver.findElements(By.cssSelector("strong")).get(3).getText();
		getSearchResult = getSearchResult.replace(",", "");
		int actualRST = Integer.parseInt(getSearchResult);
		// comparing with excepted result
		Assert.assertFalse(actualRST == 0);
	}

	// ** Test Case ID : jobSearchTestCase002
	// * Test Case Summary : Searching job by using invalid keywords
	// * Test Case Precondition: User is on the home page of Seek
	// * Test Case Step 1: User enter "????" in keywords
	// * Test Case Step 2: User click "SEEK" button
	// * Test Case Step 3: getting results and comparing with excepted result
	// * Test case postcondition: Closing the browse
	@Test
	public void jobSearchTestCase002() throws Exception {
		// step1
		WebElement element = driver.findElement(By.name("keywords"));
		element.sendKeys("????");
		// step2
		WebElement seek = driver.findElement(By.xpath("//button[@type='submit']"));
		seek.click();
		// getting the result
		String getSearchResult = null;
		getSearchResult = driver.findElements(By.cssSelector("strong")).get(3).getText();
		getSearchResult = getSearchResult.replace(",", "");
		int actualRST = Integer.parseInt(getSearchResult);
		// comparing with excepted result
		Assert.assertTrue(actualRST == 0);
	}

	// ** Test Case ID : jobSearchTestCase003
	// * Test Case Summary : Searching job by using classification
	// * Test Case Precondition: User is on the home page of Seek
	// * Test Case Step 1: User select"Information & Communication Technology"in classification
	// * Test Case Step 2: User select"Architects" n classification
	// * Test Case Step 3: User click "Seek" button
	// * Test Case Step 4: getting results and comparing with excepted result
	// * Test case postcondition: Closing the browse
	@Test
	public void jobSearchTestCase003() throws Exception {
		// step1
		driver.findElement(By.cssSelector("label[for='SearchBar__Classifications']")).click();
		driver.findElement(By.xpath("//a[contains(@href, '/?classification=6281')]")).click();
		// step2
		driver.findElement(By.xpath("//a[contains(@href, '/?classification=6281&subclassification=6282')]")).click();
		// step3
		driver.findElement(By.cssSelector("label[for='SearchBar__Classifications']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// step4 getting the result
		Thread.sleep(1000);
		String getSearchResult = null;
		getSearchResult = driver.findElements(By.cssSelector("strong")).get(3).getText();
		getSearchResult = getSearchResult.replace(",", "");
		int actualRST = Integer.parseInt(getSearchResult);
		// comparing with excepted result
		Assert.assertFalse(actualRST == 0);
	}

	// ** Test Case ID : jobSearchTestCase003
	// * Test Case Summary : Searching job by using classification
	// * Test Case Precondition: User is on the home page of Seek
	// * Test Case Step 1: User enter "test" in keyword
	// * Test Case Step 2: User enter "Auckland" in location
	// * Test Case Step 3: User click "Seek" button
	// * Test Case Step 4: getting results and comparing with excepted result
	// * Test case postcondition: Closing the browse
	@Test
	public void jobSearchTestCase004() throws Exception {
		// step1
		WebElement keyWords = driver.findElement(By.name("keywords"));
		keyWords.sendKeys("test");
		// step2
		driver.findElement(By.id("SearchBar__Where")).sendKeys("Auckland");
		driver.findElement(By.cssSelector("div[id='react-autowhatever-1']")).click();
		// step3
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// step4 getting the result
		Thread.sleep(1000);
		String getSearchResult = null;
		getSearchResult = driver.findElements(By.cssSelector("strong")).get(3).getText();
		getSearchResult = getSearchResult.replace(",", "");
		int actualRST = Integer.parseInt(getSearchResult);
		// comparing with excepted result
		Assert.assertFalse(actualRST == 0);
	}

	@After
	public void tearDown() throws Exception {
		// close browser
		driver.quit();
	}
}
