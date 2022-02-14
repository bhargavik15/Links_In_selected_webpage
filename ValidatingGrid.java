package grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ValidatingGrid {
    static WebDriver driver;
    static String nodeUrl;
    public static void main(String[] args) throws MalformedURLException {
        try {


            nodeUrl = "http://192.168.43.253:9875/wd/hub";
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WIN10);
            capabilities.setVersion("3.141.59");
            driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);


                    }
        catch (MalformedURLException  e){
            e.printStackTrace();
        }

    }
}
