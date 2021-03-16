import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
public class ServeurHello {
    public ServeurHello() {}
    public static void main(String args[]) {
        try {
            HelloDistant objDistant = new HelloDistant();
            IHello stub = (IHello) UnicastRemoteObject.exportObject(objDistant, 0);
// Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
