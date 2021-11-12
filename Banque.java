import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.rmi.server.*;
import java.rmi.RemoteException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
public class Banque extends UnicastRemoteObject implements IBanque {
    Banque(String mdp) throws RemoteException, IOException {
        super(1099);
        //je dois savoir ce port pour l'ouvrir dans le NAT (pour rendre el serveur accessible par internet)
        this.mdp = mdp;
        this.lastId = 0;
        myWriter = new FileWriter("server.logs");
        helperWrite(dtf.format(now) + " server created");
        System.out.println(dtf.format(now) + " server created");


    }

    public String  etatCompte(int id, String mdp) throws IOException {
        helperWrite(dtf.format(now) + "invocation de etatCompte avec ID " + id);
        if (id < 0 || id >= lastId) {
            helperWrite("ID incorrecte");
            return "erreur: ID incorrecte";
        }
        if (!liste.get(id).mdp.equals(mdp)) {
            helperWrite("mdp faux");
            return "Compte: " + erreur + "\n";
        }
        helperWrite("succès");
        return "compte de " + liste.get(id).nom + " " + liste.get(id).prenom + " ID: " + id + "\nvotre solde est " + liste.get(id).solde;
    }
    public String ajouterSurCompte(int id, String mdp, int montant)  throws IOException {
        helperWrite(dtf.format(now) + "invocation de ajouterSurCompte avec ID " + id + " et montant: " + montant);

        if (id < 0 || id >= lastId) {
            helperWrite("ID incorrecte");
            return "erreur: ID incorrecte";
        }
        if (!liste.get(id).mdp.equals(mdp)) {
            helperWrite("mdp faux");
            return "compte: " + erreur;
        }
        liste.get(id).solde += montant;
        helperWrite(" montant: " + montant + " montant ajouté");
        return "succès";
    }
    public String  enleverSurCompte(int id, String mdpCompte, int montant)  throws IOException {
        helperWrite(dtf.format(now) + "invocation de enleverSurCompte avec ID " + id + " et montant: " + montant);
        if (id < 0 || id >= lastId) {
            helperWrite("ID incorrecte");
            return "erreur: ID incorrecte";
        }
        if (!liste.get(id).mdp.equals(mdpCompte)) {
            helperWrite("mdp faux");
            return erreur;
        }
        if (montant <= 0) {
            helperWrite("montant negatif");
            return "montant negatif";
        }
        if (liste.get(id).solde <= montant) {
            helperWrite("solde insufisant");
            return "solde insufisant";
        }
        helperWrite(" montant: " + montant + " montant enlevé");

        helperWrite("succès montant enlevé " + montant);
        liste.get(id).solde -= montant;
        return "succès";
    }

    public String creerCompte(String mdp, String mdpCompte, String nom, String prenom)  throws IOException {
        helperWrite(dtf.format(now) + " invocation de creerCompte: nom: " + nom + " prenom: " + prenom);

        if (!this.mdp.equals(mdp)) {
            helperWrite("mdp incorrect");
            return "Admin: " + erreur;
        } else {

            Compte tmpCompte = new Compte(mdpCompte);
            tmpCompte.id = lastId;
            tmpCompte.mdp = mdpCompte;
            tmpCompte.nom = nom;
            tmpCompte.prenom = prenom;
            lastId++;
            liste.add(tmpCompte);
            helperWrite(dtf.format(now) + "compte créé avec ID: " + (lastId - 1));
            return "succès l'ID de votre compte est " + (lastId - 1) + " compte de " + nom + " " + prenom;
        }
    }


    public String transfertEntreCompte(int id, String mdpCompte, int montant, int idVers)  throws IOException {
        helperWrite(dtf.format(now) + "invocation de transfert Entre Compte: \n" +
                    "ID: " + id + " montant: " + montant + " destination " + idVers);
        if (id < 0 || id >= lastId) {
            helperWrite("ID incorrecte");
            return "erreur: ID incorrecte";
        }
        if (!liste.get(id).mdp.equals(mdpCompte)) {
            helperWrite("mdp incorrect");
            return erreur;
        }
        if (montant <= 0) {
            helperWrite("montant negatif");
            return "montant negatif";
        }

        if (liste.get(id).solde <= montant) {
            helperWrite("solde insufisant");
            return "solde insufisant";
        }
        liste.get(id).solde -= montant;
        liste.get(idVers).solde += montant;
        helperWrite("succès");
        return "succès";
    }

    public String getValeur(int id, String mdp) throws IOException  {
        helperWrite(dtf.format(now) + " invocation de get valeur: ID: " + id);
        if (id < 0 || id >= lastId) {
            helperWrite("ID in correcte");
            return "erreur: ID incorrecte";
        }
        if (!this.mdp.equals(mdp)) {
            helperWrite("mdp incorrect");
            return "Admin: " + erreur;
        }
        helperWrite("succès");

        return "solde: " + liste.get(id).solde ;
    }
    public String setValeur(int id, String mdp, int solde)  throws IOException {
        helperWrite(dtf.format(now) + " invocation de setValeur: ID: " + id + " avec solde " + solde);
        if (id < 0 || id >= lastId) {
            helperWrite("ID in correcte");

            return "erreur: ID incorrecte";
        }
        if (!this.mdp.equals(mdp)) {
            helperWrite("mdp incorrect");

            return "Admin: " + erreur;
        }
        liste.get(id).solde = solde;
        helperWrite("succès");

        return "succès";
    }
    public String afficheLog(String adminMdp) throws IOException {
        helperWrite(" invocation de affiche Log");
        if (!this.mdp.equals(adminMdp)) {
            helperWrite("mdp incorrect");
            return "Admin: " + erreur;
        }

        File file = new File("server.logs");
        try {
            Scanner sc = new Scanner(file);
            String s = "";

            while (sc.hasNextLine())
                s += sc.nextLine() + "\n";
            sc.close();
            return s;
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
            return "server error";
        }



    }


    private final String erreur = "mot de passe erroné";
    transient private String mdp;
    transient private int lastId;
    transient private FileWriter myWriter;
    transient DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    transient LocalDateTime now = LocalDateTime.now();
    private ArrayList<Compte> liste = new ArrayList<Compte>();
    private void helperWrite(String s)throws IOException {
        myWriter.write(s + "\n");
        myWriter.flush();
        return ;
    }

}
