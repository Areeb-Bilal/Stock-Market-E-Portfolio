/**
 * This class represents a Mutual Fund investment.
 * It extends the Investment class and calculates its book value and gain accordingly.
 */
public class MutualFund extends Investment {
    private static final double LOAD_FEE = 25.00; // Mutual Fund load fee

    /**
     * Constructor for creating a MutualFund object.
     * 
     * @param symbol the symbol of the mutual fund
     * @param name the name of the mutual fund
     * @param quantity the quantity of the mutual fund
     * @param price the price per mutual fund
     */
    public MutualFund(String symbol, String name, int quantity, double price) {
        super(symbol, name, quantity, price);
        this.bookValue = calculateBookValue(quantity, price); // Calculate initial book value
    }

    /**
     * Gets the type of investment (Mutual Fund).
     * 
     * @return the string representing the investment type
     */
    @Override
    public String getType() {
        return "Mutual Fund";
    }

    /**
     * Calculates the book value of the mutual fund, including the load fee.
     * 
     * @param quantity the quantity of the mutual fund
     * @param price the price per mutual fund
     * @return the calculated book value
     */
    @Override
    public double calculateBookValue(int quantity, double price) {
        return (quantity * price) + LOAD_FEE;
    }

    /**
     * Calculates the gain for this mutual fund investment.
     * 
     * @return the calculated gain
     */
    @Override
    public double getGain() {
        return (quantity * price) - bookValue - LOAD_FEE;
    }
}
