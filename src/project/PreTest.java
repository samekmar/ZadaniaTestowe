package project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PreTest {

    WebDriver driver;
    String emailURL = "https://profil.wp.pl/login.html?zaloguj=poczta";
    String email = "Samek.Marek@wp.pl";
    String password = "Sammar1!";
    String keyWord = "zyskaj";


    @BeforeTest
    public void SetDriver() {
        String driverPath = "C:\\Users\\samekmar\\IdeaProjects\\SeleniumMobileProjekt\\src\\main\\resources\\geckodriver.exe";
        // Zdefiniowanie ścieżki dla zewnętrznego drivera przeglądarki FireFox
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        // ustawienie czasu oczekiwania na elementy
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // maksymalizacja okna
        driver.manage().window().maximize();
        // wejście na stronę poczty WP
        driver.get(emailURL);

    }

    @AfterTest
    public void ClosePage() {
        if (driver != null) driver.quit();
    }

    @Test
    public void mailOpenPage(){
        WebElement userField=driver.findElement(By.id("login"));
        WebElement passwordField=driver.findElement(By.id("password"));
        WebElement loginButton=driver.findElement(By.id("btnSubmit"));
        userField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Test
    public void findMail() {
        driver.navigate().refresh();
        WebElement searchKey = driver.findElement(By.id("searchInput"));
        searchKey.sendKeys(keyWord);
        searchKey.sendKeys(Keys.RETURN);
        WebElement setAll = driver.findElement(By.xpath("/html/body/div[2]/nh-app-view/div/div/div/div[1]/div/div/div/div/div[2]/div[1]/div[1]/nh-checkbox/div"));

    }
}
