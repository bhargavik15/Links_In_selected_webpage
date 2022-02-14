package amazon.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ValidateCheckBox {
    WebDriver driver;
    @BeforeTest
    void openURL(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com/events/epicdeals?ref_=nav_cs_gb");
    }
    @AfterTest
    void closeBrowser(){
        driver.quit();
    }
    @Test
    void validateCheckBox() {
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F']"));
        for (int i = 0; i < list.size(); i++) {
            try{
                WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']//following-sibling::span[text()='" + list.get(i).getText() + "']"));
                if (checkbox.isDisplayed()) checkbox.click();
            }catch(Exception exception) {
                System.out.println(list.get(i).getText());
            }
        }
    }
}

