package gestionCommandes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class detailsCommande extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public detailsCommande(int idCommande) {
		setTitle("Détails Commande");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Commande n°" + idCommande);
		lblNewLabel.setBounds(10, 35, 242, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		// Autres éléments de l'interface
		JLabel lblNewLabel_1 = new JLabel("DESCRIPTION");
		lblNewLabel_1.setBounds(72, 81, 164, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("QTÉ");
		lblNewLabel_1_1.setBounds(259, 81, 26, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("UNITÉ");
		lblNewLabel_1_1_1.setBounds(295, 81, 37, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("MONTANT");
		lblNewLabel_1_1_1_1.setBounds(342, 81, 82, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 101, 414, 5);
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("Validé");
		btnNewButton_1.setBounds(125, 182, 83, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(Color.LIGHT_GRAY);
		panel_1_2_1.setBounds(10, 122, 46, 46);
		contentPane.add(panel_1_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Refusé");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(218, 182, 83, 23);
		contentPane.add(btnNewButton_1_1);
		
		GestionCommandes gestion = new GestionCommandes();
		Commande commandeDetails = gestion.detailsCommandeSelectionne(idCommande);
		
		JLabel lblNewLabel_1_2 = new JLabel(commandeDetails.getDesignationProduit());
		lblNewLabel_1_2.setBounds(72, 138, 164, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel(String.valueOf(commandeDetails.getQteCmd()));
		lblNewLabel_1_2_1_1_1.setBounds(259, 138, 15, 14);
		contentPane.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_2 = new JLabel(String.format("%.2f€", commandeDetails.getPrixPdt()));
		lblNewLabel_1_2_1_1_1_2.setBounds(295, 138, 37, 14);
		contentPane.add(lblNewLabel_1_2_1_1_1_2);
		
		double montantTotal = commandeDetails.getQteCmd() * commandeDetails.getPrixPdt();
		JLabel lblNewLabel_1_2_1_1_1_2_2 = new JLabel(String.format("%.2f€", montantTotal));
		lblNewLabel_1_2_1_1_1_2_2.setBounds(342, 138, 65, 14);
		contentPane.add(lblNewLabel_1_2_1_1_1_2_2);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					detailsCommande frame = new detailsCommande(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
