package cwiczeniaTestowe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Cwiczenie4 {

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
        public void autoStrony() throws InterruptedException {
            driver.get("http://51.83.43.62/practiseform/");

            WebElement lstCity = driver.findElement(By.name("selcapital"));
            Select listaWyboru = new Select(lstCity);
            System.out.println(listaWyboru.getFirstSelectedOption().getText());
            int lista1Size = listaWyboru.getOptions().size();
            System.out.println("Ilosc elementow listy:" + lista1Size);
            for(WebElement option : listaWyboru.getOptions() ){
                String visibleText = option.getText();
                String optionValue = option.getAttribute("value");
                System.out.println("VisibleText: "+ visibleText);
                System.out.println("Option value: "+optionValue);
            }
            Thread.sleep(6000);

        }
}
