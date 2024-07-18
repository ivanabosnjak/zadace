package zadaca3;

/*3. Definirajte razred ProgramskiJezik sa sljedećim članovima: podatkovni član tipa double
postotak, metode za dohvaćanje i postavljenje člana postotak. Definirajte razrede
Proceduralni, Objektni i Funkcionalni izvedene od razreda ProgramskiJezik. Definirajte
tri objekta procedura, objekt i funkcija tipova Proceduralni, Objektni i Funkcionalni
redom, te zatražite od korisnika da unese vrijednosti postotka za pojedini objekt. Ako je
zbroj postotaka različit od 100 ispišite poruku o neispravnom unosu podataka i svaki od
unesenih podataka proporcionalno umanjite kako bi njihova zbojr iznosila 100. Nakon
toga odredite koja je vrsta programskih jezika je najzastupljenija.*/

//Ivana Bošnjak, 2200/RR

import java.util.Scanner;

class ProgramskiJezik{
    private double postotak;
    public double dohvatiPostotak(){
        return postotak;
    }
    public void postaviPostotak(double postotak){
        this.postotak = postotak;
    }

}
class Proceduralni extends ProgramskiJezik{

}
class Objektni extends ProgramskiJezik{

}
class Funkcionalni extends ProgramskiJezik{

}
public class zadatak3{
    public static void main(String[] args){

        Proceduralni procedura = new Proceduralni();
        Objektni objekt = new Objektni();
        Funkcionalni funkcija = new Funkcionalni();

        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite postotak za proceduru:");
        double postotakP = sc.nextDouble();
        procedura.postaviPostotak(postotakP);

        System.out.println("Unesite postotak za objekt:");
        double postotakO = sc.nextDouble();
        objekt.postaviPostotak(postotakO);

        System.out.println("Unesite postotak za funkciju:");
        double postotakF = sc.nextDouble();
        funkcija.postaviPostotak(postotakF);

        if(postotakP+postotakO+postotakF != 100){
            System.out.println("Neispravan unos podataka. Podaci se podesavaju.");

            double faktorProporcionalnosti = (postotakP+postotakO+postotakF)/100;
            procedura.postaviPostotak(postotakP*faktorProporcionalnosti);
            objekt.postaviPostotak(postotakO*faktorProporcionalnosti);
            funkcija.postaviPostotak(postotakF*faktorProporcionalnosti);
        }

        if (procedura.dohvatiPostotak() > objekt.dohvatiPostotak() && procedura.dohvatiPostotak() > funkcija.dohvatiPostotak()) {
            System.out.println("Proceduralni jezik je najzastupljeniji.");
        } else if (objekt.dohvatiPostotak() > procedura.dohvatiPostotak() && objekt.dohvatiPostotak() > funkcija.dohvatiPostotak()) {
            System.out.println("Objektni jezik je najzastupljeniji.");
        } else {
            System.out.println("Funkcionalni jezik je najzastupljeniji.");
        }
    }
}