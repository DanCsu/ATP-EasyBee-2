package gestionCommandes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class listeCommandes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private GestionCommandes gestionCommandes;

    public listeCommandes() {
        gestionCommandes = new GestionCommandes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Liste des commandes");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(165, 0, 150, 30);
        contentPane.add(lblNewLabel_2);

        JComboBox<Commande> comboBoxCommandes = new JComboBox<>();
        comboBoxCommandes.setBounds(10, 59, 464, 30);
        contentPane.add(comboBoxCommandes);

        chargerCommandes(comboBoxCommandes);

        JButton btnDetails = new JButton("Détails");
        btnDetails.setBounds(10, 100, 120, 30);
        contentPane.add(btnDetails);

        btnDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Commande selectedCommande = (Commande) comboBoxCommandes.getSelectedItem();
                if (selectedCommande != null) {
                    int idCommande = selectedCommande.getId();

                    detailsCommande details = new detailsCommande(idCommande);
                    details.setVisible(true);

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner une commande.");
                }
            }
        });
    }

    private void chargerCommandes(JComboBox<Commande> comboBoxCommandes) {
        List<Commande> commandes = gestionCommandes.getAllCommandes();

        // Vérification des commandes
        if (commandes.isEmpty()) {
            comboBoxCommandes.addItem(null); // Affiche "Aucune commande disponible" si aucune commande n'est trouvé
        } else {
            for (Commande commande : commandes) {
                comboBoxCommandes.addItem(commande);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    listeCommandes frame = new listeCommandes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
