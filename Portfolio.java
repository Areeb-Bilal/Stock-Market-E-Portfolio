import java.util.ArrayList;
import java.util.List;

/**
 * Represents an investment portfolio, allowing the addition, removal, and updating of investments.
 * Supports buying, selling, searching, and calculating the total gain of the portfolio.
 */
public class Portfolio {
    private List<Investment> investments;  // List of all investments in the portfolio

    /**
     * Constructor to initialize an empty portfolio.
     */
    public Portfolio() {
        this.investments = new ArrayList<>();
    }

    /**
     * Gets the list of all investments in the portfolio.
     * @return A list of investments.
     */
    public List<Investment> getInvestments() {
        return investments;
    }

    /**
     * Buys an investment (either Stock or MutualFund) and adds it to the portfolio.
     * If an investment with the same symbol already exists, it updates the quantity and book value.
     * @param type The type of investment (either "stock" or "mutualfund").
     * @param symbol The symbol of the investment (e.g., stock ticker).
     * @param name The name of the investment.
     * @param quantity The quantity of the investment being bought.
     * @param price The price of the investment.
     * @return A message indicating the result of the operation.
     */
    public String buyInvestment(String type, String symbol, String name, int quantity, double price) {
        // Validate that quantity and price are positive values
        if (quantity <= 0 || price <= 0) {
            return "Error: Quantity and price must be positive values.";
        }
    
        // Check if the investment already exists in the portfolio
        for (Investment investment : investments) {
            if (investment.getSymbol().equalsIgnoreCase(symbol)) {
                // If investment exists, update its quantity and book value
                double additionalBookValue = investment.calculateBookValue(quantity, price);
                investment.setQuantity(investment.getQuantity() + quantity);
                investment.bookValue += additionalBookValue;
                return "Updated existing investment successfully!";
            }
        }
    
        // If investment does not exist, create a new investment object
        Investment newInvestment = null;
        if (type.equalsIgnoreCase("stock")) {
            newInvestment = new Stock(symbol, name, quantity, price);
        } else if (type.equalsIgnoreCase("mutualfund")) {
            newInvestment = new MutualFund(symbol, name, quantity, price);
        }
    
        // If valid investment type, add it to the portfolio; otherwise, return error message
        if (newInvestment != null) {
            investments.add(newInvestment);
            return "New investment added successfully!";
        } else {
            return "Invalid investment type!";
        }
    }

    /**
     * Sells a specific quantity of an investment from the portfolio.
     * If the quantity to be sold exceeds the available quantity, an error message is returned.
     * @param symbol The symbol of the investment to be sold.
     * @param quantity The quantity to sell.
     * @param price The price at which to sell the investment.
     * @return A message indicating the result of the operation.
     */
    public String sellInvestment(String symbol, int quantity, double price) {
        // Validate that quantity and price are positive values
        if (quantity <= 0 || price <= 0) {
            return "Error: Quantity and price must be positive values.";
        }
    
        // Search for the investment to sell by its symbol
        for (Investment investment : investments) {
            if (investment.getSymbol().equalsIgnoreCase(symbol)) {
                // Check if there is enough quantity to sell
                if (investment.getQuantity() < quantity) {
                    return "Error: Not enough quantity to sell.";
                }
    
                // Adjust the book value and quantity after the sale
                double proportion = (double) quantity / investment.getQuantity();
                investment.bookValue -= investment.bookValue * proportion;
                investment.setQuantity(investment.getQuantity() - quantity);
    
                // If all quantity is sold, remove the investment from the portfolio
                if (investment.getQuantity() == 0) {
                    investments.remove(investment);
                }
    
                return "Sold " + quantity + " of " + symbol + " successfully.";
            }
        }
        return "Error: Investment with symbol " + symbol + " not found.";
    }

    /**
     * Updates the price of an existing investment in the portfolio.
     * @param symbol The symbol of the investment to update.
     * @param newPrice The new price of the investment.
     * @return A message indicating the result of the operation.
     */
    public String updatePrice(String symbol, double newPrice) {
        // Validate that the new price is a positive value
        if (newPrice <= 0) {
            return "Error: Price must be a positive value.";
        }
    
        // Search for the investment by symbol and update its price
        for (Investment investment : investments) {
            if (investment.getSymbol().equalsIgnoreCase(symbol)) {
                investment.setPrice(newPrice);
                return "Updated price of " + symbol + " successfully.";
            }
        }
        return "Error: Investment with symbol " + symbol + " not found.";
    }

    /**
     * Searches for investments in the portfolio based on symbol and keywords in the name.
     * @param symbol The symbol of the investment (can be empty to ignore this criterion).
     * @param keywords The keywords to search for in the investment's name (can be empty to ignore this criterion).
     * @return A string containing all matching investments or a message if no matches are found.
     */
    public String searchInvestments(String symbol, String keywords) {
        StringBuilder result = new StringBuilder();
        // Loop through all investments and check if they match the search criteria
        for (Investment investment : investments) {
            if ((symbol.isEmpty() || investment.getSymbol().equalsIgnoreCase(symbol)) &&
                (keywords.isEmpty() || investment.getName().toLowerCase().contains(keywords.toLowerCase()))) {
                result.append(investment).append("\n");  // Append the matching investment to the result
            }
        }
        // Return the result or a message if no matches are found
        return result.length() > 0 ? result.toString() : "No investments found matching the criteria.";
    }

    /**
     * Calculates the total gain of the portfolio, which is the sum of the gains of all investments.
     * @return The total gain of the portfolio.
     */
    public double calculateTotalGain() {
        // Use stream to sum the gains of all investments
        return investments.stream().mapToDouble(Investment::getGain).sum();
    }
}
