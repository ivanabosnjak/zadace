package zadaca2;

/*4. Napisati program u Javi koji unosi ime i prezime te ocjenu s ispita za 15 studenata. Potom
kreirati niz polozili u koji se spremaju studenti koji su položili ispit. Program ispisuje
podatke o studentima koji su položili ispit sortirane po abecedi. Za navedene nizove
koristiti razred ArrayList.*/

//Ivana Bošnjak, 2200/RR

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class zad4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> imenaPrezimena = new ArrayList<>();
        ArrayList<Integer> ocjene = new ArrayList<>();
        ArrayList<String> polozili = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            System.out.println("Student " +(i + 1)+" :" );
            System.out.println("Ime i prezime:");
            String imePrezime = sc.nextLine();
            imenaPrezimena.add(imePrezime);

            System.out.println("Ocjena:");
            int ocjena = sc.nextInt();
            ocjene.add(ocjena);
            sc.nextLine();

            if (ocjena >= 2) {
                polozili.add(imePrezime);
            }
        }

        Collections.sort(polozili);

        System.out.println("\nStudenti koji su položili:");

        for (String student : polozili) {
            System.out.println(student);
        }
    }
}

