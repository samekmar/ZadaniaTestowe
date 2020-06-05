package projekt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Ustawienia {
    WebDriver driver;
    String emailURL = "https://profil.wp.pl/login.html?zaloguj=poczta";
    String email = "Samek.Marek@wp.pl";
    String password = "Sammar1!";
    String keyWord = "zyskaj";
}

    @BeforeTest
    public void SetDriver() {
        String driverPath = "C:\\Users\\samekmar\\IdeaProjects\\SeleniumMobileProjekt\\src\\main\\resources\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void ClosePage() {
        if (driver != null) driver.quit();
    }