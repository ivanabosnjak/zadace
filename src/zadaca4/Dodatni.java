package zadaca4;

/* def aps razred gradjevina, sa sljedecim atr vrstagradjevine, ispisgradjevine,kreirati razred zgrada koja moze biti
stambena ili poslovna. zgrada ima atribute status koji moze biti izgradjena ili uizradi. odredjuje se na temenlju atr godizgradnje.
ima atr visina i brojkatova. kreirati razred cesta ima aatr duljinu i odakle dokle vodi ta cesta. kreirati dodatna 2 razreda
kuca i stambenazgrada koje nasljedjuju klasu zgrada. stambena zgrada atr brstanova. za sve klase dodati konstruktore
i metode set i get.*/

import java.time.*;
import java.util.Random;

abstract class Gradjevina{
    private String vrstaGradjevine;

    public String getVrstaGradjevine() {
        return vrstaGradjevine;
    }

    public void setVrstaGradjevine(String vrstaGradjevine) {
        this.vrstaGradjevine = vrstaGradjevine;
    }

    abstract String ispisGradjevine();
    public Gradjevina(String vrstaGradjevine){
        this.vrstaGradjevine = vrstaGradjevine;
    }
}
class Zgrada extends Gradjevina{
    private String tip;
    private String status;
    private double visina;
    private int brKatova;
    private int godIzgradnje;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getVisina() {
        return visina;
    }

    public int getBrKatova() {
        return brKatova;
    }

    public int getGodIzgradnje() {
        return godIzgradnje;
    }

    public void setGodIzgradnje(int godIzgradnje) {
        this.godIzgradnje = godIzgradnje;
    }

    public void setBrKatova(int brKatova) {
        this.brKatova = brKatova;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    public Zgrada(String vrstaGradjevine, double visina, int brKatova, int godIzgradnje){
        super(vrstaGradjevine);
        this.godIzgradnje = godIzgradnje;
        this.visina = visina;
        this.brKatova = brKatova;
        Random random = new Random();
        int randomBroj = random.nextInt(2);
        switch(randomBroj){
            case 0:
                tip= "stambena";
                break;
            case 1:
                tip="poslovna";
                break;
            default:
                tip= "greska";
                break;
        }
        int sadasnjaGodina = java.time.Year.now().getValue();
        if (godIzgradnje > sadasnjaGodina) {
            status = "u izradi";
        } else {
            status = "izgradjena";
        }
    }


    public String ispisGradjevine(){
        return "Vrsta gradjevine:"+ getVrstaGradjevine() + ", status:" + status + ", visina:"+ visina + ", broj katova:" +brKatova;
    }

}
class Cesta extends Gradjevina{
    private double duljina;
    private String relacija;

    public double getDuljina() {
        return duljina;
    }

    public void setDuljina(double duljina) {
        this.duljina = duljina;
    }

    public String getRelacija() {
        return relacija;
    }

    public void setRelacija(String relacija) {
        this.relacija = relacija;
    }

    public Cesta(String vrstaGradjevine, double duljina, String relacija){
        super(vrstaGradjevine);
        this.duljina = duljina;
        this.relacija = relacija;
    }
    public String ispisGradjevine(){
        return "Vrsta gradjevine:"+ getVrstaGradjevine() + ", duljina:" +duljina +", relacija:"+ relacija;
    }

}
class Kuca extends Zgrada{
    public Kuca(String vrstaGradjevine, double visina, int brKatova, int godIzgradnje){
        super(vrstaGradjevine, visina, brKatova, godIzgradnje);
    }
    public String ispisGradjevine(){
        return super.ispisGradjevine();
    }

}
class StambenaZgrada extends Zgrada{
    private int brStanova;
    public StambenaZgrada(String vrstaGradjevine, double visina, int brKatova, int brStanova){
        super(vrstaGradjevine, visina, brKatova,brStanova);
        this.brStanova = brStanova;
    }
    public String ispisGradjevine(){
        return super.ispisGradjevine() + ", broj stanova:" + brStanova;
    }

}
public class Dodatni{
    public static void main(String[] args){

        Zgrada zgrada = new Zgrada("Neki tip", 30.5, 5, 2020);
        Cesta cesta = new Cesta("Autocesta", 100.0, "Grad A - Grad B");
        Kuca kuca = new Kuca("Obiteljska kuća", 8.0, 2, 2005);
        StambenaZgrada stambenaZgrada = new StambenaZgrada("Stambena zgrada", 25.0, 8, 20);

        System.out.println(zgrada.ispisGradjevine());
        System.out.println(cesta.ispisGradjevine());
        System.out.println(kuca.ispisGradjevine());
        System.out.println(stambenaZgrada.ispisGradjevine());


    }
}
