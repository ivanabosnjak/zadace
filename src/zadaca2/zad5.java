package zadaca2;

/*5. Napisati program u Javi koji unosi 20 cijelih brojeva u niz koristeći razred List te ispisati
uneseni niz brojeva. Potom sve neparne brojeve na parnim mjestima zamijeniti najvećim
neparnim unesenim brojem te ispisati novo stanje niza.*/

//Ivana Bošnjak, 2200/RR

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class zad5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> brojevi = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            System.out.print("Unesite " + (i + 1) + ". broj: ");
            int broj = sc.nextInt();
            brojevi.add(broj);
        }

        System.out.println("Uneseni niz: " + brojevi);

        zamijeniNeparne(brojevi);

        System.out.println("Nakon zamjene: " + brojevi);
    }

    public static void zamijeniNeparne(List<Integer> lista) {

        List<Integer> neparniBrojevi = new LinkedList<>();
        for (int broj : lista) {
            if (broj % 2 != 0) {
                neparniBrojevi.add(broj);
            }
        }

        if (neparniBrojevi.isEmpty()) {
            return;
        }

        int najveciNeparni = Collections.max(neparniBrojevi);

        for (int i = 0; i < lista.size(); i += 2) {
            if (lista.get(i) % 2 != 0) {
                lista.set(i, najveciNeparni);
            }
        }
    }
}

