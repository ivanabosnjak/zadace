package zadaca1;/* 5. Napisati program u Javi koji unosi decimalne brojeve sve dok se ne unese broj čiji je cijeli
dio barem 100 puta veći od njegovog decimalnog dijela. Nakon toga ispisuje se ona
znamenka koja se ponavlja najviše puta u cijelim dijelovima svih unesenih brojeva i to
onoliko puta koliko se puta ponovila.*/

//Ivana Bošnjak, 2200/RR

import java.util.Scanner;

public class z5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] niz = new double[50];
        int[] cijeliDijelovi = new int[50];
        double[] decimalniDijelovi = new double[50];
        int i = 0;

        do {
            niz[i] = sc.nextDouble();
            cijeliDijelovi[i] = (int) niz[i];
            decimalniDijelovi[i] = niz[i] - cijeliDijelovi[i];
            i++;
        } while ((decimalniDijelovi[i - 1] * 100) >= cijeliDijelovi[i - 1]);

        int[] brojPonavljanja = new int[10];
        nadjiBrojPonavljanja(cijeliDijelovi, brojPonavljanja);
    }

    public static void nadjiBrojPonavljanja(int[] brojevi, int[] brojPonavljanja) {
        for (int broj : brojevi) {

            while (broj != 0) {
                int znamenka = broj % 10;
                brojPonavljanja[znamenka]++;
                broj /= 10;
            }
        }

        int maxZnamenka = 0;
        int maxPonavljanja = 0;


        for (int i = 0; i < brojPonavljanja.length; i++) {
            if (brojPonavljanja[i] > maxPonavljanja) {
                maxPonavljanja = brojPonavljanja[i];
                maxZnamenka = i;
            }
        }

        System.out.println("Znamenka " + maxZnamenka + " se ponovila " + maxPonavljanja + " puta.");
    }
}

