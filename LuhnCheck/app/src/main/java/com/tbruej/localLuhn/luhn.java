package com.tbruej.localLuhn;

public class luhn {

    public static boolean checkLuhn(String cardNo){


        int nDigit = cardNo.length();
        int nSum = 0;
        boolean isSecond = false;

        for(int i = nDigit - 1 ; i >= 0; i--){

            int d = cardNo.charAt(i) - '0';

            if (isSecond == true)
                d = d * 2;

            nSum += d  / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }

        return (nSum % 10 == 0);

    }


    public static void main(String[] args) {

        String cardNo = "18009054331492";
        if (checkLuhn(cardNo))
            System.out.println("VALID!");
        else
            System.out.println("NOT VALID!");
    }
}
