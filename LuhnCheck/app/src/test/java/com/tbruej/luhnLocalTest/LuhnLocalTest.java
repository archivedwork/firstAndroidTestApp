package com.tbruej.luhnLocalTest;

import com.tbruej.localLuhn.luhn;
import org.junit.*;

import static com.tbruej.localLuhn.luhn.checkLuhn;
import static org.junit.Assert.*;


public class LuhnLocalTest {



    @Test
    public void luhnTestSuccess(){
        //assertEquals(checkLuhn("18009054331492"), true);
        assertEquals(checkLuhn("18009054331492"), true);
    }



    //@Test(expected = AssertionError.class)
    @Test
    public void luhnTest(){
        //assertEquals(checkLuhn("18009054331492"), true);
        assertEquals(checkLuhn("180090543314"), false);
    }


    @Test(expected = AssertionError.class)
    public void luhnFailTest(){
        //assertEquals(checkLuhn("18009054331492"), true);
        assertEquals(checkLuhn("180090543314"), true);
    }


}
