import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.lang.model.util.Elements;
import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestsMet {

    WebDriver driver;
    Random r = new Random();

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void paczek(String name){
        List<WebElement> select = driver.findElements(By.name(name));
        select.get(r.nextInt(select.size())).click();

    }

}
