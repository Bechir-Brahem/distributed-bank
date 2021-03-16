import java.io.*;

public class DeSerializerPersonne {
    public static void main(String argv[]) {
        try {
            Personne perso;
            FileInputStream fi = new FileInputStream("gfg.txt");
            ObjectInputStream si = new ObjectInputStream(fi);
            perso = (Personne)si.readObject();
            System.out.println("nom: "+perso.getNom());
            System.out.println("prenom: "+perso.getPrenom());
            System.out.println("taille: "+perso.getTaille());
            System.out.println("compte: "+perso.com.info());

        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
