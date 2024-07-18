package zadaca4;
/*
Kreirati apstraktnu klasu Klima koja ima apstraktnu metodu:
String znacajke(intt, int v); i ima dva niza stringova:
String[]ugodjaj = {"prohladno","ugodno","toplo", "vruce", "prevruce"};
String[] vlaznost ={"presuho","suho","normalno","vlazno","prevlazno"};
Kreirati klasu Ljeto koja nasljeđuje klasu Klima. Klasa Ljeto ima dva Člana:
int temperatura i int vlaga.
Klasa Ljeto ima konstruktor bez parametara u kojem se nasumičnim odabirom generira temperatuta iz intervala (t_min, t_max),
 te količina vlage iz intervala [v_min, v_maxl. Postaviti za granice temperature interval [10,40], a za vlaznost [O, 10].
Klasa ima metodu int getTemperatura(), kojom se dohvaća vrijednost temperature.
Implementirati apstraktnu metodu tako da se ispisuje prognoza temeljem proslijeđene temperature i vlažnosti.
 Temeljem vlage bira se jedan string iz niza vlaznost I to prema definiranom pravilu: indeks stringa u nizu određuje se kao:
index=(v-v_min) /[(v_max-v_min) /5],

gdje je v proslijeđena vlaga. Temeljem određenog indeksa kojim se definira string za vlažnost, određuje se i string iz niza ugodaj,
 i to tako da bude za jedan veći ili za jedan manji od indeksa koji definira vlažnost (paziti da string s naznačenim indeksom postoji u nizu ugodaj).
  Uz definirane vrijednosti stringova, metoda znacajke, generira string oblika:
 "Obiljezje klime je [ugodajl i [vlaznost] vrijeme.” , gdje su (ugoda) I [vlaznost], odabrani stringovi prema gore opisanom pravilu.
Implementirati metodu void zatopljenje(int t) koja povecava trenutnu temperature za vrijednost proslijeđenog parametra t, ali do t_max
(provjeriti korištenjem metode getTemperatura)
Na sličan način na koji se kreira klasa Ljeto, kreiraju se još klase Jesen, Zime i Proljece (pretpostaviti da postoje kreirane).
Kreirati testnu klasu App, u kojoj treba generirati niz Klimao koji ima 100 članova tipa Proljece, Ljeto, Jesen i Zima (nasumičan odabir).
 Za sve objekte klase Ljeto treba ispisati značajke klime pozivom metode znacajke, te nasumičnim odabirom dva objekta klase Ljeto
 (objekti ne smiju biti isti), povecati temperature objekata pozivom metode zatopljenje, i nakon toga ispisati ponovno značajke klime
 za sve objekte klase Ljeto.*/
