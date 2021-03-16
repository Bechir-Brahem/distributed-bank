import java.io.Serializable;

public class CompteBancaire implements Serializable{
    public String name;
    public Address adr;
    public CompteBancaire(String name){
        this.name = name;
        this.adr = new Address("rmi");
    };    
}
