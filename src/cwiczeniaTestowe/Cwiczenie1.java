package cwiczeniaTestowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;


public class Cwiczenie1 {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "C:/Users/samekmar/Downloads/chromedriver.exe");
        // utworzenie obiektu i inicjalizacja przeglądarką Chrome
        //driver = new ChromeDriver();
        String driverPath = "C:\\Users\\samekmar\\IdeaProjects\\SeleniumMobileProjekt\\src\\main\\resources\\geckodriver.exe";
        // Zdefiniowanie ścieżki dla zewnętrznego drivera przeglądarki FireFox
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // wejście na stronę testerzy.pl
        driver.get("https://testerzy.pl/");
    }
}
