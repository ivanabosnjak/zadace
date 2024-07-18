package zadaca3;

/*2. Kreirajte klasu Kvart koja ima atribute: ime (String), opremljenost (double). Ime kvarta može
biti jedno iz niza: {Zapadala, Bijeli, Rani, Trudi, Mladi, Sneni}. Klasa ima konstruktor bez
parametara u kojem se vrijednost atributa opremljenost određuje kao slučajan broj veći od
nula i manji od jedan, a vrijednost atributa ime određuje se slučajnim odabirom indeksa koji
određuje ime iz niza potencijalnih imena. Klasa ima metodu toString() koja vraća string s
ispisanim imenom kvarta. U metodi main(String[] args), inicijalizirajte objekt klase Kvart i
ispišite ime kvarta u kojem se nalazi.*/

import java.util.Random;
import java.util.*;

class Kvart{
    public String [] niz = {"Zapadala", "Bijeli", "Rani", "Trudi", "Mladi", "Sneni"};
    public String ime;
    public double opremljenost;

    public Kvart(){
        Random rand = new Random();
        opremljenost =Math.random();
        int i = rand.nextInt(6);
        ime = niz[i];
    }

    public String toString(){
        return "Ime kvarta je: "+ ime;
    }

}
public class vjezba {
    public static void main(String [] args){
        Kvart k = new Kvart();

        System.out.println(k);
    }
}