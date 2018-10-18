import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tests extends TestsMet{

    @Test
    public void testFirst(){
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement form = driver.findElement(By.cssSelector("div[class='wpb_text_column wpb_content_element '] div[class='wpb_wrapper']"));
        form.findElement(By.name("firstname")).sendKeys("Adam");
        form.findElement(By.name("lastname")).sendKeys("Adamowski");
        paczek("sex");
        paczek("exp");
        form.findElement(By.id("datepicker")).sendKeys("10-01-2011");
        paczek("profession");
        File file = new File("src/test/img/img.png");
        form.findElement(By.name("photo")).sendKeys(file.getAbsolutePath());
        paczek("tool");
        Select selectContinents = new Select(form.findElement(By.name("continents")));
        selectContinents.selectByIndex(r.nextInt(7));
        Select selectCommands = new Select(form.findElement(By.name("selenium_commands")));
        selectCommands.selectByIndex(r.nextInt(5));
        form.findElement(By.name("submit")).click();
    }

    @Test
    public void testSec() {
        driver.get("http://toolsqa.com/automation-practice-table/");
        List<WebElement> trList = driver.findElements(By.cssSelector("table[summary='Sample Table'] tbody tr"));
        List<TableList> tableLists = new ArrayList<TableList>();
//        trList.forEach(tr->{tableLists.add(new TableList(tr));});
        for (WebElement tr:trList) {
            tableLists.add(new TableList(tr));
        }
        //tableLists.forEach(x->x.printTable());
        for (TableList tl:tableLists) {
            tl.printTable();
        }
        Assert.assertEquals(tableLists.get(0).getCountry(),"UAE");
        Assert.assertEquals(tableLists.get(1).getBuild(),2012);
        Assert.assertEquals(tableLists.get(3).getStructure(),"Financial Center");
    }
    /**
    @Test
    public void secTest(){
        driverF.get("http://toolsqa.com/automation-practice-form/");
        WebElement form = driverF.findElement(By.cssSelector("div[class='wpb_text_column wpb_content_element '] div[class='wpb_wrapper']"));
        form.findElement(By.name("firstname")).sendKeys("Adam");
        form.findElement(By.name("lastname")).sendKeys("Adamowski");
        paczek("sex");
        paczek("exp");
        form.findElement(By.id("datepicker")).sendKeys("10-01-2011");
        paczek("profession");
        File file = new File("src/test/img/img.png");
        form.findElement(By.name("photo")).sendKeys(file.getAbsolutePath());
        paczek("tool");

        Select selectContinents = new Select(form.findElement(By.name("continents")));
        selectContinents.selectByIndex(r.nextInt(7));
        Select selectCommands = new Select(form.findElement(By.name("selenium_commands")));
        selectCommands.selectByIndex(r.nextInt(5));
        form.findElement(By.name("submit")).click();
    }
    **/
}
