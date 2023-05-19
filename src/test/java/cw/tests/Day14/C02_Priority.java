package cw.tests.Day14;

import org.testng.annotations.Test;

public class C02_Priority {


    // Bir priority belirlenmez ise alfabetik execution gerceklesir.
    // Priority si en dusuk degere sahip olan test ilk once calisir.
    // Priority nin default degeri 0 dir.
    // Priority negatif deger alabilir.
    // Ayni priority ye sahip testler alfabetik sirayla calisir.

    @Test(priority = -5)
    public void b(){
        System.out.println("B is running ....");
    }

    @Test
    public void a(){
        System.out.println("A is running ....");
    }

    @Test
    public void c(){
        System.out.println("C is running ....");
    }

}




