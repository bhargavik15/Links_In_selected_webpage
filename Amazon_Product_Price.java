package amazon.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

public class Amazon_Product_Price {
// //span[@class='a-size-small']
    // //*[@id="p13n-asin-index-4"]/div/div[2]/div/span
    //  list.get(i).getText()

    //  //*[@id=\"p13n-asin-index-"+list.get(i).getText()+"\"]/div/div[2]/div/span


    WebDriver driver;
    WebElement element;
    @BeforeTest
    void openURL(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/b?node=283155");
    }
    @AfterTest
    void closeBrowser(){
        driver.quit();
    }
    @Test
    void validateCheckBox() {


        List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-small']"));
        Map maps = new TreeMap();
        for (int i = 0; i < list.size(); i++) {

            try{

                WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"p13n-asin-index-"+list.get(i).getText()+"\"]/div/div[2]/div/span"));
                maps.put("list","checkbox");
               // if (checkbox.isDisplayed()) checkbox.click();
            }catch(Exception exception) {
                System.out.println(list.get(i).getText());
            }
        }
    }
}

