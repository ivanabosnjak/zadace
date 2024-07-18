package zadaca1;/* 3. Napisati program u Javi koji unosi rečenicu i pronalazi najveći podstring unesene rečenice
koji je palindrom, zanemarujući sve znakove koji nisu slova te zanemarujući razliku između
velikih i malih slova*/

//Ivana Bošnjak, 2200/RR

import java.util.Scanner;

public class z3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String unos = sc.nextLine();

        String[] rijeci = podStringovi(unos);
        int maxDuljina = 0, max_i = -1;
        for (int i = 0; i < rijeci.length; i++) {
            if (jeLiPalindrom(rijeci[i]) && rijeci[i].length() > maxDuljina) {
                maxDuljina = rijeci[i].length();
                max_i = i;
            }
        }
        if (max_i != -1) {
            System.out.println("Rijec: " + rijeci[max_i] + " je najduzi palindrom u unesenom stringu");
        } else {
            System.out.println("Nema palindroma u unesenom stringu.");
        }
    }

    public static String[] podStringovi(String unos) {
        String[] podStringovi = unos.split("\\s+");
        return podStringovi;
    }

    public static boolean jeLiPalindrom(String unos) {
        String obrnuti = "";
        unos = unos.replaceAll("[^a-zA-Z]","").toLowerCase();
        for (int i = 0; i < unos.length(); i++) {
            obrnuti = unos.charAt(i) + obrnuti;
        }

        return unos.equals(obrnuti);
    }
}