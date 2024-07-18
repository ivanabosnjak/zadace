package zadaca2;
/* potrebno je kreirati klasu boksac. sadzi ime i kategoriju. kat. moze imati vrijednosti laka(do 60 kg) srednja(60-80) i teza(80+kg).
 kreirati metode
kreirati niz boksaca 15. koristeci java klasu arrays. potebno je da program vrati koliko je boksaca u kojoj kategoriji*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

    class Boksac {
        public String ime;
        public String kategorija;

        public int tezina;

        public Boksac(String ime, int tezina) {
            this.ime = ime;
            this.tezina = tezina;
            odredjivanjeKategorije(tezina, this);
        }


        public static void odredjivanjeKategorije(int tezina, Boksac b) {
            if (tezina < 60) {
                b.kategorija = "laka";
            } else if (tezina > 60 && tezina < 80) {
                b.kategorija = "srednja";
            } else {
                b.kategorija = "teska";
            }

        }
    }

        public class dodatni {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int laka = 0;
                int srednja = 0;
                int teska = 0;

                List<Boksac> listaBoksaca = new ArrayList<>();

                for (int i = 0; i < 3; i++) {
                    System.out.println("Unesite podatke za " + (i + 1) + ". boksaca:");
                    System.out.println("Ime:");
                    String ime = sc.nextLine();
                    System.out.println("Tezina:");
                    int tezina = sc.nextInt();
                    sc.nextLine();

                    Boksac b = new Boksac(ime, tezina);
                    listaBoksaca.add(b);

                    switch (b.kategorija) {
                        case "laka":
                            laka++;
                            break;
                        case "srednja":
                            srednja++;
                            break;
                        case "teska":
                            teska++;
                            break;
                    }
                }

                System.out.println("Boksaca u lakoj kategoriji ima:" + laka);
                System.out.println("Boksaca u srednjoj kategoriji ima:" + srednja);
                System.out.println("Boksaca u teskoj kategoriji ima:" + teska);

            }

        }
