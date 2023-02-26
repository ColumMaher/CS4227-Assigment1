import org.junit.Test;

import static org.junit.Assert.*;

public class Automated_Test {

    @Test
    public void test_one() {
        Movie[] movies = new Movie[] {
                new Movie("The Irishman", Movie.NEW_RELEASE),
                new Movie("CitizenFour", Movie.REGULAR),
                new Movie("Frozen", Movie.CHILDRENS)
        };
        Customer customer = new Customer("John Howard");
        int days = 1;
        for(Movie m: movies) {
            customer.addRental(new Rental(m, days));
            days++;
        }

        customer.statement();

        int total_Charge = 6;
        int total_renterpoints = 3;
        int amount = 0;
        int points = 0;
        for(Rental rental: customer.getRentals()){
            amount += rental.getCharge();
            points += rental.getFrequentRenterPoints();
        }
        assertEquals(total_Charge, amount);
        assertEquals(total_renterpoints, points);
    }
}