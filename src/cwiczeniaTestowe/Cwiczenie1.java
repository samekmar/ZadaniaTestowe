package cwiczeniaTestowe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import java.util.Scanner;

public class Cwiczenie1 {
    private WebDriver driver;
// komentarz
    @BeforeClass
    public void setUp() {
        // Zdefiniowanie ścieżki dla zewnętrznego drivera przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver", "C:/Users/samekmar/Downloads/chromedriver.exe");

        driver = new ChromeDriver(); // utworzenie obiektu i inicjalizacja przeglądarką Chrome
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ustawienie czasu oczekiwania na elementy
        driver.manage().window().maximize(); // maksymalizacja okna

        driver.get("https://testerzy.pl/"); // wejście na stronę testerzy.pl
    }
}
