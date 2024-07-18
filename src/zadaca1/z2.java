package zadaca1;/* 2. Napisati program u Javi koji unosi ime i prezime osobe i datum njenog rođenja te ispisuje
pozdravnu poruku za tu osobu i informaciju koiko je dana preostalo do njenog sljdećeg
rođendana*/

//Ivana Bošnjak, 2200/RR

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class z2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite ime:");
        String ime = sc.nextLine();

        System.out.println("Unesite prezime:");
        String prezime = sc.nextLine();

        System.out.println("Unesite datum rođenja (dd MM yyyy):");
        String datum = sc.nextLine();

        LocalDate rodjendan = LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd MM yyyy"));

        LocalDate danasnjiDan = LocalDate.now();

        if (rodjendan.isBefore(danasnjiDan) || rodjendan.isEqual(danasnjiDan)) {
            rodjendan = rodjendan.withYear(danasnjiDan.getYear() + 1);
        }

        long danaDoRodjendana = ChronoUnit.DAYS.between(danasnjiDan, rodjendan);

        System.out.println("Pozdrav, " + ime + " " + prezime);
        System.out.println("Do rođendana je ostalo: " + danaDoRodjendana + " dana");

    }
}

