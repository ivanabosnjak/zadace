package zadaca4;

/*2. Definirati sučelje Dokument koje sadrži metode dajPeriodPosudbe() . Definirati razred
DokumentKnjiznice sa podatkovnim članovima ID (cijeli broj) i nazivDokumenta
(tekstualni podataka) koji implementira sučelje Dokument. Napraviti razrede Knjiga,
Casopis, DigitalniDokument i E_Dokument koji nasljeđuju razred DokumentKnjiznice.
Book ima podatkovni član autor (tekstualni podatak), Casopis ima podatkovne članove
kategorijaSadrzaja (tekstualni podatak) i izdanje (cijeli broj), DigitalniDokument opisuje
digitalni medij za pohranu podataka i ima podatkovni član tip (tekstualni podataka, npr.
CD ili VHS), dok E_Dokument opisuje sadržaj koji je moguće preuzeti na neki elektronski
uređaj i ima podatkovni član (tekstualni podatak). Razredi Udzbenik i Rjecnik nasjeđuju
razred Knjiga. Udzbenik ima podatkovni član predmet (tekstualni podatak), a Rjecnik
podatkovne članove prviJezik i drugiJezik (tekstualni podaci). Razred DokumentKnjiznice
sadrži metodu dajPeriodPosudbe() bez parametara koja za objekte različitih izvedenih
razreda vraća različite cjelobrojne vrijednosti (za knjige je period posudbe 14 dana, osim
za udžbenike za koje je 120 dana, za časopise 7 dana, a za digitalne i e-dokumente 30
dana) te apstraktne metode jeLiPotrebanPolog() (koja vraća logičku vrijednost true za
udžbenike i digitalne sadržaje, odnosno vrijednost false) i dajIznosPologa() koji vraća
različite (proizvoljne) vrijednosti za sve vrste dokumena. Napisati konstruktore za sve
razrede, pri čemu konstruktori izvedenih razreda koriste konstruktor osnovnog razreda.
Napisati get i set metode za sve podatkovne članove, te preopteretiti metodu toString()
u svim razredima. Definirati razred Zadatak2 koji sadrži metodu main() u kojoj će se
instancirati 50 objekata različitih razreda (slučajnim izborom se određuje razred čiji će se
objekt inicijalizirati) te se ispisuju podaci za svakog od njih.
*/
//Ivana Bošnjak, 2200/RR

import java.util.Random;
interface Dokument{
    public int dajPeriodPosudbe();
}
abstract class DokumentKnjiznice implements Dokument{
    private int ID;
    private String nazivDokumenta;
    public int dajPeriodPosudbe(){
        return 30;
    }
    abstract boolean jeLiPotrebanPolog();
    abstract double dajIznosPologa();

    public DokumentKnjiznice(int ID, String nazivDokumenta){
        this.ID = ID;
        this.nazivDokumenta = nazivDokumenta;
    }
    public int getID(){
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getNazivDokumenta(){
        return nazivDokumenta;
    }

    public void setNazivDokumenta(String nazivDokumenta) {
        this.nazivDokumenta = nazivDokumenta;
    }
    public String toString() {
        return "ID: " + ID + ", naziv: " + nazivDokumenta;
    }
}
class Knjiga extends DokumentKnjiznice{
    private String autor;
    public int dajPeriodPosudbe(){
        return 14;
    }
    public boolean jeLiPotrebanPolog(){
        return false;
    }
    public double dajIznosPologa(){
        return 0.0;
    }

    public Knjiga(int ID, String nazivDokumenta, String autor){
        super(ID,nazivDokumenta);
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String toString() {
        return super.toString() + ", autor: " + autor;
    }
}
class Casopis extends DokumentKnjiznice{
    private String kategorijaSadrzaja;
    private int izdanje;
    public int dajPeriodPosudbe(){
        return 7;
    }
    public boolean jeLiPotrebanPolog(){
        return false;
    }
    public double dajIznosPologa(){
        return 0.0;
    }
    public Casopis(int ID, String nazivDokumenta, String kategorijaSadrzaja, int izdanje){
        super(ID,nazivDokumenta);
        this.kategorijaSadrzaja = kategorijaSadrzaja;
        this.izdanje = izdanje;
    }
    public String getKategorijaSadrzaja() {
        return kategorijaSadrzaja;
    }

    public void setKategorijaSadrzaja(String kategorijaSadrzaja) {
        this.kategorijaSadrzaja = kategorijaSadrzaja;
    }

    public int getIzdanje() {
        return izdanje;
    }

    public void setIzdanje(int izdanje) {
        this.izdanje = izdanje;
    }
    public String toString() {
        return super.toString() + ", kategorija sadržaja: " + kategorijaSadrzaja + ", izdanje: " + izdanje;
    }
}
class DigitalniDokument extends DokumentKnjiznice{
    private String tip;
    public boolean jeLiPotrebanPolog(){
        return true;
    }
    public double dajIznosPologa(){
        return 4.3;
    }
    public DigitalniDokument(int ID, String nazivDokumenta, String tip){
        super(ID, nazivDokumenta);
        this.tip = tip;
    }
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
    public String toString() {
        return super.toString() + ", tip: " + tip;
    }
}
class E_Dokument extends DokumentKnjiznice{
    private String sadrzaj;
    public boolean jeLiPotrebanPolog(){
        return true;
    }
    public double dajIznosPologa(){
        return 7.2;
    }
    public E_Dokument(int ID, String nazivDokumenta, String sadrzaj){
        super(ID, nazivDokumenta);
        this.sadrzaj = sadrzaj;
    }
    public String getSadrzaj(){
        return sadrzaj;
    }
    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }
    public String toString() {
        return super.toString() + ", sadrzaj: " + sadrzaj;
    }
}
class Udzbenik extends Knjiga{
    private String predmet;
    public int dajPeriodPosudbe(){
        return 120;
    }
    public boolean jeLiPotrebanPolog(){
        return true;
    }
    public double dajIznosPologa(){
        return 6.3;
    }

    public Udzbenik(int ID, String nazivDokumenta,String autor, String predmet){
        super(ID, nazivDokumenta, autor);
        this.predmet = predmet;

    }
    public String getPredmet() {
        return predmet;
    }
    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }
    public String toString() {
        return super.toString() + ", predmet: " + predmet;
    }
}
class Rjecnik extends Knjiga{
    private String prviJezik;
    private String drugiJezik;
    public Rjecnik(int ID, String nazivDokumenta,String autor, String prviJezik, String drugiJezik) {
        super(ID, nazivDokumenta, autor);
        this.prviJezik = prviJezik;
        this.drugiJezik = drugiJezik;
    }
    public String getPrviJezik() {
        return prviJezik;
    }
    public void setPrviJezik(String prviJezik) {
        this.prviJezik = prviJezik;
    }
    public String getDrugiJezik() {
        return drugiJezik;
    }
    public void setDrugiJezik(String drugiJezik) {
        this.drugiJezik = drugiJezik;
    }
    public String toString() {
        return super.toString() + ", Prvi jezik: " + prviJezik + ", Drugi jezik: " + drugiJezik;
    }
}
public class Z2{
    public static void main(String[] args){
    Random random = new Random();
        for (int i = 0; i < 50; i++) {
            DokumentKnjiznice dokument = null;

            int randomBroj = random.nextInt(6);

            switch (randomBroj) {
                case 0:
                    dokument = new Knjiga(1, "Naslov knjige", "Autor knjige");
                    break;
                case 1:
                    dokument = new Casopis(2, "Naslov casopisa", "Kategorija casopisa", 2022);
                    break;
                case 2:
                    dokument = new DigitalniDokument(3, "Naslov digitalnog dokumenta", "CD");
                    break;
                case 3:
                    dokument = new E_Dokument(4, "Naslov e-dokumenta", "Sadrzaj e-dokumenta");
                    break;
                case 4:
                    dokument = new Udzbenik(5, "Naslov udzbenika", "Autor udzbenika", "Predmet udzbenika");
                    break;
                case 5:
                    dokument = new Rjecnik(6, "Naslov rjecnika", "Autor rjecnika", "Prvi jezik", "Drugi jezik");
                    break;
            }


            System.out.println("Podaci za dokument " + (i + 1) + " - " + dokument+
                            "\n Period Posudbe: " + dokument.dajPeriodPosudbe() +
                            "\n Potreban Polog: " + dokument.jeLiPotrebanPolog()+
                            "\n Iznos Pologa: " + dokument.dajIznosPologa());

        }
    }
}
