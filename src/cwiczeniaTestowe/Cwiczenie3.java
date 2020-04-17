package cwiczeniaTestowe;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Cwiczenie3 {

    @Test
    public void metodaTestowa1(){
        Assert.assertEquals("Adam", "Adam","Brak zgodnosci imion");
        System.out.println("Pierwsza metoda testowa @Test");
    }
    @Test
    public void metodaTestowa2(){
        Assert.assertEquals("Marek", "Adam","Brak zgodnosci imion");
        System.out.println("Druga metoda testowa @Test");

    }

    @Test
    public void metodaTestowa3(){
        int a=200;
        int b=100;
        Assert.assertTrue(a>b,"Liczba "+a+" nie jest wieksza od liczby  " + b);
        System.out.println("Trzecia metoda testowa @Test");
    }
}
