import java.rmi.registry.*;
import java.rmi.*;

public class ServeurBanque {
    public ServeurBanque() {
        //
    }
    public static void main(String args[]) {
        try {
            Banque objDistant = new Banque("admin");
            //IBanque stub = (IBanque) UnicastRemoteObject.exportObject(objDistant, 0);
            //Registry registry = LocateRegistry.getRegistry();
            LocateRegistry.createRegistry(1900); 
            //registry.bind("Banque", stub);
            Naming.rebind("rmi://localhost:1900"+"/Banque",objDistant); 
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
