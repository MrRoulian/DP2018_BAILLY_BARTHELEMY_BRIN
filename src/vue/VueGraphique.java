package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controler.BoutonSelectionBateau;
import controler.BoutonTir;
import javafx.scene.control.TextField;
import modele.Joueur;
import modele.Partie;

public class VueGraphique implements Observer {

	private Partie partie;

	private JFrame frame = new JFrame("Bataille Navale");
	//panel 0 contient les 3 autres panel
	//panel 1 contient grid du joueur
	//panel 2 contient grid de l'adversaire
	//panel 3 panel du milieu avec les controles
	private JPanel[] panels = new JPanel[4];
	private int taille;
	private Joueur j1,j2;

	public VueGraphique(Partie p) {
		partie = p;
		buildFrame();
	}

	public void buildFrame() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialize panels 
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
		}

		taille = partie.getJoueur1().getTailleGrid();
		j1 = partie.getJoueur1();
		j2 = partie.getJoueur2();
		
		panels[0].setLayout(new GridLayout(1, 2));

		JButton bouton;
		panels[1].setLayout(new GridLayout(taille, taille));
		for (int i = 0 ; i < taille ; i++){
			for (int j = 0 ; j < taille ; j++){
				bouton = new JButton();
				bouton.setForeground(Color.WHITE);
				bouton.setText(j1.getGrille().getCase(j, i)+"");
				bouton.addActionListener(new BoutonSelectionBateau(Integer.parseInt(bouton.getText()), partie));
				panels[1].add(bouton);
			}
		}

		panels[2].setLayout(new GridLayout(taille, taille));
		for (int i = 0 ; i < taille ; i++){
			for (int j = 0 ; j < taille ; j++){
				bouton = new JButton();
				bouton.setForeground(Color.WHITE);
				bouton.addActionListener(new BoutonTir(j, i, partie));
				panels[2].add(bouton);
			}
		}
		
		panels[3].setPreferredSize(new Dimension(100, 50));
		panels[3].setLayout(new GridLayout(2, 2));
		panels[3].add(new java.awt.TextField("Choisir un bateau pour tirer, il suffit de cliquer dessus"));
		
		
		panels[0].add(panels[1]);
		panels[0].add(panels[3]);
		panels[0].add(panels[2]);
		
		frame.add(panels[0]);

		frame.pack();
		frame.setVisible(true);
		
		this.update(null, null);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int compteur = 0;
		int x=0,y=0,val;
		
		for(Component child: panels[1].getComponents()){
			JButton bt = (JButton)child;			
			x=compteur%taille;
			y=compteur/taille;
			val = j1.getGrille().getCase(x, y);

			bt.setText(val+"");
			
			if (val < 0){
				bt.setBackground(Color.RED);
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
			val = j2.getGrille().getCase(x, y);

			
			if (val < 0){
				bt.setText(val+"");
				bt.setBackground(Color.RED);			
			} else {
				bt.setText("0");
				bt.setBackground(new Color(56, 27, 232));				
			}			
			
			compteur++;
		}



	}

}
