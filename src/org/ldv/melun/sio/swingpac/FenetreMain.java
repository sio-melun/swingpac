package org.ldv.melun.sio.swingpac;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.ldv.melun.sio.swingpac.utils.PackageUtil;

/**
 * Définition de la scene du jeu et instanciation des objets. 
 * @author lycée Léonard de Vinci - Melun - SIO-SLAM
 */
public class FenetreMain extends JFrame implements ActionListener {
  // une constante (mot clé final)
  // c'est un moyen très pratique d'associer un écouteur d'événement
  // à un générateur d'événement.
	
  static final String ACTION_QUITTER = "Quitter";
  static final String ACTION_GO = "Go";
  static final String ACTION_STOP = "Stop";
  static final String ACTION_RESTART = "Restart";
  
  

  private static final String PACKAGE_BIDULES = "org.ldv.melun.sio.swingpac.etudiants";
  private static final int TAILLE_BIDULE = 30;

  // constructeur
  public FenetreMain() {
    // appel un constructeur de son parent
    super("SwingPac");
    // effet : donne un titre à la fenêtre

    // l'application s'arrête lorsque cette fenêtre sera fermée.
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // pas de gestionnaire de positionnement
    setLayout(null);

    // initialisation de la fenêtre
    init();
  }

  private void init() {
    // on a besoin de créer une barre de menus
    JMenuBar menuBar;
    // et un menu
    JMenu menuFichier;

    // création dela barre de menus
    menuBar = new JMenuBar();
    // construisons le premier menu
    menuFichier = new JMenu("Fichier");
    menuFichier.setMnemonic(KeyEvent.VK_F);
    menuFichier.getAccessibleContext().setAccessibleDescription(
        "Menu permettant d'accéder à une commande pour quitter");

    // création de la commande "quitter"
    JMenuItem mnItemQuitter = new JMenuItem(ACTION_QUITTER, KeyEvent.VK_Q);
    mnItemQuitter.getAccessibleContext().setAccessibleDescription(
        "Quitter le programme");

    // mnItemQuitter.setActionCommand(ACTION_QUITTER);

    // le menu Fichier contient la commande Quitter
    menuFichier.add(mnItemQuitter);
    // menu.addSeparator();
    // la barre de menus contient le menu Fichier
    menuBar.add(menuFichier);
    JMenu jeu = new JMenu("Jeu");
    jeu.setMnemonic(KeyEvent.VK_J);
    JMenuItem bouton_go = new JMenuItem("go", KeyEvent.VK_G);
    bouton_go.setActionCommand(ACTION_GO);
    // l'instance de cette fenêtre est à l'écoute d'une action sur ce menu
    bouton_go.addActionListener(this);
    jeu.add(bouton_go);
    
    JMenuItem bouton_stop = new JMenuItem("stop", KeyEvent.VK_S);
    bouton_stop.setActionCommand(ACTION_STOP);
    bouton_stop.addActionListener(this);
    jeu.add(bouton_stop);
    
    JMenuItem bouton_restart = new JMenuItem("restart", KeyEvent.VK_R);
    bouton_restart.setActionCommand(ACTION_RESTART);
    bouton_restart.addActionListener(this);
    jeu.add(bouton_restart);
    
    menuBar.add(jeu);


    // on ajoute la barre de menu à la fenêtre
    setJMenuBar(menuBar);

    // l'instance de cette fenêtre est à l'écoute d'une action sur ce menu
    mnItemQuitter.addActionListener(this);

    Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int hauteur = (int)tailleEcran.getHeight();
    int largeur = (int)tailleEcran.getWidth();
    if (largeur>1500){
    	setSize(largeur/4, hauteur/4);
    }
    else {
    	setSize(largeur/3, hauteur/3);
    }

  }

  /**
   * Injecte des objets Bidule dans cette instance de fenêtre
   */
  private void go() {
    // récupère la liste des classes du package en question
    String[] classes = PackageUtil.getClasses(PACKAGE_BIDULES);
    List<String> classesShuffles = Arrays.asList(classes);
    
    // change l'ordre des éléments dans le tableau
    Collections.shuffle(classesShuffles);
    System.out.println(classesShuffles);
    
    // on instancie les classes (un objet par class)
    // et l'ajoute à la scene (fenetre)
    String erreurs = "";
    for (int i = 0; i < classesShuffles.size(); i++) {
      try {
        Bidule bidule = (Bidule) Class.forName(
            PACKAGE_BIDULES + "." + classesShuffles.get(i)).newInstance();
        bidule.setLocation(20 + i * TAILLE_BIDULE, +i * TAILLE_BIDULE);

        // ajout l'objet à la fenêtre
        this.add(bidule);
        System.out.println(bidule.toString());
      } catch (Exception e) {
        erreurs = e.getMessage();
      }
    }
    if (!"".equals(erreurs))
      JOptionPane.showMessageDialog(null, erreurs);
  }

  private void stop(){
	  List<Bidule> bidulesPresent = new ArrayList<Bidule>();
	  for (Component obj: this.getContentPane().getComponents()){
		  if (obj instanceof Bidule && obj != this){
			  bidulesPresent.add((Bidule) obj);
		  }
	  }
	  for (Bidule bidules : bidulesPresent){
		  bidules.stop();
	  }
  }

  private void restart(){
	  List<Bidule> bidulesPresent = new ArrayList<Bidule>();
	  for (Component obj: this.getContentPane().getComponents()){
		  if (obj instanceof Bidule && obj != this){
			  bidulesPresent.add((Bidule) obj);
		  }
	  }
	  for (Bidule bidules : bidulesPresent){
		  bidules.start();
	  }
  }
  
  /**
   * Appelé par les commandes du menu
   */
  public void actionPerformed(ActionEvent evt) {
    String action = evt.getActionCommand();

    if (action.equals(ACTION_QUITTER)) {
      System.exit(0);
    } else if (action.equals(ACTION_GO)) {
      go();
    }else if (action.equals(ACTION_STOP)){
    	stop();
    } else if (action.equals(ACTION_RESTART)){
    	restart();
    }
  }

}// FentreMain
