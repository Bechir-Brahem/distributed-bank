import java.io.Serializable;
public class Address implements Serializable{
    public String boo;
    public Personne pp;

    public Address(String A)
    {
        boo=A;
        pp=new Personne("x", "y", 29);
    }

}
