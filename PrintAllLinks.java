package links;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintAllLinks {
    static WebDriver driver;
    static WebElement element;


    public static void main(String[] args) throws IOException, WriteException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.amazon.com/events/epicdeals?ref_=nav_cs_gb");
        driver.manage().window().maximize();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\bhargavi.kallagunta\\IdeaProjects\\Project\\fileReader\\book.xls");
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(fileOutputStream);
        WritableSheet writableSheet = writableWorkbook.createSheet("Sheet0", 0);
        List<String> links = new ArrayList<>();


        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println("Total links(unique and duplicate):" + linksList.size());
        for (int i = 0; i < linksList.size(); i++) {
            //System.out.println("Links on page are:" + linksList.get(i).getAttribute("href"));
            //System.out.println("Link Name :" + linksList.get(i).getText());
            links.add(linksList.get(i).getAttribute("href"));
        }
        Set<String> set = links.stream().collect(Collectors.toSet());
        System.out.println("Unique links:"+set.size());
        for (int i = 0; i < set.size(); i++) {

            Object[] obj = set.toArray();
            if (obj[i] != null) {
                Label label = new Label(0, i, obj[i].toString());
                System.out.println(obj[i]);
                writableSheet.addCell(label);
            }

        }
        writableWorkbook.write();
        writableWorkbook.close();
    }

}








