package gestionCommandes;

import java.sql.Connection;
import java.sql.DriverManager;

// Singleton
public class connexionBdd {

    private static connexionBdd instance;
    Connection con;

    private connexionBdd() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/projet_pro","root","");
            System.out.println("connexion reussie");
        }
        catch(Exception ex) {
            System.out.println(" ERREUR | Problème de connexion à la base de données : " + ex.getMessage());
        }
    }

    public static connexionBdd getInstance() {
        if (instance == null) {
            synchronized (connexionBdd.class) { // Synchronisation pour éviter les conflits en multi-threading
                if (instance == null) {
                    instance = new connexionBdd();
                }
            }
        }
        return instance;
    }

    public Connection laconnexion() {
        return con;
    }
}