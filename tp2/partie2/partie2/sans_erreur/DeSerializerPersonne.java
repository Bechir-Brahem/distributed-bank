import java.io.*;

public class DeSerializerPersonne {
    public static void main(String argv[]) {
        try {
            FileInputStream fichier = new FileInputStream("personne.ser");
            ObjectInputStream ois = new ObjectInputStream(fichier);
            Personne personne = (Personne) ois.readObject();
            System.out.println("Personne : ");
            System.out.println("nom : " + personne.getNom());
            System.out.println("prenom : " + personne.getPrenom());
            System.out.println("taille : " + personne.getTaille());
            System.out.println("id du compte: "+personne.com.id+"\nadresse du compte: "+personne.com.ad.boo);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
