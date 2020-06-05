package cwiczeniaTestowe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Cwiczenie3 {
    public WebDriver driver ;

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
    public void autoStrony() {
        driver.get("http://51.83.43.62/practiseform/");

        //A
        WebElement firstName = driver.findElement(By.id("field1"));
        WebElement firstNameXpath = driver.findElement(By.xpath("//input[@placeholder='Type first name...']"));
        firstNameXpath.clear();
        firstNameXpath.sendKeys("Marek");

        //B
        WebElement chbOption2 = driver.findElement(By.id("field4-2"));
        WebElement chbOption1 = driver.findElement(By.id("field4-1"));
        if (chbOption2.isSelected()) {
            chbOption2.click();
            if (!chbOption1.isSelected())
                chbOption1.click();
        }

        //C
        WebElement inpAdd = driver.findElement(By.id("field7"));
        String placeholder2 = inpAdd.getText();
        System.out.println(" check " + placeholder2);
        if (placeholder2.contains("Type text")) {
            inpAdd.clear();
            inpAdd.sendKeys("Szkolenie Java-Selenium");
        }

        //D
        WebElement btnSubmit = driver.findElement(By.name("submit"));
        if (btnSubmit.isEnabled()) {
            btnSubmit.click();
        }

        //E
        List<WebElement> lista = driver.findElements(By.className("error"));
        System.out.println("Ilość błędów formularza: " + lista.size());
    }
}
