package ModelLayer;

public class Info {

    public Prices prices;
    public Sender sender;
    public Receiver receiver;
    public Tenant tenant_1, tenant_2, tenant_3, tenant_4;

    public Info(Prices prices, Sender sender, Receiver receiver, Tenant tenant_1, Tenant tenant_2, Tenant tenant_3, Tenant tenant_4){
        this.prices = prices;
        this.sender = sender;
        this.receiver = receiver;
        this.tenant_1 = tenant_1;
        this.tenant_2 = tenant_2;
        this.tenant_3 = tenant_3;
        this.tenant_4 = tenant_4;
    }
}
