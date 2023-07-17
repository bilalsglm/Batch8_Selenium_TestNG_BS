package com.eurotech.tests.day_14_Wait;

import java.util.Scanner;

public class _01_waitIntro {

    public static void main(String[] args) throws InterruptedException {

        //CountDown --> Geri sayim icin ilk olarak Thread Sleep kullandik

        Scanner sc =new Scanner(System.in);
        System.out.println("Please enter a number of minutes");
        int minutes=sc.nextInt();
        sc.close();//Burada kapatma islemi uyguladik

        for (int i = minutes; i >0; i--) {
            for (int j = 59; j >0 ; j--) {
                System.out.println("\r"+(i-1)+"minutes and "+j+" Seconds lefet");
                Thread.sleep(1000);//Her dongude bir saniye azaltmak icin
            }
        }

        System.out.println("\n\n");

        System.err.println("\t\t\t* * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.err.println("\t\t\t*                                                 *");
        System.err.println("\t\t\t*       Times is Up, Please take your seats!      *");
        System.err.println("\t\t\t*                                                 *");
        System.err.println("\t\t\t* * * * * * * * * * * * * * * * * * * * * * * * * *");

    }
}
