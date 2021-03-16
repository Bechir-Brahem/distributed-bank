import java.io.*;

public class DeSerializePersonneExternalizable {
    public static void main(String argv[]) {
        PersonneExternalizable personne;
        try {
            FileInputStream fi
                = new FileInputStream("gfg.txt");
            ObjectInputStream si
                = new ObjectInputStream(fi);
            personne  = (PersonneExternalizable)si.readObject();
        System.out.println("name " + personne.getNom());
        System.out.println("taill " + personne.getTaille());
        System.out.println("prenom " + personne.getPrenom());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
