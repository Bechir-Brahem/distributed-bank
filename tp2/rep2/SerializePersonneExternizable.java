import java.io.*; 
public class  SerializePersonneExternizable { 
      public static void main(String argv[]) {
          PersonneExternalizable personne = new PersonneExternalizable("dupond","jeans",175);
        try {
            FileOutputStream fo
                = new FileOutputStream("gfg.txt");
            ObjectOutputStream so
                = new ObjectOutputStream(fo);
            so.writeObject(personne);
            so.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }
   }
}
