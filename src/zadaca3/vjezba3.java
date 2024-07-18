package zadaca3;
/**program unosi ime prezime
 klasa student s poljima ime prezime ,studij i god studija.

 dozvoliti korisniku unos imena i prezimena i provjeriti jesu li unosi valjani, jeli pocetno slovo veliko,
 korisnik unosi podatke sve dok 2 puta zaredom ne unese ime i prezime. ispisati*/
import java.util.Scanner;
class Student{
    public String ime;
    public String prezime;
    public String studij;
    public int godStudija;
}
public class vjezba3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        String prosloIme = "";
        String prosloPrezime = "";
        int brojZaredomIstih = 0;
        do {

            System.out.println("Unesi ime");
            s.ime = sc.nextLine();

            System.out.println("Unesi prezime");
            s.prezime = sc.nextLine();

            if(Character.isUpperCase(s.ime.charAt(0)) && Character.isUpperCase(s.prezime.charAt(0))) {
                System.out.println("unos je valjan");
            }else{
                System.out.println("unos nije valjan");
            }
            if (s.ime.equals(prosloIme) && s.prezime.equals(prosloPrezime)) {
                brojZaredomIstih++;

                    System.out.println("Unesili ste isto ime i prezime dva puta zaredom. Kraj programa.");
                    break;

            }else{
                brojZaredomIstih = 0;
            }
            prosloIme = s.ime;
            prosloPrezime= s.prezime;
        }while(true);
    }
}
