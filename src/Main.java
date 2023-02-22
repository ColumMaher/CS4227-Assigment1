public class Main {
    public static void main(String[] args) {
        Movie[] movies = new Movie[] {
                new Movie("The Irishman", Movie.NEW_RELEASE),
                new Movie("CitizenFour", Movie.REGULAR),
                new Movie("Frozen", Movie.CHILDRENS),
                new Movie("El Camino", Movie.NEW_RELEASE),
                new Movie("Particle Fever", Movie.REGULAR)
        };
        Customer customer = new Customer("Edward Snowden");
        int days = 1;
        for(Movie m: movies) {
            customer.addRental(new Rental(m, days));
            days++;
        }
        Context context = new Context(customer);
        Dispatcher dispatcher = new Dispatcher();
        Logger logger = new Logger(context);
        dispatcher.attach(logger);
        System.out.println( customer.statement() );
    }
}