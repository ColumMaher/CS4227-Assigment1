import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<Rental>();
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
            //Add renter points

            //Interception point
            //1 context object, 2 interceptor, 3 attach dispatcher
            //Create dispatcher/logger at start-up
            //Create Context object at statement invoke
            Context c = new Context(this);
            Dispatcher dispatcher = new Dispatcher();
            Logger logger = new Logger(c);
            dispatcher.attach(logger);

            dispatcher.interceptFrequentRenterPoints(c);

            frequentRenterPoints+= rental.getFrequentRenterPoints();

            //Show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
            amount += rental.getCharge();
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(amount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}