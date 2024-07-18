package zadaca3;

/*2. Definirajte razred NebeskoTijelo sa sljedećim članovima: podatkovni članovi tipa double
BrzinaOkoOsi i BrzinaOkoSunca., konstruktor koji podatkovnim članovima daje
proslijeđene vrijednosti i metodu koja nadjačava metodu toString() ispisujući
podatkovne članove. Definirajte razrede Planet i Satelit izvedene iz razreda
NebeskoTijelo koji imaju dodatni podatkovni string član Naziv te im definirajte sljedeće
konstruktore sa jednim string i dva double parametra koji će dodijeliti vrijednosti
proslijeđenih argumenata nazivnu tijela i naslijeđenim podatkovnim članovima.
Definirajte dva objekta Zemlja i Mjesec tipova Planet i Satelit.*/

//Ivana Bošnjak, 2200/RR

class NebeskoTijelo{
   public double BrzinaOkoOsi;
   public double BrzinaOkoSunca;

   public NebeskoTijelo(double BrzinaOkoOsi, double BrzinaOkoSunca){
       this.BrzinaOkoOsi = BrzinaOkoOsi;
       this.BrzinaOkoSunca = BrzinaOkoSunca;
   }

    public String toString(){
        return "Brzina oko osi: "+BrzinaOkoOsi+ ", brzina oko Sunca: "+BrzinaOkoSunca;
    }
}
class Planet extends NebeskoTijelo{
    public String Naziv;
    public Planet(String Naziv, double BrzinaOkoOsi, double BrzinaOkoSunca){
        super(BrzinaOkoOsi, BrzinaOkoSunca);
        this.Naziv = Naziv;
    }
    public String toString() {
        return "Planet " + Naziv + ": " + super.toString();
    }
}
class Satelit extends NebeskoTijelo{
    public String Naziv;
    public Satelit(String Naziv, double BrzinaOkoOsi, double BrzinaOkoSunca){
        super(BrzinaOkoOsi, BrzinaOkoSunca);
        this.Naziv = Naziv;
    }
    public String toString() {
        return "Satelit " + Naziv + ": " + super.toString();
    }
}
public class zadatak2{
    public static void main(String[] args){

        Planet Zemlja = new Planet("Zemlja",0.4651, 29.78 );
        Satelit Mjesec = new Satelit("Mjesec",0.004627 ,29.78);

        System.out.println(Zemlja);
        System.out.println(Mjesec);
    }
}
