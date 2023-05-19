package cw.tests.Day16;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C01_Parameters {


    @Test
    @Parameters("isim")
    public void paramerizedTest(String isim){

        System.out.println("Hello" + isim);


    }
    //Parametrelerin sırasına göre xml dosyasından parametreler okunur.
    //Parametreleri strin dışında veri tipleriyle alabiliriz (eğerki çevrilebiliyorsa).
    @Test
    @Parameters({"isim", "soyisim", "yas"})
    public void twoParameterTest(String name, String surname, int age){

        System.out.println("Hello " + name + surname);
        System.out.println(age);
    }
}
