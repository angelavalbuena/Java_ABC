package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void sendText(By elem, String value) {
        waitUntilElementisPresentAndVisible(elem, 10).sendKeys(value);
        // driver.findElement(elem).sendKeys(value);
    }

    public void clickElement(By elem){
        //driver.findElement(elem).click();
        waitUntilElementisPresentAndVisible(elem,10).click();

    }

    public void sendKeys(By elem, Keys key){
        waitUntilElementisPresentAndVisible(elem,10).sendKeys(key);
    }

    public WebElement waitUntilElementisPresentAndVisible (final By elemenLocator, int timeout){

        Wait wait = new FluentWait(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        WebElement elemt = (WebElement) wait.until(new Function<WebDriver, WebElement>(){

        @Override
        public WebElement apply(WebDriver webDriver){
          return webDriver.findElement(elemenLocator);

        }

        });
      return elemt;

     }






}













