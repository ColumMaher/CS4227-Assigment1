public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private int priceCode;
    private String title;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return this.title;
    }
    public double getCharge(int daysRented){
        double result = 0;
        switch(this.getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) result += 1.5*(daysRented-2);
                break;
            case Movie.CHILDRENS:
                result = 1.5;
                if (daysRented > 3) result += 1.5*(daysRented-3);
                break;
            case Movie.NEW_RELEASE:
                result = 3*daysRented;
                break;
        }
        return result;
    }
    public int getFrequentRenterPoints(int daysRented){
        if(this.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1){
            return 2;
        }else
            return 1;
    }
}
