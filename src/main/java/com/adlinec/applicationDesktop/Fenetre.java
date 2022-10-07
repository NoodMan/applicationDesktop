package com.adlinec.applicationDesktop;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Fenetre extends JFrame {
// mise en place theme sombre
    protected boolean themeSombre = true;

// pour la création de la fenêtre
    public Fenetre(){
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//création formulaire
        JPanel panneau = new JPanel();

        setContentPane(panneau);

//-------------------------------------BOUTON------------------------------
        JButton bouton = new JButton(" ☞ Click me for close app! ☻");

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




//----------------------------------COMBO BOX--------------------------------
//création liste déroulante
        String[] listeCivilite = {"Mr.", "Me.", "Mlle", "Non précisé!"};
        JComboBox<String> selectCivilite = new JComboBox<>(listeCivilite);
        panneau.add(selectCivilite);

// pour récupérer un évènement
        selectCivilite.addActionListener((ActionEvent e)  -> {
            JComboBox comboBox = (JComboBox) e.getSource();
            System.out.println(comboBox.getSelectedItem());

        });
        Utilisateur[] utilisateurs = {
                null,
                new Utilisateur("Balthazar", "Picsou"),
                new Utilisateur("Archibald", "Gripsou"),
                new Utilisateur("Flagada", "Jones"),
        };
        JComboBox<Utilisateur> selectUtilisateur = new JComboBox<>(utilisateurs);

// pour afficher la liste d'utilisateur custom
        selectUtilisateur.setRenderer(
               new DefaultListCellRenderer() {
                   @Override
                   public Component getListCellRendererComponent(
                           final JList<?> list,
                           final Object value,
                           final int index,
                           final boolean isSelected,
                           final boolean cellHasFocus) {
                       super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                       Utilisateur utilisateur = (Utilisateur) value;
                       if(utilisateur != null){
                           setText(utilisateur.getPrenom() + " " + utilisateur.getPrenom());
                       }else {
                           setText("Aucun");
                       }
// setText(utilisateur.getNom() + " " + utilisateur.getPrenom()); // a utiliser si sans la condition (if ! null)
//couleur si sélectionner
                       if(isSelected) {
                           setBackground(Color.CYAN);
                       }else {
                           setBackground(Color.RED);
                       }

//                       setText("toto" + "blabla");
//                       setText("toto");
                       return this;
                   }
               }
        );
        panneau.add(selectUtilisateur);


// ---------------------------------BOUTON DU FORMULAIRE------------------------------------------
// création bouton formulaire

        JButton boutonFormulaire = new JButton("Envoyer");
        boutonFormulaire.addActionListener(e -> {

            if(selectUtilisateur.getSelectedItem() != null) {
                Utilisateur utilisateur =
                        (Utilisateur)selectUtilisateur.getSelectedItem();

                System.out.println(
                        selectCivilite.getSelectedItem() + utilisateur.getNom()
                );
            }

        });

        panneau.add(boutonFormulaire);





        //-------------change background color windows--------------

        JButton boutonChangeTheme = new JButton("Change theme");
        panneau.add(boutonChangeTheme);
        boutonChangeTheme.addActionListener(e -> {
            try {
                if(themeSombre) {
                    themeSombre = false;
                    UIManager.setLookAndFeel(new FlatLightLaf());
                }else {
                    themeSombre = true;
                    UIManager.setLookAndFeel(new FlatDarculaLaf());
            }
                SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ex) {
                System.out.println("Failed to initialize Laf");
            }
            });
//-------------------------------------FERMETURE APPLI --------------------------------------
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
//-----------------------------------AUTRE FERMETURE APPLI----------------------

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
//--------------------------------------------------------------------------

        setVisible(true);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup(); // version dark
//FlatLightLaf.setup();
        new Fenetre();
    }
}
