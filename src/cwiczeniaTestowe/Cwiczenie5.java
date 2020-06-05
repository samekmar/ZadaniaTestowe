package cwiczeniaTestowe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Cwiczenie5 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        String driverPath = "C:\\Users\\samekmar\\IdeaProjects\\SeleniumMobileProjekt\\src\\main\\resources\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // wejście na stronę testerzy.pl
        driver.get("https://testerzy.pl/");
    }

    @AfterClass
    public void closeDown() {
        // wyłączenie drivera i zamknięcie przeglądarki
        driver.quit();
    }

    @Test
    public void test1() {
        Assert.assertEquals(driver.getTitle(), "testerzy.pl - Lepsza jakość testowania");
        // sprawdzenie czy tytuł strony pobrany z driver.getTitle()
        // jest tytułem jakiego się spodziewamy "testerzy.pl - Lepsza jakość testowania"
        // jeżeli tak - PASS
        // jeżeli nie - FAIL
    }

    @Test
    public void test2() {
        // kliknięcie w element NEWS o adresie XPATH
        driver.findElement(By.xpath("//html/body/nav/div/ul[1]/li[3]/a")).click();

        Assert.assertEquals(driver.getTitle(), "News - testerzy.pl - Lepsza jakość testowania");
        // sprawdzenie czy tytuł strony pobrany z driver.getTitle()
        // jest tytułem jakiego się spodziewamy "News - testerzy.pl - Lepsza jakość testowania"
        // jeżeli tak - PASS
        // jeżeli nie - FAIL
    }

    @Test
    public void test3() {
        // kliknięcie w element NEWS o adresie XPATH
        driver.findElement(By.xpath("//html/body/header/nav/div/ul[2]/li[5]/a")).click();

        // pobranie wszystkich opcji selecta z tematem wiadomości
        List<WebElement> selectOptions = driver.findElements(By.xpath("//html/body/section[1]/div/div[3]/div[2]/form/div[1]/select/child::*"));

        // wybranie tematu losowo
        selectOptions.get(new Random().nextInt(((selectOptions.size() - 1) - 1) + 1) + 1).click();

        // Stałe klikanie w opcje nr 5 - option[5]
//        WebElement subject = driver.findElement(By.xpath("//html/body/section[1]/div/div[3]/div[2]/form/div[1]/select/option[5]"));
//        subject.click();

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Piotr Krzosa");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("piotr.krzosa@gmail.com");

        WebElement phone = driver.findElement(By.id("phoneNumber"));
        phone.sendKeys("555666777");

        WebElement message = driver.findElement(By.id("message"));
        message.sendKeys("oiuytrd bhugvyft jihgyft ojihuygftd jihugyft");

        WebElement accept = driver.findElement(By.className("custom-control-label"));

        // Scroll w dół - fix do zmiany
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        accept.click();

        // Zakomentowane aby nie wysyłać wiadomości na serwer
        //message.submit();

        // TODO dodać sprawdzenie czy wiadomość została wysłana
    }

    @Test
    public void test4() {
        driver.findElement(By.xpath("//html/body/nav/div/ul[1]/li[1]/a")).click();
        // klikam w element o podanym adresie XPATH - spodziewany element to SZKOLENIA

        Set<String> windows = driver.getWindowHandles();

        String currentWindow = driver.getWindowHandle();
        for (String nextWindow : windows) {
            if (driver.switchTo().window(nextWindow).getTitle().equalsIgnoreCase("Lepsza jakość testowania - szkolenia.testerzy.pl")) {
                break;
            } else {
                driver.switchTo().window(currentWindow);
            }
        }

        Assert.assertEquals(driver.getTitle(), "Lepsza jakość testowania - szkolenia.testerzy.pl");
        // sprawdzenie czy tytuł strony pobrany z driver.getTitle()
        // jest tytułem jakiego się spodziewamy "News - testerzy.pl - Lepsza jakość testowania"
        // jeżeli tak - PASS
        // jeżeli nie - FAIL
    }
}
