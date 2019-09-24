package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn extends  BasePage{

    By user = By.id("username");
    By password = By.id("password");
    By buttonsign = By.id("submit");

    public SignIn(WebDriver driver) {
        super(driver);
    }


    public SignIn typeUser(String value){
        sendText(user,value);
        return this;
    }

    public SignIn typePassword(String value){
        sendText(password,value);
        return this;
    }

    public ProductsPage clickSubmit(){
        clickElement(buttonsign);
        return new ProductsPage(driver);
    }

}
