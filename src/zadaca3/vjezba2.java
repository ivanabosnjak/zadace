package zadaca3;

 /*2. Napisati program u Javi koji unosi ime i prezime osobe i datum njenog rođenja, provjerava valjanost datuma te ispisuje
         pozdravnu poruku za tu osobu i informaciju koiko je dana preostalo do njenog sljdećeg
         rođendana*/
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;


public class vjezba2{
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesi ime");
        String ime = sc.nextLine();

        System.out.println("Unesi datum rodjenja");
        String datum = sc.nextLine();

        LocalDate rodjendan = LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd MM yyyy") );
        LocalDate danas = LocalDate.now();

        if(rodjendan.isBefore(danas) || rodjendan.isEqual(danas)){
            rodjendan = rodjendan.plusYears(1);
        }


        long danaDoRodjendana = ChronoUnit.DAYS.between(danas, rodjendan);
        System.out.println(danaDoRodjendana);

    }

}
