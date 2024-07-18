package zadaca5;
/*2. Napisati program koji prikazuje formu sa dva tekstualna okvira za unos podataka,
gumbom za potvrdu i labelom. U dva tekstualna okvira se unose proizvoljni cijeli brojevi.
Pritiskom na gumb za potvrdu određuje se koji je od dva broj manji, a koji veći. Labeli se
dodjeljuje sadržaj: "Prosti brojevi između <manji od dva unesena broja> i <veći od dva
unesena broja> su <svi prosti brojevi između unesenih brojeva, odvojeni zarezom i s
točkom na kraju>"
*/
//Ivana Bošnjak, 2200/RR

import java.awt.event.*;
import javax.swing.*;

public class Zad2 {
    public static void main(String[] args){
        JFrame jf = new JFrame();
        JTextField jtf1 = new JTextField();
        JTextField jtf2 = new JTextField();
        JButton jb = new JButton("Potvrdi");
        JLabel jl = new JLabel();

        jf.setSize(1000,500);
        jf.setTitle("Zadatak 2");
        jtf1.setBounds(10,10,150,20);
        jtf2.setBounds(10,40,150,20);
        jb.setBounds(10,80,100,20);
        jl.setBounds(10,110,400, 100);

        jb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int prviBroj = Integer.valueOf(jtf1.getText());
                int drugiBroj = Integer.valueOf(jtf2.getText());
                String rezultat = "";


                if (prviBroj > drugiBroj) {
                    for (int i = drugiBroj; i <= prviBroj; i++) {
                        if (jeLiProst(i)) {
                            rezultat += i+  ", ";
                        }
                    }
                } else if (drugiBroj > prviBroj) {
                    for (int i = prviBroj; i <= drugiBroj; i++) {
                        if (jeLiProst(i)) {
                            rezultat += i + ", ";
                        }
                    }

                } else{
                    jl.setText("Brojevi su jednaki");
                    return;
                }
                if (!rezultat.isEmpty()) {
                    rezultat = rezultat.substring(0, rezultat.length() - 2);
                }
                if(drugiBroj < prviBroj) {
                    jl.setText("Prosti brojevi između " + drugiBroj + " i veći od " + prviBroj + " su: " + rezultat + ".");
                }else{
                    jl.setText("Prosti brojevi između " + prviBroj + " i veći od " + drugiBroj + " su: " + rezultat + ".");
                }

            }

        });

        jf.add(jtf1);
        jf.add(jtf2);
        jf.add(jb);
        jf.add(jl);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.setVisible(true);
    }
    public static boolean jeLiProst(int broj){
        if (broj < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(broj); i++) {
            if (broj % i == 0) {
                return false;
            }
        }
        return true;
    }
}
