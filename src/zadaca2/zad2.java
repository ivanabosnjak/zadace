package zadaca2;
/*2. Napisati program u Javi koji unosi ime i prezime i datum rođenja za 5 osoba (kreirati razred
        Osoba) spremajući ih u niz koristeći razred List. Nakon unosa, ispisati podatke sortirane
        abecednim redom.*/

//Ivana Bošnjak, 2200/RR

import java.util.*;

class Osoba {
    public String ime;
    public String prezime;
    public String datumRodjenja;

    public Osoba(String ime, String prezime, String datumRodjenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
    }

    public String toString() {
        return ime + " " + prezime + " - " +datumRodjenja;
    }
}

public class zad2 {
    public static void main(String[] args) {

        List<Osoba> listaOsoba = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Unesite podatke za osobu " + (i + 1) + ":");
            System.out.print("Ime: ");
            String ime = sc.nextLine();
            System.out.print("Prezime: ");
            String prezime = sc.nextLine();
            System.out.print("Datum rođenja: ");
            String datumRodjenja = sc.nextLine();

            Osoba o = new Osoba(ime, prezime, datumRodjenja);
            listaOsoba.add(o);
        }

        Collections.sort( listaOsoba, Comparator.comparing((Osoba o)-> o.prezime)
                .thenComparing((Osoba o) -> o.ime));

        System.out.println("\nSortirane informacije o osobama:");
        for (Osoba o : listaOsoba) {
            System.out.println(o);
        }
    }
}


