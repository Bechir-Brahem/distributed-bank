import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.IOException;
public interface IBanque extends Remote {
    public String etatCompte(int id, String mdp) throws RemoteException, IOException ;
    public String ajouterSurCompte(int id, String mdp, int montant) throws RemoteException, IOException ;
    public String enleverSurCompte(int id, String mdp, int montant) throws RemoteException, IOException ;
    public String creerCompte(String mdpAdmin, String mdpCompte, String nom, String prenom)throws RemoteException, IOException;
    public String  transfertEntreCompte(int id, String mdpCompte, int montant, int id2) throws  RemoteException, IOException ;
    public String getValeur(int id, String mdp) throws RemoteException, IOException ;
    public String setValeur(int id, String mdp, int solde) throws RemoteException, IOException ;
    public String afficheLog(String mdp) throws RemoteException, IOException;

    // public String afficheLesComptes(String mdp) ;

}
