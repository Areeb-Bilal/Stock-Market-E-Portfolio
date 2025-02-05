README for Portfolio Management Application
Introduction
The Portfolio Management Application is a Java-based program that allows users to manage an investment portfolio. It provides functionalities for adding investments, updating their prices, searching through them, and calculating total gains. The application supports stocks as the primary investment type.
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

2.	
Run the Application: Start the program by executing:

  - java PortfolioApp

3.	
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

Test Plan for Portfolio Management Application
Objective
The purpose of this test plan is to validate the functionality, usability, and reliability of the Portfolio Management Application. It aims to ensure all features work as intended and meet the requirements specified in the application's design.
________________________________________
Scope
This test plan covers the following core functionalities:
1.	Adding investments.
2.	Updating investment details.
3.	Searching for investments.
4.	Calculating total portfolio gain.
5.	Error handling and boundary testing for user inputs.
________________________________________
Test Environment
Prerequisites:
-	Java Development Kit (JDK) version 8 or higher installed.
-	The source code compiled and executable as PortfolioApp.
-	A system capable of running Java applications (Windows, macOS, or Linux).
Test Tools:
-	Manual input testing for GUI.
-	Logging of console outputs for backend methods (if necessary).
________________________________________
Test Cases
1. Add Investments
Test ID	Test Scenario	Steps	Expected Result
TC-001	Add a valid investment	Enter valid symbol, name, quantity, and price in the "Buy" tab, then click Buy.	Investment is added, and a success message is displayed in the message area.
TC-002	Add investment with a duplicate symbol	Enter the same symbol for an existing investment.	Application prevents duplicate symbols and shows an error message.
TC-003	Add investment with invalid price or quantity	Enter non-numeric or negative values in the price or quantity fields.	Application rejects input and shows appropriate error messages.
TC-004	Add investment with empty fields	Leave one or more fields empty and click Buy.	Application prevents the action and displays an error message.
________________________________________
2. Update Investment Prices
Test ID	Test Scenario	Steps	Expected Result
TC-005	Update price of an existing investment	Navigate to the "Update" tab, modify the price, and click Save.	The investment's price is updated successfully, and a confirmation message is shown.
TC-006	Update price with invalid input	Enter a non-numeric or negative value in the price field.	Application rejects input and shows an error message.
TC-007	Navigate through investments	Use Previous and Next buttons to browse investments.	Investments are navigated sequentially, and fields update accordingly.
________________________________________
3. Search Investments
Test ID	Test Scenario	Steps	Expected Result
TC-008	Search by symbol	Enter a valid symbol in the "Search" tab and click Search.	Matching investments are displayed in the message area.
TC-009	Search with keywords	Enter keywords present in investment names.	Investments containing the keywords are displayed.
TC-010	Search by price range	Enter valid low and high prices and click Search.	Investments within the price range are displayed.
TC-011	Search with no matching criteria	Enter criteria that no investment matches (e.g., nonexistent symbol).	A "No investments found" message is displayed.
TC-012	Reset search	Click Reset after entering search criteria.	All input fields are cleared, and the message area is emptied.
________________________________________
4. Calculate Total Gain
Test ID	Test Scenario	Steps	Expected Result
TC-013	Calculate gain with existing investments	Navigate to "Get Gain" tab and click Calculate Gain.	Total gain and individual investment gains are displayed correctly.
TC-014	Calculate gain with no investments	Test the "Calculate Gain" feature with an empty portfolio.	Gain is displayed as 0.00, and a message indicates no investments are present.
________________________________________
5. Error Handling
Test ID	Test Scenario	Steps	Expected Result
TC-015	Input invalid data in fields	Enter text in numeric fields or leave mandatory fields blank.	Application shows clear error messages and does not proceed.
TC-016	Input extreme values	Test with very high/low numeric values for price and quantity.	Application handles the inputs without crashing and displays results as expected.
________________________________________
Exit Criteria
The application passes all critical test cases without errors:
1.	Functionalities such as adding investments, updating prices, searching, and calculating gains work correctly.
2.	The application handles invalid inputs gracefully and provides appropriate error messages.
3.	All navigational and UI elements (buttons, fields, etc.) function as intended.
________________________________________
Possible Enhancements to Testing
1.	Automated Testing:

-	Implement unit and integration tests using frameworks like JUnit for backend logic.
-	Use UI testing tools such as TestFX for GUI interactions.
2.	Stress Testing:

-	Test with a large number of investments to evaluate performance.
3.	Cross-Platform Testing:

-	Test the application on different operating systems (Windows, macOS, Linux).
4.	Edge Case Testing:

-	Test edge cases such as special characters in text fields or zero/negative values for prices and quantities.
________________________________________
