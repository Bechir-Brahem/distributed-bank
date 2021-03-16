import java.io.Serializable;
public class Personne implements Serializable{
    public int age;
    public String nom;
    public String prenom;
    public Personne(int age,String nom,String prenom)
    {
        this.age=age;
        this.nom=nom;
        this.prenom=prenom;
    }
}
