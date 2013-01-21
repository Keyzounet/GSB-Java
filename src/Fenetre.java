import javax.swing.*;

import com.mysql.jdbc.EscapeTokenizer;

import java.awt.*;
import java.awt.event.* ;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fenetre extends JFrame implements ActionListener {

	private JPanel panel ;
	private JPanel panel2 ;
	private JLabel labelLogin ;
	private JTextField jtfLogin ;
	private JLabel labelMdp ;
	private JTextField jtfMdp ;
	private JButton btnClicValider ;


	public Fenetre(){
		this.panel = new JPanel ();
		this.panel2 = new JPanel ();
		this.labelLogin = new JLabel("Login : ");
		this.jtfLogin = new JTextField();
		this.labelMdp = new JLabel("Mot de passe : ");
		this.jtfMdp = new JTextField();
		this.btnClicValider = new JButton("Se connecter") ;


		this.setTitle("Laboratoire Galaxy-Swiss Bourdin : Gestion des Fiches Visiteurs"); //Titre la fenetre

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermer la fenetre


		this.setSize(550,272); // Ajuste la taille
		//this.pack(); // Ajuste la taille de la fenetre automatiquement

		this.setLocationRelativeTo(null); // centre la fenetre
		//this.setLocation(200,200); // positionne la fenetre

		this.panel.setBackground(Color.gray);
		this.getContentPane().add(panel);
		this.panel.add(panel2);
		this.panel.setLayout(new GridLayout(3,2));
		this.panel2.add(labelLogin);
		this.panel2.add(jtfLogin);
		this.panel2.add(labelMdp);
		this.panel2.add(jtfMdp);
		this.panel2.add(btnClicValider);
		this.jtfLogin.setPreferredSize(new Dimension(150, 25));
		this.jtfMdp.setPreferredSize(new Dimension(150, 25));
		this.btnClicValider.addActionListener(this);


		this.setVisible(true); //rend visible la fenetre
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		if (click.getSource() == btnClicValider) {

			System.out.println(PasserelleBDD.seConnecter(jtfLogin.getText(), jtfMdp.getText()));
			if (PasserelleBDD.estConnecte()) {
				//ouverture de la nouvelle fenetre
			}
			else {
				JOptionPane.showMessageDialog(null, "Vos identifiants sont incorrects !",
						"Erreur de Connexion",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else 
			System.out.println("ERREUR");


	}
	
	public void changerPanneau(int panneau) {
		
	}

}
