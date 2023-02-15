public class ChildrensPrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
    public double getCharge(int daysRented){
        double result = 1.5;
        if (daysRented > 3) result += 1.5*(daysRented-3);
        return result;
    }

}
