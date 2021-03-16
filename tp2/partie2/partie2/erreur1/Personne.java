import java.io.Serializable;
public class Personne implements Serializable{ 
    private String nom = "";
    private String prenom = "";
    private int taille = 0;
    public Compte com;
    public Personne(String nom, String prenom, int taille) {
        this.nom = nom;
        this.taille = taille;
        this.prenom = prenom;
        com=new Compte("insat",33);

    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getTaille() {
        return taille;
    }
    public void setTaille(int taille) {
        this.taille = taille;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
