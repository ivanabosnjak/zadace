package zadaca3;
/*1. Definirajte razred GeometrijskoTijelo sa sljedećim članovima: podatkovni članovi tipa
double Volumen i Oplosje, statička podatkovni član tipa int BrojacTijela, konstruktor koji
podatkovnim članovima daje proslijeđene vrijednosti i metodu koja nadjačava metodu
toString() ispisujući podatkovne članove objekta te njegov redni broj. Definirajte razrede
Kugla i Kvadar izvedene iz razreda GeometrijskoTijelo. Definirajte razred Kocka izveden
iz klase Kvadar. Definirajte objekte kugla, kvadar i kocka razreda Kugla, Kvadar i Kocka
i povećajte vrijednost varijable BrojacTijela za 1 sa svakom definicijom objekta.*/

//Ivana Bošnjak, 2200/RR

class GeometrijskoTijelo{

    public double Volumen;
    public double Oplosje;
    public static int BrojacTijela;

    public GeometrijskoTijelo(double Volumen, double Oplosje){
        this.Volumen = Volumen;
        this.Oplosje = Oplosje;
        BrojacTijela++;

    }

    public String toString(){
        return "Geometrijsko tijelo, volumen: "+ Volumen +", oplosje: "+ Oplosje + ", redni broj: "+ BrojacTijela;
    }

}
class Kugla extends GeometrijskoTijelo{

    public Kugla(double Volumen, double Oplosje){
        super(Volumen, Oplosje);
    }
    public String toString(){
        return "Kugla - "+ super.toString();
    }

}
class Kvadar extends GeometrijskoTijelo{
    public Kvadar(double Volumen, double Oplosje){
        super(Volumen, Oplosje);
    }
    public String toString(){
        return "Kvadar - "+ super.toString();
    }

}
class Kocka extends Kvadar{
    public Kocka(double Volumen, double Oplosje){
        super(Volumen, Oplosje);
    }
    public String toString(){
        return "Kocka - "+ super.toString();
    }


}
public class zadatak1 {
    public static void main(String [] args){

        Kugla kugla = new Kugla (2.3, 4.5);
        Kvadar kvadar = new Kvadar (3.6, 5.4);
        Kocka kocka = new Kocka (4.3, 6.7);

        System.out.println(kugla);
        System.out.println(kvadar);
        System.out.println(kocka);

        System.out.println("Broj geometrijskih tijela: "+GeometrijskoTijelo.BrojacTijela);
    }
}


