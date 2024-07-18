package zadaca2;

/*1. Napisati program u Javi koji od korisnika traži unos 10 imena i pohranjuje ih u niz razreda
String. Nakon toga kreira dva nova niza tako da u prvi pohranjuje sva imena kojima je
početno slovo jednako završnom, a u drugi ostala imena iz unesenog niza. Konačno,
program treba ispisati vrijednosti svih nizova.*/

//Ivana Bošnjak, 2200/RR

import java.util.Scanner;

public class zad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] imena = new String[10];

        System.out.println("Unesite 10 imena:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Ime " + (i + 1) + ": ");
            imena[i] = sc.nextLine();
        }

        String[] istoSlovo = new String[10];
        String[] ostalaImena = new String[10];

        for (int i = 0; i < 10; i++) {
            String ime = imena[i];
            char prvoSlovo = ime.charAt(0);
            char zadnjeSlovo = ime.charAt(ime.length() - 1);

            if (prvoSlovo == zadnjeSlovo) {
                istoSlovo[i] = ime;
            } else {
                ostalaImena[i] = ime;
            }
        }

        System.out.println("Imena koja počinju i završavaju istim slovom:");
        for (String ime : istoSlovo) {
            if (ime != null) {
                System.out.println(ime);
            }
        }

        System.out.println("\nOstala imena:");
        for (String ime : ostalaImena) {
            if (ime != null) {
                System.out.println(ime);
            }
        }
    }
}
