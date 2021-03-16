import java.io.Serializable;

public class Compte implements Serializable{
    public int id;
    public Address ad;
    public Compte(String pp,int id)
    {
        ad=new Address(pp);
        this.id=id;
    }
    public String info()
    {
        return "id: "+id+" "+" Address: "+ad.boo;
    }
    
}
