import java.io.*;
public class Personne implements Externalizable {
    private String nom = "";
    private String prenom = "";
    private int taille = 0;
    public Compte com;
    public Personne() {}
    public Personne(String nom, String prenom, int taille) {
        this.nom = nom;
        this.taille = taille;
        this.prenom = prenom;
        com = new Compte("insat", 33);

    }
    public void writeExternal(ObjectOutput out)
    throws IOException {
        out.writeObject(nom);
        out.writeInt(taille);
        out.writeObject(prenom);
        out.writeObject(com);
    }

    public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException {
        nom = (String)in.readObject();
        taille = in.readInt();
        prenom = (String)in.readObject();
        com = (Compte)in.readObject();
    }

    public String toString() {
        return ("Nom: " + nom + "\n"
                + "taille: " + taille + "\n"
                + "prenom: " + prenom );
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
