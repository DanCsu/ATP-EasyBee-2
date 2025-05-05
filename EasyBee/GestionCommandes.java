package gestionCommandes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionCommandes {
	
	connexionBdd cn = connexionBdd.getInstance();

    public List<Commande> getAllCommandes() {
    	
        List<Commande> commandes = new ArrayList<>();

        String sql = "select id, dateCommande from cmdapprodepot"; 
        try (PreparedStatement stmt = cn.laconnexion().prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	int id = rs.getInt("id");
                Date dateCommande = rs.getDate("dateCommande");
                commandes.add(new Commande(id, dateCommande));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return commandes;
    }
    
    public Commande detailsCommandeSelectionne(int idRechercher) {

    	String sql = "select qteCmd, designationProduit, prixPdt from detailsproduit join cmdapprodepot on idCommande = cmdapprodepot.id join produit on idproduit = produit.id WHERE idCommande = ?";
    	try (PreparedStatement stmt = cn.laconnexion().prepareStatement(sql)){
    		stmt.setInt(1, idRechercher);
    		ResultSet rs = stmt.executeQuery();
    		if (rs.next()) {
                int qteCmd = rs.getInt("qteCmd");
                String designationProduit = rs.getString("designationProduit");
                double prixPdt = rs.getDouble("prixPdt");
                return new Commande(qteCmd, designationProduit, prixPdt);
            }
    	} catch (SQLException e) {
    	   e.printStackTrace();
    	}
    	return null;
    }
}
