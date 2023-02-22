import java.util.List;

public class Context {
    private Customer customer;
    public Context(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<Rental> getCustomerRentals(){
        return customer.getRentals();
    }
}
