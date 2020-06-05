package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Setting {
        WebDriver driver;
        String emailURL = "https://profil.wp.pl/login.html?zaloguj=poczta";
        String email = "Samek.Marek@wp.pl";
        String password = "Sammar1!";
        String keyWord = "zyskaj";
    }

    @BeforeTest
    public void SetDriver() {
        String driverPath = "C:\Users\samekmar\IdeaProjects\SeleniumMobileProjekt\src\main\\resources\geckodriver.exe";
        // Zdefiniowanie ścieżki dla zewnętrznego drivera przeglądarki FireFox
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        // ustawienie czasu oczekiwania na elementy
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // maksymalizacja okna
        driver.manage().window().maximize();
        // wejście na stronę testerzy.pl
        driver.get(emailURL);
    }

    @AfterTest
    public void ClosePage() {
        if (driver != null) driver.quit();
    }

}
