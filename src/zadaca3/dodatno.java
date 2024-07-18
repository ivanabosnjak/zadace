package zadaca3;

/* Napisati program u kojem definirate klasu sportas koji ima sljedece atribute.
ime i sport. definirati kalasu atleticar koja je izvedena
iz klase sportas. def klase trkac i bacac kugle. ispisi sport. koliko je ukupno sportasa u sportu.
definirati klasu test u kojoj testirate te klase*/
class Sportas{
    public String ime;
    public String sport;
    public static int brojac;

    public Sportas(String ime, String sport){
        this.ime = ime;
        this.sport = sport;
        brojac++;
    }

    public String toString(){
        return "Sportas "+ ime +", sport:"+ sport;
    }
}
class Atleticar extends Sportas{
    public Atleticar(String ime, String sport){
        super(ime,sport);
    }

}
class Trkac extends Atleticar{

    public static int brojacTrkaca;

    public Trkac(String ime, String sport){
        super(ime,sport);
        brojacTrkaca++;
    }

}
class Bacac extends Atleticar{

    public static int brojacBacaca;

    public Bacac (String ime, String sport){
        super(ime,sport);
        brojacBacaca++;

    }

}
public class dodatno{
    public static void main (String [] args){

        Trkac t1 = new Trkac("Marko", "sprint");
        Trkac t2 = new Trkac("Ivo", "maraton");
        Trkac t3 = new Trkac("Lana", "maraton");
        Bacac b1 = new Bacac("Pero", "bacanje kugle");
        Bacac b2 = new Bacac("Ana", "bacanje diska");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        System.out.println("Broj sportasa: "+ Sportas.brojac);
        System.out.println("Broj trkaca: "+ Trkac.brojacTrkaca);
        System.out.println("Broj bacaca: "+ Bacac.brojacBacaca);




    }
}
