package cw.tests.Day14;

import org.testng.annotations.Test;

public class C04_Enabled {



    // enabled = false olursa testimiz pasif hale gelir ve calismaz
    // default degeri true dur


    @Test
    public void enabledTest(){

    }

    @Test(enabled = false)
    public void disabledTest(){

    }
}
