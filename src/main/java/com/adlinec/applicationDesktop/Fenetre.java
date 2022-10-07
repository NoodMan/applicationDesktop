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
//        ActionListener evenement = new ActionListener(){
//            @Override
//            public  void actionPerformed(ActionEvent e) {
//                System.out.println("Oui c pour quoi 🤔");
//            }
//        };

//avant ActionListener evenement = e -> System.out.println(" Click!");
//idem  bouton.addActionListener(evenement);
//création class anonyme qui implement l'interface et surcharge la methode ActionListener
        bouton.addActionListener(e -> System.out.println(" You clicked me!👏🏻"));

//⚠️ ferme la fenêtre en cliquant sur le bouton, mais ne stoppe pas le programme
//      bouton.addActionListener(e -> setVisible(false));

//        bouton.addActionListener((e -> {
//            JOptionPane.showMessageDialog(this,"L'application va se fermer");
//            System.exit(0);
//        }));

//fermer la fenêtre oui ou non ?
//        bouton.addActionListener(e -> {
//          int reponse =  JOptionPane.showConfirmDialog(
//                    this,
//                   "Voulez vous fermer l'application ?",
//                  "Confirmer",
//                  JOptionPane.YES_NO_OPTION
//            );
//
//            if(reponse == JOptionPane.YES_OPTION){
//                System.exit(0);
//            }
//        });

        bouton.addActionListener(e ->  {
            Object[] choix = {"Oui","Nope :("};
            int reponse = JOptionPane.showOptionDialog(this,
                    "Voulez vous fermer l'application ?",
                    "Confirmer",
                    JOptionPane.YES_NO_OPTION,
            //        JOptionPane.QUESTION_MESSAGE, // image java normal
                    JOptionPane.QUESTION_MESSAGE, // image panneau stop java
                    null,
                    choix,
                    choix[0]);

            if(reponse == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new Fenetre();
    }
}
