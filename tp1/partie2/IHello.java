import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IHello extends Remote {
    String sayHello(Personne p) throws RemoteException;
}
