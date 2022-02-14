package amazon.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Amazon_Login {
    static WebDriver driver;
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        amazonSelectingThings(driver);

        selectThings(driver);
       // addToCart(driver);
    }
    static void amazonSelectingThings(WebDriver driver) throws AWTException, InterruptedException {
        Amazon_Login.driver.get("https://www.amazon.com/");
        WebElement element = driver.findElement(By.linkText("Today's Deals"));
        element.click();
        WebElement element1 = driver.findElement(By.id("twotabsearchtextbox"));
        element1.sendKeys("watches for women");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);

        // Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
    static void selectThings(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);

        WebElement element2 = Amazon_Login.driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div[1]/span/a/div/img"));
        element2.click();
    }
       /* static void addToCart(WebDriver driver) throws AWTException, InterruptedException {


        WebElement element3;
        element3=Amazon_Login.driver.findElement(By.xpath(""));
        element3.click();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);

            // Release Enter
            robot.keyRelease(KeyEvent.VK_ENTER);



    } */
}
