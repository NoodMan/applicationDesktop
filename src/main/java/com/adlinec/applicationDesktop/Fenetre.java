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
    public Fenetre() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//création formulaire
//pour le positionner les élèments dans la fenêtre
        JPanel panneau = new JPanel(new BorderLayout());

        setContentPane(panneau);

//-------------------------------------BOUTON------------------------------
        JButton bouton = new JButton(" ☞ Click me for close app! ☻");


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


// pour récupérer un évènement
        selectCivilite.addActionListener((ActionEvent e) -> {
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
                        if (utilisateur != null) {
                            setText(utilisateur.getPrenom() + " " + utilisateur.getPrenom());
                        } else {
                            setText("Aucun");
                        }
// setText(utilisateur.getNom() + " " + utilisateur.getPrenom()); // a utiliser si sans la condition (if ! null)
//couleur si sélectionner
                        if (isSelected) {
                            setBackground(Color.CYAN);
                        } else {
                            setBackground(Color.RED);
                        }

//                       setText("toto" + "blabla");
//                       setText("toto");
                        return this;
                    }
                }
        );


// ---------------------------------BOUTON DU FORMULAIRE------------------------------------------
// création bouton formulaire

        JButton boutonFormulaire = new JButton("Envoyer");
        boutonFormulaire.addActionListener(e -> {

            if (selectUtilisateur.getSelectedItem() != null) {
                Utilisateur utilisateur =
                        (Utilisateur) selectUtilisateur.getSelectedItem();

                System.out.println(
                        selectCivilite.getSelectedItem() + utilisateur.getNom()
                );
            }

        });


        //-------------change background color windows--------------

        JButton boutonChangeTheme = new JButton("Change theme");
        panneau.add(boutonChangeTheme);
        boutonChangeTheme.addActionListener(e -> {
            try {
                if (themeSombre) {
                    themeSombre = false;
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } else {
                    themeSombre = true;
                    UIManager.setLookAndFeel(new FlatDarculaLaf());
                }
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                System.out.println("Failed to initialize Laf");
            }
        });
//-------------------------------------FERMETURE APPLI --------------------------------------
        bouton.addActionListener(e -> {
            Object[] choix = {"Oui", "Nope :("};
            int reponse = JOptionPane.showOptionDialog(this,
                    "Voulez vous fermer l'application ?",
                    "Confirmer",
                    JOptionPane.YES_NO_OPTION,
                    //        JOptionPane.QUESTION_MESSAGE, // image java normal
                    JOptionPane.QUESTION_MESSAGE, // image panneau stop java
                    null,
                    choix,
                    choix[0]);

            if (reponse == JOptionPane.YES_OPTION) {
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
//        panneau.add(bouton);
//        panneau.add(selectCivilite);
//        panneau.add(selectUtilisateur);
//        panneau.add(boutonFormulaire);
//        panneau.add(boutonChangeTheme);

// ----------------------------------création box--------------------------

        Box boxPrincipal = Box.createVerticalBox();
        panneau.add(boxPrincipal, BorderLayout.CENTER);

        Box boxMenu = Box.createHorizontalBox();
        boxMenu.add(bouton);
        boxMenu.add(boutonChangeTheme);
        boxPrincipal.add(boxMenu);


//avant la création de la class Champs
//        Box boxUtilisateur = Box.createHorizontalBox();
//        boxUtilisateur.setMaximumSize(new Dimension(500, 30));
//        boxUtilisateur.add(new JLabel("Civilite"));
//        boxUtilisateur.add(selectCivilite);
//        boxUtilisateur.add(selectUtilisateur);

//pour créer un espace entre les box
        boxPrincipal.add(Box.createRigidArea(new Dimension(1, 25)));
//      boxPrincipal.add(Champs.generate("Civilite ", selectCivilite, selectUtilisateur));
        boxPrincipal.add(Champs.generate("Civilite ", selectCivilite));
        boxPrincipal.add(Champs.generate("Utilisateurs ", selectUtilisateur));

        panneau.add(boutonFormulaire, BorderLayout.SOUTH);


        setVisible(true);
    }

        public static void main(String[] args) {
        FlatDarculaLaf.setup(); // version dark
//FlatLightLaf.setup();
        new Fenetre();
    }
}
