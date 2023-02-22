public class Logger implements Interceptor{

    private Context context;

    public Logger(Context c) {
        this.context = c;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context c) {
        this.context = c;
    }
    @Override
    public void interceptFrequentRenterPoints(Context c) {
        Customer customer = c.getCustomer();
        int currentRenterPoints = 0;
        for (Rental rental: customer.getRentals()){
            currentRenterPoints += rental.getFrequentRenterPoints();
            System.out.println("LOG: Points for rental " + rental.getMovie().getTitle() + " " + currentRenterPoints);
        }
        System.out.println("LOG: Total current rental points: " + currentRenterPoints);
    }

    @Override
    public void interceptGetCharge(Context c) {

    }
}
