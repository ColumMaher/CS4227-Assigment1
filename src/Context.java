import java.util.List;

public class Context {
    private Customer customer;
    private Movie movie;


    public Context(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List getCustomerRentals(){
        return customer.getRentals();
    }
}
