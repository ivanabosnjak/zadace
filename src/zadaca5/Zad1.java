package zadaca5;
/*1. Napisati program koji prikazuje formu sa tekstualnim okvirom za unos podataka, gumbom
za potvrdu i tekstualnim područjem. U tekstualni okvir se unosi proizvoljni tekst. Pritiskom
na gumb za potvrdu, tekst se dodaje kao novi redak u tekstualno područje, ali tako da se
sva velika slova zamijene malima i obratno.*/

//Ivana Bošnjak, 2200/RR

import javax.swing.*;
import java.awt.event.*;

public class Zad1 {
    public static void main(String[] args){
        JFrame jf = new JFrame();
        JTextField jtf = new JTextField();
        JTextArea jta = new JTextArea();
        JButton jb = new JButton("Potvrdi");

        jf.setSize(1000,500);
        jf.setTitle("Zadatak 1");
        jtf.setBounds(10,10,150,20);
        jb.setBounds(10,50,100,20);
        jta.setBounds(10,100,150,200);

        jb.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                String tekst = jtf.getText();
                char[] tekstNiz = tekst.toCharArray();
                for (int i = 0; i < tekstNiz.length; i++) {
                    if (Character.isLowerCase(tekstNiz[i])) {
                        tekstNiz[i] = Character.toUpperCase(tekstNiz[i]);
                    } else if (Character.isUpperCase(tekstNiz[i])) {
                        tekstNiz[i] = Character.toLowerCase(tekstNiz[i]);
                    }
                }
                String rezultat = new String(tekstNiz);
                jta.append(rezultat + "\n");
                jtf.setText("");

            }
        });
        jf.add(jta);
        jf.add(jtf);
        jf.add(jb);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.setVisible(true);

    }
}
