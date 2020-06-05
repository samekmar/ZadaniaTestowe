package cwiczeniaTestowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;


public class Cwiczenie1 {
    private WebDriver driver;
// komentarz
    //komentarz 2
    @BeforeClass
    public void setUp() {
        // Zdefiniowanie ścieżki dla zewnętrznego drivera przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver", "C:/Users/samekmar/Downloads/chromedriver.exe");
        // utworzenie obiektu i inicjalizacja przeglądarką Chrome
        driver = new ChromeDriver();
        // ustawienie czasu oczekiwania na elementy
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // maksymalizacja okna
        driver.manage().window().maximize();
        // wejście na stronę testerzy.pl
        driver.get("https://testerzy.pl/");
    }
}
