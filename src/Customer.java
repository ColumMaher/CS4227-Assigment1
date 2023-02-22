import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals;

    Context context;
    Dispatcher dispatcher;
    Logger logger;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<Rental>();
        //Call setup interceptor
        setupInterceptor();
    }

    public void addRental(Rental rental) {
        if (! rentals.contains(rental)) rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String getName() {
        return name;
    }
    public String statement() {
        double amount = 0; // total charges
        int frequentRenterPoints = 0; // frequent renter points
        String result = "Rental Report for " +getName() + "\n";

        for(Rental rental: rentals) {

            dispatcher.interceptFrequentRenterPoints(context);
            frequentRenterPoints+= rental.getFrequentRenterPoints();

            //Show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";

            dispatcher.interceptGetCharge(context);
            amount += rental.getCharge();
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(amount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
    //setup interceptor method
    private void setupInterceptor(){
        this.context = new Context(this);
        this.dispatcher = new Dispatcher();
        this.logger = new Logger(context);
        dispatcher.attach(logger);
    }
}