package ModelLayer;

public abstract class BusinessPerson extends Person {

    public String address, invoice, info;

    public BusinessPerson(String name, String address, String invoice, String info){
        super(name);
        this.address = address;
        this.invoice = invoice;
        this.info=info;
    }
}