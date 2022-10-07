package com.adlinec.applicationDesktop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
// pour la création de la fenêtre
    public Fenetre(){
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//création formulaire
        JPanel panneau = new JPanel();

        setContentPane(panneau);

        JButton bouton = new JButton(" ☞ Click me! ☻");

        panneau.add(bouton);
//creation nouvelle classe anonime qui implemente l'interfaceActionListener
        ActionListener evenement = new ActionListener(){
            @Override
            public  void actionPerformed(ActionEvent e) {
                System.out.println("Oui c pour quoi 🤔");
            }
        };

//avant ActionListener evenement = e -> System.out.println(" Click!");
//idem  bouton.addActionListener(evenement);
//création class anonyme qui implement l'interface et surcharge la methode ActionListener
        bouton.addActionListener(e -> System.out.println(" You clicked me!👏🏻"));
//⚠️ ferme la fenêtre, mais ne stoppe pas le programme
        bouton.addActionListener(e -> setVisible(false));



        setVisible(true);
    }

    public static void main(String[] args) {
        new Fenetre();
    }
}
