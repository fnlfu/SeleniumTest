import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tests extends TestsMet{

    @Test
    public void firstTest(){
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement form = driver.findElement(By.cssSelector("div[class='wpb_text_column wpb_content_element '] div[class='wpb_wrapper']"));
        form.findElement(By.name("firstname")).sendKeys("Adam");
        form.findElement(By.name("lastname")).sendKeys("Adamowski");
        paczek("sex");
        paczek("exp");
        form.findElement(By.id("datepicker")).sendKeys("10-01-2011");
        paczek("profession");
        form.findElement(By.name("photo")).sendKeys("C:\\Users\\dbujak\\Desktop\\Projekty\\SeleniumTest\\src\\test\\img\\img.png");
        paczek("tool");

        Select selectContinents = new Select(form.findElement(By.name("continents")));
        selectContinents.selectByIndex(r.nextInt(7));
        Select selectCommands = new Select(form.findElement(By.name("selenium_commands")));
        selectCommands.selectByIndex(r.nextInt(5));
        form.findElement(By.name("submit")).click();
    }
}
