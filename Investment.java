/**
 * This class represents a general investment.
 * It provides common functionality for different types of investments like Stock and MutualFund.
 */
public abstract class Investment {
    protected String symbol;    // Symbol of the investment
    protected String name;      // Name of the investment
    protected int quantity;     // Quantity of the investment
    protected double price;     // Price per unit of the investment
    protected double bookValue; // Book value of the investment

    /**
     * Constructor for initializing the investment.
     * 
     * @param symbol the symbol of the investment
     * @param name the name of the investment
     * @param quantity the quantity of the investment
     * @param price the price per unit of the investment
     */
    public Investment(String symbol, String name, int quantity, double price) {
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Gets the type of investment (either Stock or MutualFund).
     * 
     * @return the type of the investment as a string
     */
    public abstract String getType();

    /**
     * Calculates the book value of the investment.
     * This method is abstract and must be implemented by subclasses.
     * 
     * @param quantity the quantity of the investment
     * @param price the price per unit of the investment
     * @return the calculated book value of the investment
     */
    public abstract double calculateBookValue(int quantity, double price);

    /**
     * Calculates the gain for the investment.
     * This method is abstract and must be implemented by subclasses.
     * 
     * @return the calculated gain for the investment
     */
    public abstract double getGain();

    // Getter and setter methods for each attribute (symbol, name, etc.)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBookValue() {
        return bookValue;
    }

    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }

    @Override
    public String toString() {
        return symbol + ": " + name + " (" + getType() + ")";
    }
}
