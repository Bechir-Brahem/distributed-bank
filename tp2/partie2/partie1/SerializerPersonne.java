import java.io.*;
public class SerializerPersonne {
    public static void main(String argv[]) {
        Etudiant personne = new Etudiant("Dupond", "Jean", 175,3);
        try {
            FileOutputStream fichier = new FileOutputStream("personne.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fichier);
            oos.writeObject(personne);
            oos.flush();
            oos.close();
        }

        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

