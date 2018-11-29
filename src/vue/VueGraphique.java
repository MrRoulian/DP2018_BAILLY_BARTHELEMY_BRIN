package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controler.BoutonSelectionBateau;
import controler.BoutonTir;
import modele.InterfacePartie;
import modele.Joueur;
import modele.Partie;

public class VueGraphique implements Serializable {


	private JFrame frame = new JFrame("Bataille Navale");
	//panel 0 contient les 3 autres panel
	//panel 1 contient grid du joueur
	//panel 2 contient grid de l'adversaire
	//panel 3 panel du milieu avec les controles
	private JPanel[] panels = new JPanel[4];
	private TextField tf;
	private int taille;
	private Joueur joueur, adversaire;
	private int numDansLeauJoueur;
	private int numDansLeauAdversaire;
	private InterfacePartie iPartie;

	public VueGraphique(Joueur joueur, Joueur adversaire, InterfacePartie iPartie) {
		this.joueur = joueur;
		this.adversaire = adversaire;
		this.numDansLeauJoueur = joueur.getGrille().getNumDansLeau();
		this.numDansLeauAdversaire = adversaire.getGrille().getNumDansLeau();
		this.iPartie = iPartie;
		buildFrame();
	}

	public void buildFrame() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialize panels 
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
		}

		taille = joueur.getTailleGrid();
		
		panels[0].setLayout(new GridLayout(1, 2));

		JButton bouton;
		panels[1].setLayout(new GridLayout(taille, taille));
		for (int i = 0 ; i < taille ; i++){
			for (int j = 0 ; j < taille ; j++){
				bouton = new JButton();
				bouton.setForeground(Color.WHITE);
				bouton.setText(joueur.getGrille().getCase(j, i)+"");
				bouton.addActionListener(new BoutonSelectionBateau(Integer.parseInt(bouton.getText()), joueur));
				panels[1].add(bouton);
			}
		}

		panels[2].setLayout(new GridLayout(taille, taille));
		for (int i = 0 ; i < taille ; i++){
			for (int j = 0 ; j < taille ; j++){
				bouton = new JButton();
				bouton.setForeground(Color.WHITE);
				bouton.addActionListener(new BoutonTir(j, i, iPartie, joueur));
				panels[2].add(bouton);
			}
		}
		
		panels[3].setPreferredSize(new Dimension(100, 50));
		panels[3].setLayout(new GridLayout(2, 2));
		tf = new java.awt.TextField("Cliquer sur un bateau pour le sélectionner");
		panels[3].add(tf);
		
		panels[0].add(panels[1]);
		panels[0].add(panels[3]);
		panels[0].add(panels[2]);
		
		frame.add(panels[0]);

		frame.pack();
		frame.setVisible(true);
		
		this.update();
	}
	
	public void updateJoueur(Joueur j1, Joueur j2){
		if (joueur.equals(j1)){
			joueur=j1;
			adversaire=j2;
		} else {
			joueur=j2;
			adversaire=j1;
		}
	}

	public void update() {
		int compteur = 0;
		int x=0,y=0,val;
		
		for(Component child: panels[1].getComponents()){
			JButton bt = (JButton)child;			
			x=compteur%taille;
			y=compteur/taille;
			val = joueur.getGrille().getCase(x, y);

			bt.setText(val+"");
			
			if (val < 0){				
				if (val == numDansLeauJoueur){
					bt.setBackground(Color.RED);	
				} else {	
					bt.setBackground(new Color(139,0,0));			
				}
			} else if (val > 0){
				bt.setBackground(Color.BLACK);				
			} else {
				bt.setBackground(new Color(56, 27, 232));				
			}	
			
			compteur++;
		}
		
		compteur = 0;
		
		for(Component child: panels[2].getComponents()){
			JButton bt = (JButton)child;			
			x=compteur%taille;
			y=compteur/taille;
			val = adversaire.getGrille().getCase(x, y);

			
			if (val < 0){
				bt.setText(val+"");				
				if (val == numDansLeauAdversaire){
					bt.setBackground(Color.RED);	
				} else {		
					bt.setBackground(new Color(139,0,0));		
				}			
			} else {
				bt.setText("0");
				bt.setBackground(new Color(56, 27, 232));				
			}
			
			compteur++;
		}	
		
		String txt;
		if (joueur.getNumBateauSelectionne() != 0){
			txt = "Bateau "+joueur.getNumBateauSelectionne()+" selectionné, "+joueur.getGrille().getBateau(joueur.getNumBateauSelectionne()-1).toString()+"\n";
			if (joueur.getGrille().getBateau(joueur.getNumBateauSelectionne()-1).estCoulé()){
				txt += "Le bateau est coulé il ne pourra pas tirer !";
			}
			tf.setText(txt);			
		} else {
			tf.setText("Cliquer sur un bateau pour le sélectionner");
		}
	}

}
