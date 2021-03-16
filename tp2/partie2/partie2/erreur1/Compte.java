
import java.io.Serializable;

public class Compte {
    public int id;
    public Address ad;
    public Compte(String pp,int id)
    {
        ad=new Address(pp);
        this.id=id;
    }
    
}
