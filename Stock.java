
/**
 * This class represents a Stock investment.
 * It extends the Investment class and calculates its book value and gain accordingly.
 */
public class Stock extends Investment {
    private static final double COMMISSION_RATE = 9.99;

    /**
     * Constructor for creating a Stock object.
     * 
     * @param symbol the symbol of the stock
     * @param name the name of the stock
     * @param quantity the quantity of the stock
     * @param price the price per stock
     */
    public Stock(String symbol, String name, int quantity, double price) {
        super(symbol, name, quantity, price);
        this.bookValue = calculateBookValue(quantity, price);
    }

    /**
     * Gets the type of investment (Stock).
     * 
     * @return the string representing the investment type
     */
    @Override
    public String getType() {
        return "Stock";
    }

    /**
     * Calculates the book value of the stock, including commission.
     * 
     * @param quantity the quantity of the stock
     * @param price the price per stock
     * @return the calculated book value
     */
    @Override
    public double calculateBookValue(int quantity, double price) {
        return (quantity * price) + COMMISSION_RATE;
    }

    /**
     * Calculates the gain for this stock investment.
     * 
     * @return the calculated gain
     */
    @Override
    public double getGain() {
        return (quantity * price) - bookValue - COMMISSION_RATE;
    }
}
