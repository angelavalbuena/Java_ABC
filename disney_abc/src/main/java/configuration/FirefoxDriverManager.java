package configuration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {


    private GeckoDriverService  geckoDriverService;

    @Override
    protected void startService() {
        if(null == geckoDriverService){
            try{
                geckoDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("src/test/resources/drivers/geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
                geckoDriverService.start();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if(null != geckoDriverService && geckoDriverService.isRunning())
            geckoDriverService.stop();
    }

    @Override
    protected void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");

        driver = new FirefoxDriver(geckoDriverService, options);
    }
}
