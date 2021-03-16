import java.io.*;
public class SerializerPersonne {
    public static void main(String argv[]) {
        Personne personne = new Personne("Dupond", "Jean", 175);
        try {
            FileOutputStream fo = new FileOutputStream("gfg.txt");
            ObjectOutputStream so = new ObjectOutputStream(fo);
            so.writeObject(personne);
            so.flush();
        }

        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
