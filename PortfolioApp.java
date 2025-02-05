import java.awt.*;
import javax.swing.*;

public class PortfolioApp {
    private Portfolio portfolio;
    private JFrame frame;
    private JPanel cardPanel;
    private int[] currentIndex;

    // Constructor to set up the application
    public PortfolioApp() {
        portfolio = new Portfolio();

        frame = new JFrame("ePortfolio");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel = new JPanel(new CardLayout());
        frame.add(cardPanel);

        // Adding different panels to the card layout
        cardPanel.add(createWelcomePanel(), "WELCOME");
        cardPanel.add(createBuyPanel(), "BUY");
        cardPanel.add(createSellPanel(), "SELL");
        cardPanel.add(createUpdatePanel(), "UPDATE");
        cardPanel.add(createSearchPanel(), "SEARCH");
        cardPanel.add(createGetGainPanel(), "GETGAIN");

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Commands");
        JMenuItem buyItem = new JMenuItem("Buy");
        buyItem.addActionListener(e -> switchPanel("BUY"));
        JMenuItem sellItem = new JMenuItem("Sell");
        sellItem.addActionListener(e -> switchPanel("SELL"));
        JMenuItem updateItem = new JMenuItem("Update");
        updateItem.addActionListener(e -> switchPanel("UPDATE"));
        JMenuItem searchItem = new JMenuItem("Search");
        searchItem.addActionListener(e -> switchPanel("SEARCH"));
        JMenuItem getGainItem = new JMenuItem("Get Gain");
        getGainItem.addActionListener(e -> switchPanel("GETGAIN"));
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(e -> System.exit(0));

        menu.add(buyItem);
        menu.add(sellItem);
        menu.add(updateItem);
        menu.add(searchItem);
        menu.add(getGainItem);
        menu.add(quitItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    // Helper method to switch panels
    private void switchPanel(String panelName) {
        CardLayout layout = (CardLayout) cardPanel.getLayout();
        layout.show(cardPanel, panelName);
    }

    // Welcome Panel
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel welcomeLabel = new JLabel("<html><h1>Welcome to ePortfolio</h1><p>Select a command from the menu to start.</p></html>", JLabel.CENTER);
        panel.add(welcomeLabel, BorderLayout.CENTER);

        return panel;
    }

    // Buy Panel
private JPanel createBuyPanel() {
    JPanel panel = new JPanel(new BorderLayout());

    // Define text fields and combo box
    JTextField symbolField = new JTextField(20);
    JTextField nameField = new JTextField(20);
    JTextField quantityField = new JTextField(20);
    JTextField priceField = new JTextField(20);
    JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Stock", "MutualFund"});

    // Define the buttons
    JButton buyButton = new JButton("Buy");
    JButton resetButton = new JButton("Reset");
    JTextArea messageArea = new JTextArea(5, 40);
    messageArea.setEditable(false);

    // Action listener for the Buy button
    buyButton.addActionListener(e -> {
        try {
            String symbol = symbolField.getText().trim();
            String name = nameField.getText().trim();
            int quantity = Integer.parseInt(quantityField.getText().trim());
            double price = Double.parseDouble(priceField.getText().trim());
    
            if (quantity <= 0 || price <= 0) {
                messageArea.setText("Error: Quantity and price must be positive values.");
                return;
            }
    
            String type = (String) typeComboBox.getSelectedItem();
            String result = portfolio.buyInvestment(type, symbol, name, quantity, price);
            messageArea.setText(result);
        } catch (NumberFormatException ex) {
            messageArea.setText("Error: Invalid input. Please enter valid numeric values for quantity and price.");
        }
    });    

    // Action listener for the Reset button
    resetButton.addActionListener(e -> {
        // Clear all fields and message area
        symbolField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
        messageArea.setText("");
    });

    // Create form panel with fields and buttons
    JPanel formPanel = new JPanel(new GridLayout(5, 2));
    formPanel.add(new JLabel("Type:"));
    formPanel.add(typeComboBox);
    formPanel.add(new JLabel("Symbol:"));
    formPanel.add(symbolField);
    formPanel.add(new JLabel("Name:"));
    formPanel.add(nameField);
    formPanel.add(new JLabel("Quantity:"));
    formPanel.add(quantityField);
    formPanel.add(new JLabel("Price:"));
    formPanel.add(priceField);

    // Create a panel to hold buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(buyButton);
    buttonPanel.add(resetButton);

    // Add form panel and button panel to the main panel
    panel.add(formPanel, BorderLayout.CENTER);
    panel.add(buttonPanel, BorderLayout.EAST);
    panel.add(new JScrollPane(messageArea), BorderLayout.SOUTH);

    return panel;
}


// Sell Panel
private JPanel createSellPanel() {
    JPanel panel = new JPanel(new BorderLayout());

    // Define text fields for symbol, quantity, and price
    JTextField symbolField = new JTextField(20);
    JTextField quantityField = new JTextField(20);
    JTextField priceField = new JTextField(20);  // Added price field
    JTextArea messageArea = new JTextArea(10, 40);
    messageArea.setEditable(false);

    // Create form panel with fields
    JPanel formPanel = new JPanel(new GridLayout(4, 6));  // Adjusted to 4 rows for the new field
    formPanel.add(new JLabel("Symbol:"));
    formPanel.add(symbolField);
    formPanel.add(new JLabel("Quantity:"));
    formPanel.add(quantityField);
    formPanel.add(new JLabel("Price:"));  // Added price label
    formPanel.add(priceField);  // Added price field

    // Create the Sell button
    JButton sellButton = new JButton("Sell");
    sellButton.addActionListener(e -> {
        try {
            String symbol = symbolField.getText().trim();
            int quantity = Integer.parseInt(quantityField.getText().trim());
            double price = Double.parseDouble(priceField.getText().trim());
    
            if (quantity <= 0 || price <= 0) {
                messageArea.setText("Error: Quantity and price must be positive values.");
                return;
            }
    
            String result = portfolio.sellInvestment(symbol, quantity, price);
            messageArea.setText(result);
        } catch (NumberFormatException ex) {
            messageArea.setText("Error: Invalid input. Please enter valid numeric values for quantity and price.");
        }
    });
    
    // Create the Reset button
    JButton resetButton = new JButton("Reset");
    resetButton.addActionListener(e -> {
        // Reset all fields
        symbolField.setText("");
        quantityField.setText("");
        priceField.setText("");
        messageArea.setText("");  // Clear the message area
    });

    // Add buttons to a panel
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(sellButton);
    buttonPanel.add(resetButton);  // Add the Reset button

    // Add components to the main panel
    panel.add(formPanel, BorderLayout.CENTER);
    panel.add(buttonPanel, BorderLayout.EAST);
    panel.add(new JScrollPane(messageArea), BorderLayout.SOUTH);

    return panel;
}


   // Update Panel
private JPanel createUpdatePanel() {
    JPanel panel = new JPanel(new BorderLayout());

    // Text fields for symbol, name, and price
    JTextField symbolField = new JTextField(20);
    symbolField.setEditable(false); // Make symbol non-editable
    JTextField nameField = new JTextField(20);
    nameField.setEditable(false); // Make name non-editable
    JTextField priceField = new JTextField(20); // Price remains editable

    JTextArea messageArea = new JTextArea(5, 40);
    messageArea.setEditable(false);

    // Index for current investment being viewed
    final int[] currentIndex = {0};

    // Populate fields with the current investment
    Runnable updateFields = () -> {
        if (portfolio.getInvestments().isEmpty()) {
            symbolField.setText("");
            nameField.setText("");
            priceField.setText("");
            messageArea.setText("No investments to update.");
        } else {
            Investment current = portfolio.getInvestments().get(currentIndex[0]);
            symbolField.setText(current.getSymbol());
            nameField.setText(current.getName());
            priceField.setText(String.valueOf(current.getPrice()));
            messageArea.setText("Viewing investment " + (currentIndex[0] + 1) + " of " + portfolio.getInvestments().size());
        }
    };

    // Form panel layout
    JPanel formPanel = new JPanel(new GridLayout(3, 2));
    formPanel.add(new JLabel("Symbol:"));
    formPanel.add(symbolField);
    formPanel.add(new JLabel("Name:"));
    formPanel.add(nameField);
    formPanel.add(new JLabel("Price:"));
    formPanel.add(priceField);

    // Buttons for navigation and saving
    JButton prevButton = new JButton("Previous");
    prevButton.addActionListener(e -> {
        if (!portfolio.getInvestments().isEmpty()) {
            currentIndex[0] = (currentIndex[0] - 1 + portfolio.getInvestments().size()) % portfolio.getInvestments().size();
            updateFields.run();
        }
    });

    JButton nextButton = new JButton("Next");
    nextButton.addActionListener(e -> {
        if (!portfolio.getInvestments().isEmpty()) {
            currentIndex[0] = (currentIndex[0] + 1) % portfolio.getInvestments().size();
            updateFields.run();
        }
    });

    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(e -> {
        if (!portfolio.getInvestments().isEmpty()) {
            try {
                double newPrice = Double.parseDouble(priceField.getText().trim());
    
                if (newPrice <= 0) {
                    messageArea.setText("Error: Price must be a positive value.");
                    return;
                }
    
                Investment currentInvestment = portfolio.getInvestments().get(currentIndex[0]);
                currentInvestment.setPrice(newPrice);
                messageArea.setText("Price updated successfully for " + currentInvestment.getSymbol() 
                    + " (" + currentInvestment.getType() + ").");
            } catch (NumberFormatException ex) {
                messageArea.setText("Error: Invalid price. Please enter a valid number.");
            }
        }
    });
    

    // Navigation and action buttons panel
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(prevButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(saveButton);

    // Add components to the main panel
    panel.add(formPanel, BorderLayout.CENTER);
    panel.add(buttonPanel, BorderLayout.EAST);
    panel.add(new JScrollPane(messageArea), BorderLayout.SOUTH);

    // Initialize fields with the first investment (if any)
    updateFields.run();

    return panel;
}


private JPanel createSearchPanel() {
    JPanel panel = new JPanel(new BorderLayout());

    // Define text fields for symbol, keywords, low price, and high price
    JTextField symbolField = new JTextField(20);
    JTextField keywordsField = new JTextField(20);
    JTextField lowPriceField = new JTextField(20);
    JTextField highPriceField = new JTextField(20);

    // Buttons for search and reset
    JButton searchButton = new JButton("Search");
    JButton resetButton = new JButton("Reset");

    // Text area to display results
    JTextArea messageArea = new JTextArea(10, 40);
    messageArea.setEditable(false);

    // Action listener for the Search button
    searchButton.addActionListener(e -> {
        try {
            String symbol = symbolField.getText().trim();
            String keywords = keywordsField.getText().trim();
            String lowPriceText = lowPriceField.getText().trim();
            String highPriceText = highPriceField.getText().trim();

            // Parse low and high price, if provided
            Double lowPrice = lowPriceText.isEmpty() ? null : Double.parseDouble(lowPriceText);
            Double highPrice = highPriceText.isEmpty() ? null : Double.parseDouble(highPriceText);

            // Build the search result
            StringBuilder result = new StringBuilder();

            for (Investment investment : portfolio.getInvestments()) {
                boolean matchesSymbol = symbol.isEmpty() || investment.getSymbol().equalsIgnoreCase(symbol);
                boolean matchesKeywords = keywords.isEmpty() || investment.getName().toLowerCase().contains(keywords.toLowerCase());
                boolean matchesPriceRange = (lowPrice == null || investment.getPrice() >= lowPrice) &&
                                            (highPrice == null || investment.getPrice() <= highPrice);

                if (matchesSymbol && matchesKeywords && matchesPriceRange) {
                    result.append(investment).append("\n");
                }
            }

            // Update message area
            if (result.length() > 0) {
                messageArea.setText(result.toString());
            } else {
                messageArea.setText("No investments found matching the criteria.");
            }
        } catch (NumberFormatException ex) {
            messageArea.setText("Error: Invalid price input. Please enter valid numeric values for low and high prices.");
        }
    });

    // Action listener for the Reset button
    resetButton.addActionListener(e -> {
        // Clear all fields and message area
        symbolField.setText("");
        keywordsField.setText("");
        lowPriceField.setText("");
        highPriceField.setText("");
        messageArea.setText("");
    });

    // Create form panel with all input fields and labels
    JPanel formPanel = new JPanel(new GridLayout(5, 2));
    formPanel.add(new JLabel("Symbol:"));
    formPanel.add(symbolField);
    formPanel.add(new JLabel("Keywords:"));
    formPanel.add(keywordsField);
    formPanel.add(new JLabel("Low Price:"));
    formPanel.add(lowPriceField);
    formPanel.add(new JLabel("High Price:"));
    formPanel.add(highPriceField);

    // Add search and reset buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(searchButton);
    buttonPanel.add(resetButton);

    // Add components to the main panel
    panel.add(formPanel, BorderLayout.CENTER);
    panel.add(buttonPanel, BorderLayout.EAST);
    panel.add(new JScrollPane(messageArea), BorderLayout.SOUTH);

    return panel;
}


private JPanel createGetGainPanel() {
    JPanel panel = new JPanel(new BorderLayout());

    // Label and Text Field for Total Gain
    JLabel gainLabel = new JLabel("Total Gain:");
    JTextField gainField = new JTextField(20);
    gainField.setEditable(false); // Read-only field for displaying the total gain

    // Text Area to display detailed gain breakdown
    JTextArea messageArea = new JTextArea(10, 40);
    messageArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(messageArea);

    // Button to calculate gain
    JButton calculateButton = new JButton("Calculate Gain");

    // Action listener for Calculate Gain button
    calculateButton.addActionListener(e -> {
        if (portfolio.getInvestments().isEmpty()) {
            gainField.setText("0.00");
            messageArea.setText("No investments to calculate gains.");
            return;
        }

        double totalGain = 0.0;
        StringBuilder gainMessage = new StringBuilder("Gains by Investment:\n");
        for (Investment investment : portfolio.getInvestments()) {
            double gain = investment.getGain();
            totalGain += gain;
            gainMessage.append(investment.getSymbol())
                .append(" (").append(investment.getType()).append("): ")
                .append(String.format("%.2f", gain)).append("\n");
        }

        gainField.setText(String.format("%.2f", totalGain));
        messageArea.setText(gainMessage.toString());
    });

    // Panel for gain label and field
    JPanel formPanel = new JPanel(new FlowLayout());
    formPanel.add(gainLabel);
    formPanel.add(gainField);

    // Adding components to the main panel
    panel.add(formPanel, BorderLayout.NORTH);
    panel.add(scrollPane, BorderLayout.CENTER);
    panel.add(calculateButton, BorderLayout.SOUTH);

    return panel;
}
private Runnable updateFields = new Runnable() {
        @Override
        public void run() {
            if (!portfolio.getInvestments().isEmpty()) {
                Investment currentInvestment = portfolio.getInvestments().get(currentIndex[0]);
                JTextField symbolField=new JTextField();
                JTextField nameField=new JTextField();
                JTextField priceField=new JTextField();
                symbolField.setText(currentInvestment.getSymbol());
                nameField.setText(currentInvestment.getName());
                priceField.setText(String.valueOf(currentInvestment.getPrice()));

                JButton prevButton=new JButton();
                JButton nextButton=new JButton();
                // Disable Previous button if it's the first investment in the list
                prevButton.setEnabled(currentIndex[0] != 0);

                // Disable Next button if it's the last investment in the list
                nextButton.setEnabled(currentIndex[0] != portfolio.getInvestments().size() - 1);
            }
        }
    };



    public static void main(String[] args) {
        new PortfolioApp();
    }
}
