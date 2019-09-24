package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.SignIn;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import org.openqa.selenium.Keys;

public class Suite extends BaseTest {


    @Test(dataProvider = "firstDataProvide")

    public void firsTest(String user, String password) throws InterruptedException{
        System.out.println("firstTest");

        SignIn signPage = new SignIn(driver); // Inicializa el driver

        signPage.typeUser(user);
        signPage.typePassword(password);

        ProductsPage products = signPage.clickSubmit();
        assertThat(products.containsFeatures().contains("FEATURES"));
        assertThat(products.containsTvseries().contains("TV SERIES"));
        assertThat(products.containsPrint().contains("PRINT"));
        assertThat(products.containsSearch().contains("SEARCH"));

        products.selectElement(1);
        products.typeTvSeries("Castle");
        waitElement(1);
        products.sendKey(Keys.RETURN);
        products.clickSearchBtn();

        // products.clickList();
        waitElement(1);


        products.selectElement(0);
        products.typeFeature("Frozen");
        products.clickSearchBtn();
        waitElement(1);
        products.getList();
        alert();



    }




}
