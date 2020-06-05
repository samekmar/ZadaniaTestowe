package cwiczeniaTestowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Cwiczenie2 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        String driverPath = "C:\\Users\\samekmar\\IdeaProjects\\SeleniumMobileProjekt\\src\\main\\resources\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void nawigacja(){
        driver.get("http://newtours.demoaut.com");
        String url1 = driver.getCurrentUrl();
        String title1 = driver.getTitle();
        driver.get("http://newtours.demoaut.com/mercurycruise.php");
        String url2 = driver.getCurrentUrl();
        String title2 = driver.getTitle();
        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(), title1 ,"Nie poprawny tytul strony");
        Assert.assertEquals(driver.getCurrentUrl(), url1 ,"Nie poprawny adres strony");
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(), title2 ,"Nie poprawny tytul strony");
        Assert.assertEquals(driver.getCurrentUrl(),url2 ,"Nie poprawny adres strony");
        driver.navigate().refresh();
        Assert.assertEquals(driver.getTitle(), title2, "Nie poprawny tytul strony");
        Assert.assertEquals(driver.getCurrentUrl(),url2 ,"Nie poprawny adres strony");
    }
}
