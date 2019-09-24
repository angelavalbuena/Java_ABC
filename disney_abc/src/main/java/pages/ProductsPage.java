package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    By features = By.cssSelector("#nav1 > ul > li:nth-child(1) > a");
    By tvseries = By.cssSelector("#nav1 > ul > li:nth-child(2) > a");
    By print    = By.cssSelector("#nav1 > ul > li:nth-child(3) > a");
    By search   = By.cssSelector("#nav1 > ul > li:nth-child(4) > a");


    By searchtype = By.id("select2-chosen-1");
    By searchtlist = By.cssSelector(".select2-result-label");
    By searchsfeatures = By.id("non-episode_name");
    By searchstvseriesfield = By.id("select2-chosen-8");
    By searchstvseries =By.cssSelector("#s2id_autogen8_search"); //By.cssSelector("#select2-results-8 > li");
    By season = By.id("select2-chosen-7");
    By buttonsearch = By.cssSelector("#search-form > div.row > div:nth-child(4) > input");

    By listsearch = By.cssSelector("table.table.table-striped.sortable > tbody > tr:nth-child(1) > td:nth-child(1) > a");
    By getallelem = By.cssSelector("table.table.table-striped.sortable > tbody > tr> td:nth-child(1) > a");

    //
    public String containsFeatures() throws InterruptedException{
        String features2 = driver.findElement(features).getText();
        return  features2;
    }


    public String containsTvseries() throws InterruptedException{
        String tvseries2 = driver.findElement(tvseries).getText();
        return  tvseries2;
    }

    public String containsPrint() throws InterruptedException{
        String print2 = driver.findElement(print).getText();
        return  print2;
    }

    public String containsSearch() throws InterruptedException{
        String search2 = driver.findElement(search).getText();
        return  search2;
    }


   //Search type field
    public ProductsPage selectElement(int selection) throws InterruptedException {

        clickElement(searchtype);
        List<WebElement> flightList = driver.findElements(searchtlist);
        System.out.println("List "+ flightList);
        flightList.get(selection).click();
        return  this;
    }


    // Features
    public ProductsPage typeFeature(String value){
        sendText(searchsfeatures, value);
        return  this;
    }


    // TV Series

    public ProductsPage typeTvSeries(String value){
        clickElement(searchstvseriesfield);
        sendText(searchstvseries, value);
        return  this;
    }

    public ProductsPage sendKey(Keys key){
        sendKeys(searchstvseries,key);
        return this;
    }


    // Search Button
    public ProductsPage clickSearchBtn(){
        clickElement(buttonsearch);
        return  this;
    }


    // List

    public ProductsPage clickList(){
        clickElement(listsearch);
        return this;
    }


    public ProductsPage getList(){
        List<WebElement> resultList = driver.findElements(getallelem);
        System.out.println("Result: "+ resultList);
        resultList.get(1).click();
        return this;
    }


    public List<String> getResult(){
        List<WebElement> resultList = driver.findElements(getallelem);
        System.out.println("Result: "+ resultList);
        //resultList.get(1).click();

        List<String> textResults = new ArrayList<String>();
        System.out.println("Text result: "+ textResults);
        return textResults;
    }




   /* public List<String> getResults(){
        List<WebElement> resultsWE = driver.findElements(results);
        WebElement resultsList = waitUntilElementIsPresentAndVisible(results, 10);
        List<String> textResults = new ArrayList<String>();

        for(WebElement element: resultsList.findElements(By.xpath(".//*[self::h2 or self::h5]"))){
            textResults.add(element.getText());
        }

        return textResults;
    }*/

}
