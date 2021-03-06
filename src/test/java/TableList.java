import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableList {

    private String structure;
    private String country;
    private String city;
    private int height;
    private int build;
    private int rank;

    public TableList() {
    }

    public TableList(WebElement tr) {

        this.structure = tr.findElement(By.cssSelector("th")).getText();
        List<WebElement> tds = tr.findElements(By.cssSelector("td"));
        this.country = tds.get(0).getText();
        this.city = tds.get(1).getText();
        this.height = Integer.valueOf(tds.get(2).getText().substring(0,3));
        this.build = Integer.parseInt(tds.get(3).getText());
        this.rank = Integer.parseInt(tds.get(4).getText());
    }
    public void printTable(){
        System.out.println("Structure "+structure+" in "+country+" in "+city+" date: "+build);
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBuild() {
        return build;
    }

    public void setBuild(int build) {
        this.build = build;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
