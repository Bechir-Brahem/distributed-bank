import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IHello extends Remote {
    String sayHello() throws RemoteException;
}
