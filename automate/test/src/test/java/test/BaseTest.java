//src/test/java/test/BaseTest.java
package test;
import demo.pages.CalculatePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    // protected BasePage basePage;
    protected CalculatePage calculatePage;
    private String url = "https://www.calculator.net/carbohydrate-calculator.html";
    
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        calculatePage = new CalculatePage();
        calculatePage.setDriver(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
