package zadaca1;/* 1. Napisati program u Javi koji unosi string i provjerava radi li se o ispravnoj e-mail adresi.
Ispravnom e-mail adresom smatra se onaj string koji sadrzi proizvoljno korisnicko ime
sastavljeno od slova engleskog alfabeta, znamenki te znakova točke (.) i donje crte (_)
nakon kojeg slijedi znak @ te iz toga domenu koja mora imati barem jednu točku u sredini
teksta. Nakon provjere dojavljuje se poruka o ispravnosti unesene e-mail adrese.*/

//Ivana Bošnjak, 2200/RR

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class z1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("unesi mail");
        String email = sc.nextLine();
        if (jeLiIspravna(email)) {
            System.out.println("E-mail adresa je ispravna.");
        } else {
            System.out.println("E-mail adresa nije ispravna.");
        }
    }

    public static boolean jeLiIspravna(String email) {
        String emailRegex = "^[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-zA-Z.]+$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(email);

        return m.matches();
    }
}

