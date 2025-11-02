
package demo.pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private static final int TIMEOUT = 10;
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    protected WebElement waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void set(By locator, String text){
         find(locator).clear();
         find(locator).sendKeys(text); 
    }

    protected void setDrop(By locator, String text){
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(text);
    }
    protected void click(By locator){
        find(locator).click();
    }
    protected void clear(By locator){
        find(locator).clear();
    }

    protected void pressTab(By locator){
        find(locator).sendKeys(Keys.TAB);
}

}
