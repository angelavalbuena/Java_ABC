package base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import configuration.DriverManager;
import configuration.DriverManagerFactory;
import configuration.DriverType;

public class BaseTest {

    DriverManager driverManager;

    public WebDriver driver;


    @BeforeTest
    public void beforeAll(){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @AfterTest
    public void afterAll() {
        driverManager.stop();
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){

        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://disney-integration-www.rtraction.com/");

    }

    @AfterMethod(alwaysRun = true)
    public void closedBrowser(){

       // driver.close();
       // driver.quit();

    }

    @DataProvider(name ="firstDataProvide")

    public static Object[][] getFirstProjectDP(){
        Object[][] objToReturn = new Object[1][2]; // Filas-Columnas
        objToReturn[0][0]="ercet.x.casanova.-nd@disney.com";
        objToReturn[0][1]="rtract1on";
        // objToReturn[1][0]="alison.pena@globant.com";
        // objToReturn[1][1]="Rtract1on";

        return objToReturn;
    }

    public void waitElement(int n) throws InterruptedException {

        Thread.sleep(n*1000);
    }


    public void alert(){

        Alert simpleAlert = driver.switchTo().alert();
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is " + alertText);
        simpleAlert.accept();


    }


}
