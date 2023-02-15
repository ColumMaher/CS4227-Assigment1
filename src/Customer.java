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
