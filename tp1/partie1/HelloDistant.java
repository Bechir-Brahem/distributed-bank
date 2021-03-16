import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class HelloDistant implements IHello {
    public HelloDistant() {}
    public String sayHello() {
        return "Hello, world!";
    }
}
