package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    protected static final String URL = "https://vercel.app/";
    //protected static final String URL = "http://localhost:3000/";

    public BasePage() {
        if(webDriver == null) {
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        }
    }

    public void openApp() {
        webDriver.get(URL);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public WebElement getWebElementByXpath(String xpath) {
        WebElement webElement = null;
        try {
            webElement = webDriver.findElement(By.xpath(xpath));
        } catch (Exception e) {
            System.out.println("There is no element: " + xpath);
            System.out.println("Exception message: " + e);
        }
        return webElement;
    }

    public WebElement waitForElementByXpath(String xpath) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

}
