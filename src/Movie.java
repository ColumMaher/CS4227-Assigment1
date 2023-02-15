public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private Price priceCode;
    private String title;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return priceCode.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case REGULAR -> {
                this.priceCode = new RegularPrice();
                break;
            }
            case CHILDRENS -> {
                this.priceCode = new ChildrensPrice();
                break;
            }
            case NEW_RELEASE -> {
                this.priceCode = new NewReleasePrice();
                break;
            }
            default -> throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
    public double getCharge(int daysRented){
        return priceCode.getCharge(daysRented);
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return this.title;
    }
    public int getFrequentRenterPoints(int daysRented){
        return priceCode.getFrequentRenterPoints(daysRented);
    }
}
