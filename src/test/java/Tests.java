import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

        List<TableList> testTableLists = new ArrayList<TableList>();
        for (int i = 0;i < 4;i++){
            testTableLists.add(new TableList());
        }
        testTableLists.get(0).setStructure("Burj Khalifa");
        testTableLists.get(0).setCountry("UAE");
        testTableLists.get(0).setCity("Dubai");
        testTableLists.get(0).setHeight(829);
        testTableLists.get(0).setBuild(2010);
        testTableLists.get(0).setRank(1);

        testTableLists.get(1).setStructure("Clock Tower Hotel");
        testTableLists.get(1).setCountry("Saudi Arabia");
        testTableLists.get(1).setCity("Mecca");
        testTableLists.get(1).setHeight(601);
        testTableLists.get(1).setBuild(2012);
        testTableLists.get(1).setRank(2);

        testTableLists.get(2).setStructure("Taipei 101");
        testTableLists.get(2).setCountry("Taiwan");
        testTableLists.get(2).setCity("Taipei");
        testTableLists.get(2).setHeight(509);
        testTableLists.get(2).setBuild(2004);
        testTableLists.get(2).setRank(3);

        testTableLists.get(3).setStructure("Financial Center");
        testTableLists.get(3).setCountry("China");
        testTableLists.get(3).setCity("Shanghai");
        testTableLists.get(3).setHeight(492);
        testTableLists.get(3).setBuild(2008);
        testTableLists.get(3).setRank(4);

        List<WebElement> trList = driver.findElements(By.cssSelector("table[summary='Sample Table'] tbody tr"));
        List<TableList> tableLists = new ArrayList<TableList>();
//        trList.forEach(tr->{tableLists.add(new TableList(tr));});
        for (WebElement tr:trList) {
            tableLists.add(new TableList(tr));
        }
//        tableLists.forEach(x->x.printTable());

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(tableLists.get(i).getStructure(),testTableLists.get(i).getStructure());
            Assert.assertEquals(tableLists.get(i).getCountry(),testTableLists.get(i).getCountry());
            Assert.assertEquals(tableLists.get(i).getCity(),testTableLists.get(i).getCity());
            Assert.assertEquals(tableLists.get(i).getBuild(),testTableLists.get(i).getBuild());
            Assert.assertEquals(tableLists.get(i).getHeight(),testTableLists.get(i).getHeight());
            Assert.assertEquals(tableLists.get(i).getRank(),testTableLists.get(i).getRank());
        }



        int rand = r.nextInt(400)+400;
        for (TableList el:tableLists) {
            if (el.getBuild() >= rand)
                el.printTable();
        }

    }
}
