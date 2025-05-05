package gestionCommandes;

import java.sql.Date;

public class Commande {

    private int id;
    private Date dateCommande;
    private int qteCmd;
    private String designationProduit;
    private double prixPdt;

    // Constructeur de base
    public Commande(int id, Date dateCommande) {
        this.id = id;
        this.dateCommande = dateCommande;
    }

    // Nouveau constructeur
    public Commande(int qteCmd, String designationProduit, double prixPdt) {
        this.qteCmd = qteCmd;
        this.designationProduit = designationProduit;
        this.prixPdt = prixPdt;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getQteCmd() {
        return qteCmd;
    }

    public void setQteCmd(int qteCmd) {
        this.qteCmd = qteCmd;
    }

    public String getDesignationProduit() {
        return designationProduit;
    }

    public void setDesignationProduit(String designationProduit) {
        this.designationProduit = designationProduit;
    }

    public double getPrixPdt() {
        return prixPdt;
    }

    public void setPrixPdt(double prixPdt) {
        this.prixPdt = prixPdt;
    }

    @Override
    public String toString() {
        return "Commande n° " + id + " - Date: " + dateCommande;
    }
}