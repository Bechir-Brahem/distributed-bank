import java.util.*;
import java.rmi.Naming;
public class Client {
  
    private static boolean ouvrirInterface() {
        scan = new Scanner(System.in);
        System.out.println("bienvenue dans le systeme de la banque");
        System.out.println("Interface Client:");
        System.out.println("1:voir etat du compte");
        System.out.println("2:ajouter sur compte ");
        System.out.println("3:enlever sur compte");
        System.out.println("4:transfert entre compte\n");
        System.out.println("Interface de l'admin");
        System.out.println("5:get valeur du compte");
        System.out.println("6:set valeur du compte");
        System.out.println("7:creer un compte");
        System.out.println("8:afficher logs\n");
        System.out.println("0:fermer le programme");
        System.out.println("saisir le numero de l'operation: ");
        int choix=0;
        choix = scan.nextInt();
        

        

        switch (choix) {
        case 0:
      
            return false;
        case 1:
            etatCompte();
            break;

        case 2:
            ajouterCompte();
            break;
        case 3:
            enleverCompte();
            break;

        case 4:
            transfertCompte();
            break;

        case 5:
            getValeur();
            break;

        case 6:
            setValeur();
            break;

        case 7:
            creerCompte();
            break;
        case 8:
            afficherLogs();
            break;

        default:
            System.out.println("erreur saisir un nombre entre 1 et 8 \n");
            break;


        }
        
        return true;
    }
    public static void main(String[] args) {
        try {
            stub = (IBanque)Naming.lookup("rmi://localhost:1900" + "/Banque");
            boolean t = true;
            while (t) {
                t = (ouvrirInterface());
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
    public Client() {
    }
    private static Scanner scan;
    private static IBanque stub;
    private static void sep() {
        System.out.println("\n------------------------\n");
    }
    private static int saisirID() {

        System.out.println("saisir l'ID de votre compte: ");
 
        return scan.nextInt();
        
    }

    private static String saisirMdp() {
        
        System.out.println("saisir le mdp de votre compte: ");
      
        return scan.next();

    }
    private static int saisirMontant() {

        System.out.println("saisir le montant: ");
     
        return scan.nextInt();
    }

    private static void creerCompte() {

        System.out.println("saisir le mdp de l'admin: ");
  
        String mdpAdmin = scan.next();
        System.out.println("saisir un mot de passe pour votre compte: ");
        String mdpCompte = scan.next();
        System.out.println("saisir votre nom: ");
        String nom = scan.next();
        System.out.println("saisir prenom: ");
        String prenom = scan.next();
        try {
            String ret = stub.creerCompte(mdpAdmin, mdpCompte, nom, prenom);
            sep();
            System.out.println(ret);
            sep();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }





    }

    private static void etatCompte() {


        System.out.println("saisir l'ID de votre compte: ");
        int id = scan.nextInt();


        System.out.println("saisir un mot de passe pour votre compte:");
        String mdp = scan.next();
        try {
            String ret = stub.etatCompte(id, mdp);
            sep();
            System.out.println(ret);
            sep();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
    private static void ajouterCompte() {
        int id = saisirID();
        String mdp = saisirMdp();

        int montant = saisirMontant();
        try {
            sep();
            System.out.println(stub.ajouterSurCompte(id, mdp, montant));
            sep();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }
    private static void enleverCompte() {
        int id = saisirID();
        String mdp = saisirMdp();
        int montant = saisirMontant();
        try {
            sep();
            System.out.println(stub.enleverSurCompte(id, mdp, montant));
            sep();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }
    private static void transfertCompte() {
  

        int id = saisirID();
        String mdpCompte = saisirMdp();
        int montant = saisirMontant();
        System.out.println("Saisir l'id du recipient: ");
        int idVers = scan.nextInt();
        try {
            sep();
            System.out.println(stub.transfertEntreCompte(id, mdpCompte, montant, idVers));
            sep();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }

    private static void getValeur() {
        System.out.println("saisir le mdp de l'admin: ");

        String mdpAdmin = scan.next();
        int id = saisirID();
        try {
            sep();
            System.out.println(stub.getValeur(id, mdpAdmin));
            sep();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
   

    }
    private static void setValeur() {
        System.out.println("saisir le mdp de l'admin: ");
    
        String mdpAdmin = scan.next();
        int id = saisirID();
        int montant = saisirMontant();
        try {
            sep();
            System.out.println(stub.setValeur(id, mdpAdmin, montant));
            sep();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
     
    }
    private static void afficherLogs() {
        System.out.println("saisir le mdp de l'admin: ");

        String mdpAdmin = scan.next();
        sep();
        try {
            System.out.println(stub.afficheLog(mdpAdmin));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

        sep();

    }


}
