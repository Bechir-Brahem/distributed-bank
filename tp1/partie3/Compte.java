public class Compte implements java.io.Serializable{
    Compte(String mdp)
    {
        this.mdp=mdp;
        solde=0;
    }
    public String mdp;
    public int id;
    public int solde;
    public String nom;
    public String prenom;
    
}
