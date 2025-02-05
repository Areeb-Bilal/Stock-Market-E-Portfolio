# Stock Market E-Portfolio
Building a GUI with different interfaces for buying, selling, updating, getting total gain, and searching investments, with menu-driven navigation.
________________________________________
Features
1.	Add Investments:
Allows users to add new investments, including stocks, with specified details.

2.	Update Investments:
Lets users navigate through investments and update their prices.

3.	Search Investments:
Enables users to search based on symbol, keywords, and price range.

4.	Calculate Total Gain:
Computes and displays total portfolio gain and detailed breakdown for individual investments.
________________________________________
Assumptions and Limitations
Assumptions:
●	The application assumes valid input for fields such as symbol and name (no special validation beyond checking for non-empty fields).
●	Investments must have unique symbols within the portfolio.
●	Book value and gains are calculated based on predefined formulas and user inputs.
Limitations:
1.	Supported Investment Types:
Only stocks are supported; mutual funds and other investment types are not yet implemented.

2.	Data Persistence:
There is no persistent storage. Investments are stored in memory and lost when the application is closed.

3.	Error Handling:
The application performs basic validation but does not account for all edge cases (e.g., extreme inputs or unexpected user actions).

4.	Scalability:
Designed for small portfolios. Performance may degrade with a large number of investments due to linear searches.
________________________________________
Instructions to Test the Program
Prerequisites
- Java Development Kit (JDK) version 8 or higher.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a terminal to compile and run the application.

Steps to Run
1.	Download the Source Code:
Ensure all .java files (PortfolioApp.java, Investment.java, Stock.java) are in the same directory.
Compile the Application: Open a terminal in the source code directory and execute:

  -  javac PortfolioApp.java


Run the Application: Start the program by executing:

  - java PortfolioApp


Test Cases
1.	Add Investment:

- Navigate to the "Buy" tab.
- Input values:
- Symbol: TSLA, Name: Tesla, Quantity: 20, Price: 800.
- Click Buy. The investment should be added successfully.

2.	Update Price:

-	Navigate to the "Update" tab.
-	Select an investment using Previous or Next buttons.
-	Update the price (e.g., 850) and click Save.
-	Verify the updated price in the investment.

3.	Search Investments:

-   Navigate to the "Search" tab.
-   Enter Symbol: TSLA and leave other fields blank.
-   Click Search to see Tesla listed.

4.	Calculate Total Gain:

-   Navigate to the "Get Gain" tab.
-   Click Calculate Gain.
-   Verify the total gain and individual gains displayed.

5.	Reset Search:

-   In the "Search" tab, click Reset and ensure all fields and results are cleared.
________________________________________
Possible Improvements
1.	Enhanced Investment Types:

-   Add support for other types, such as mutual funds or ETFs, with custom calculations.

2.	Persistent Storage:

-   Use a database or file system to save and retrieve portfolio data between sessions.

3.	Advanced Error Handling:

-   Implement detailed validation for input fields and improve error messages.

4.	Scalability:

-   Optimize search by implementing data structures such as hashmaps for symbol-based lookups.

5.	UI Enhancements:

-	Improve the graphical interface using libraries like JavaFX for a modern look and better user experience.
6.	Test Automation:

-	Create unit tests for backend functionality and UI tests for interactive elements.
7.	Data Import/Export:

-	Add features to import/export portfolio data to/from files (e.g., CSV or JSON format).
8.	Dynamic Gains:

-	Enable real-time updates of gains based on live stock prices fetched via APIs.
________________________________________
