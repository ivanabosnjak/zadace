package zadaca5;

/*3. Napisati program koji prikazuje formu koja predstavlja jednostavni kalkulator sa gumbima
sa znamenkama od 0 do 9, četiri osnovne računske operacije (+, -, * i /) i provođenje
operacije (=), resetiranje zadnjeg unosa (C) i gašenje aplikacije (X) te tekstualnim okvirom
za prikaz unesenih operanada i rezultata. Pritiskom na gumbe sa znamenkama unosi se
operand (npr. za pritisnute tipke 4, 3 i 7 u tekstualnom okviru prikazuje se operand 437).
Pritiskom na gumb neke od računskih operacija briše se tekstualni okvir i potvrđuje prvi
operand. Nakon toga unosi se drugi operand. Pritiskom na gumb za provođenje operacije
briše se tekstualni okvir i potvrđuje drugi operand, provodi računska operacija i u
tekstualni okvir upisuje rezultat. Pritisak na gumb za resetiranje zadnjeg unosa briše se
tekstualni okvir. Pritiskom na gumb za gašenje aplikacije zatvara se forma.
*/
//Ivana Bošnjak, 2200/RR

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad3 {
    static String trenutniUnos = "";
    static double operand1 = 0;
    static char trenutnaOperacija;

    public static void main(String[] arg) {
        JFrame jf = new JFrame();
        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));

        JButton jb0 = new JButton("0");
        JButton jb1 = new JButton("1");
        JButton jb2 = new JButton("2");
        JButton jb3 = new JButton("3");
        JButton jb4 = new JButton("4");
        JButton jb5 = new JButton("5");
        JButton jb6 = new JButton("6");
        JButton jb7 = new JButton("7");
        JButton jb8 = new JButton("8");
        JButton jb9 = new JButton("9");
        JButton jbplus = new JButton("+");
        JButton jbminus = new JButton("-");
        JButton jbputa = new JButton("*");
        JButton jbpodijeljeno = new JButton("/");
        JButton jbjednako = new JButton("=");
        JButton jbc = new JButton("C");
        JButton jbx = new JButton("X");
        JTextArea jta = new JTextArea();

        dodajALNaTipku(jb0, jta);
        dodajALNaTipku(jb1, jta);
        dodajALNaTipku(jb2, jta);
        dodajALNaTipku(jb3, jta);
        dodajALNaTipku(jb4, jta);
        dodajALNaTipku(jb5, jta);
        dodajALNaTipku(jb6, jta);
        dodajALNaTipku(jb7, jta);
        dodajALNaTipku(jb8, jta);
        dodajALNaTipku(jb9, jta);
        dodajALNaTipkuOperacija(jbplus, '+', jta);
        dodajALNaTipkuOperacija(jbminus, '-', jta);
        dodajALNaTipkuOperacija(jbputa, '*', jta);
        dodajALNaTipkuOperacija(jbpodijeljeno, '/', jta);
        dodajALNaJednako(jbjednako, jta);
        dodajALNaObrisi(jbc, jta);
        dodajALNaIzlaz(jbx);

        panel.add(jb7);
        panel.add(jb8);
        panel.add(jb9);
        panel.add(jbplus);
        panel.add(jb4);
        panel.add(jb5);
        panel.add(jb6);
        panel.add(jbminus);
        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);
        panel.add(jbputa);
        panel.add(jb0);
        panel.add(jbc);
        panel.add(jbjednako);
        panel.add(jbpodijeljeno);

        jf.setLayout(new BorderLayout());
        jf.add(panel, BorderLayout.CENTER);
        jf.add(jbx, BorderLayout.SOUTH);
        jf.add(jta, BorderLayout.NORTH);

        jf.setSize(400, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jta.setEditable(false);
        jta.setPreferredSize(new Dimension(400, 100));
    }

    public static void dodajALNaTipku(JButton button, JTextArea jta) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trenutniUnos += button.getText();
                azurirajTextArea(jta);
            }
        });
    }

    public static void dodajALNaTipkuOperacija(JButton button, char operacija, JTextArea jta) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                izvrsiOperaciju(jta);
                trenutnaOperacija = operacija;
            }
        });
    }

    public static void dodajALNaJednako(JButton button, JTextArea jta) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                izvrsiOperaciju(jta);
                azurirajTextArea(jta);
            }
        });
    }

    public static void dodajALNaObrisi(JButton button, JTextArea jta) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obrisi();
                azurirajTextArea(jta);
            }
        });
    }

    public static void dodajALNaIzlaz(JButton button) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void izvrsiOperaciju (JTextArea jta) {
        if (!trenutniUnos.isEmpty()) {
            double trenutniBroj = Double.parseDouble(trenutniUnos);
            switch (trenutnaOperacija) {
                case '+':
                    operand1 += trenutniBroj;
                    break;
                case '-':
                    operand1 -= trenutniBroj;
                    break;
                case '*':
                    operand1 *= trenutniBroj;
                    break;
                case '/':
                    if (trenutniBroj != 0) {
                        operand1 /= trenutniBroj;
                    } else {
                        obrisi();
                        azurirajTextArea(jta);
                        JOptionPane.showMessageDialog(null, "Greska. Pokusaj dijeljenja s nulom.");
                    }
                    break;
                default:
                    operand1 = trenutniBroj;
            }
            obrisi();
        }
    }

    public static void obrisi() {
        trenutniUnos = "";
    }

    public static void azurirajTextArea(JTextArea jta) {
        jta.setText(String.valueOf(operand1) + " " + trenutnaOperacija + " " + trenutniUnos);
    }
}


