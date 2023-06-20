package com.eurotech.tests.day_01_automation_intro;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class _3_javaFakerDemo {
    public static void main(String[] args) {

        //mock data üretmek için kullanılır....(sahte data)
        Faker faker=new Faker();

        //sahte isim üretelim
        String fullname= faker.name().fullName();
        System.out.println("fullname = " + fullname);

        //sahte bir şehir üretelim
        String city = faker.address().city();
        System.out.println("city = " + city);

        //kredi kartı no
        String creditCard = faker.finance().creditCard();
        System.out.println("creditCard = " + creditCard);

        //american express kredi cart no
        String creditCard1 = faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS);
        System.out.println("creditCard1 = " + creditCard1);

        //şifre üretelim
        String password = faker.internet().password();
        System.out.println("password = " + password);

        //rakam harf özel işaret vb içeren şifre üretelim
        String password1 = faker.internet().password(8, 16, true, true, true);
        System.out.println("password1 = " + password1);

        //belli bir değerle başlayan şifre üretelim "Ab123*"
       String password3= "ABC123*" +faker.internet().password();
        System.out.println("password3 = " + password3);
    }
}
