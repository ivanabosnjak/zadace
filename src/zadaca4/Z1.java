package zadaca4;

/*1. Definirati apstraktni razred Racunalo, te razrede StolnoRacunalo i PrijenosnoRacunalo
koji nasljeđuju Racunalo. Klasa Racunalo sadrži podatkovne članove za zapis modela
računala, proizvođača i korištenog operacijskog sustava (tekstualni podaci),
StolnoRacunalo dodatno sadrži podatkovne članove za zapis dimenzija kučišta (niz od tri
realna broja: visina, širina i dubina), dok PrijenosnoRacunalo sadrži podatkovne članove
za zapis podataka o kapacitetu baterije (cijeli broj) i težini računala (realan broj).
Apstraktni razred Racunalo sadrži apstraktne metode dohvatiTipRacunala() (bez ulaznih
parametara koja vraća tekstualni podatak o vrsti računala, tj stolno računalo ili prijenosno
računalo) i izracunajPrenosivost() (bez ulaznih parametara koja vraća cjelobrojni
podataka o kategoriji prenosivosti uređaja na način da za prijenosna računala vraća
njihovu težinu zaokruženu na cijeli broj, a za stolna računala ju računa po formuli
5 + volumen kučišta / 30. Definirati razred Netbook koja nasljeđuje PrijenosnoRacunalo.
Metoda izracunajPrenosivost() u ovom razredu uvijek vraća 1, a metoda
dohvatiTipRacunala() vraća netbook prijenosno računalo koristeći metodu nadređenog
razreda. Dodatno je potrebno onemogući daljnje nasljeđivanje razreda Netbook. Napisati
konstruktore za sve razrede, pri čemu konstruktori izvedenih razreda koriste konstruktor
osnovnog razreda. Napisati get i set metode za sve podatkovne članove, te preopteretiti
metodu toString() u svim razredima. Definirati razred Zadatak1 koji sadrži metodu main()
u kojoj će se inicijalizirati po jedan objekt svakog od razreda i prikazati sve ostvarene
funkcionalnosti.
*/

//Ivana Bošnjak, 2200/RR
abstract class Racunalo{
    private String model;
    private String proizvodjac;
    private String opSustav;
    public Racunalo(String model, String proizvodjac, String opSustav){
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.opSustav = opSustav;
    }
    abstract String dohvatiTipRacunala();
    abstract int izracunajPrenosivost();

    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getProizvodjac(){
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac){
        this.proizvodjac = proizvodjac;
    }
    public String getOpSustav(){
        return opSustav;
    }

    public void setOpSustav(String opSustav){
        this.opSustav = opSustav;
    }
    public String toString(){
        return "Model: " + model + ", proizvođač: " + proizvodjac + ", operacijski sustav: " + opSustav;
    }

}
class StolnoRacunalo extends Racunalo{
    private double[] dimenzijeKucista;
    public StolnoRacunalo(String model, String proizvodjac, String opSustav, double[] dimenzijeKucista){
        super(model, proizvodjac, opSustav);
        this.dimenzijeKucista = dimenzijeKucista;
    }

    public double[] getDimenzijeKucista(){
        return dimenzijeKucista;
    }
    public void setDimenzijeKucista(double[] dimenzijeKucista){
        this.dimenzijeKucista = dimenzijeKucista;
    }
    public String dohvatiTipRacunala(){

        return "Stolno racunalo";
    }
    public int izracunajPrenosivost(){
        return 5 +(int) ( dimenzijeKucista[0] * dimenzijeKucista[1] * dimenzijeKucista[2]) / 30;

    }
    public String toString(){
        return super.toString() + ", Dimenzije kučišta: " + dimenzijeKucista[0] + " x " +
                dimenzijeKucista[1] + " x " + dimenzijeKucista[2];
    }

}
class PrijenosnoRacunalo extends Racunalo{
    private int kapacitetBaterije;
    private double tezinaRacunala;
    public PrijenosnoRacunalo(String model, String proizvodjac, String opSustav, int kapacitetBaterije, double tezinaRacunala){
        super(model, proizvodjac, opSustav);
        this.kapacitetBaterije = kapacitetBaterije;
        this.tezinaRacunala = tezinaRacunala;
    }
    public int getKapacitetBaterije(){
        return kapacitetBaterije;
    }
    public void setKapacitetBaterije(int kapacitetBaterije){
        this.kapacitetBaterije = kapacitetBaterije;
    }
    public double getTezinaRacunala(){
        return tezinaRacunala;
    }
    public void setTezinaRacunala(double tezinaRacunala){
        this.tezinaRacunala = tezinaRacunala;
    }

    public String dohvatiTipRacunala(){

        return "Prijenosno racunalo";
    }
    public int izracunajPrenosivost(){
    return (int) tezinaRacunala;
    }
    public String toString(){
        return super.toString() + ", kapacitet baterije: " + kapacitetBaterije + ", težina: " + tezinaRacunala;
    }


}
final class Netbook extends PrijenosnoRacunalo{
    public Netbook(String model, String proizvodjac, String opSustav, int kapacitetBaterije, double tezinaRacunala){
        super(model, proizvodjac, opSustav, kapacitetBaterije, tezinaRacunala);
    }
    public int izracunajPrenosivost(){
        return 1;
    }
    public String dohvatiTipRacunala(){
        return "Netbook prijenosno racunalo";
    }

}
public class Z1 {
    public static void main(String[] args){
        double[] dimenzije = {2.3, 20.6, 10.4};

        StolnoRacunalo s = new StolnoRacunalo("Desktop", "Asus", "Windows", dimenzije);

        PrijenosnoRacunalo p = new PrijenosnoRacunalo("Laptop", "hp", "Linux", 5000, 1.3);

        Netbook n = new Netbook("Netbook", "Lenovo", "Windows", 4000, 1.2);

        System.out.println(s.dohvatiTipRacunala()+" - " + s);
        System.out.println(p.dohvatiTipRacunala() +" - "+ p);
        System.out.println(n.dohvatiTipRacunala()+" - " + n);

        System.out.println("Prenosivost stolnog računala: " + s.izracunajPrenosivost());
        System.out.println("Prenosivost prijenosnog računala: " + p.izracunajPrenosivost());
        System.out.println("Prenosivost netbooka: " + n.izracunajPrenosivost());

    }
}

