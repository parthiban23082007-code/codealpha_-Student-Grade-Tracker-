import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class User {
    String name;
    double balance;
    HashMap<String, Integer> portfolio;

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        portfolio = new HashMap<>();
    }

    void buyStock(Stock stock, int quantity) {
        double totalCost = stock.price * quantity;

        if (balance >= totalCost) {
            balance -= totalCost;
            portfolio.put(stock.symbol,
                    portfolio.getOrDefault(stock.symbol, 0) + quantity);

            System.out.println("Successfully bought " + quantity +
                    " shares of " + stock.symbol);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void sellStock(Stock stock, int quantity) {
        int owned = portfolio.getOrDefault(stock.symbol, 0);

        if (owned >= quantity) {
            balance += stock.price * quantity;
            portfolio.put(stock.symbol, owned - quantity);

            System.out.println("Successfully sold " + quantity +
                    " shares of " + stock.symbol);
        } else {
            System.out.println("Not enough shares to sell!");
        }
    }

    void showPortfolio() {
        System.out.println("\n----- Portfolio -----");

        if (portfolio.isEmpty()) {
            System.out.println("No stocks owned.");
        } else {
            for (String stock : portfolio.keySet()) {
                System.out.println(stock + " : " +
                        portfolio.get(stock) + " shares");
            }
        }

        System.out.println("Balance: $" + balance);
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock apple = new Stock("AAPL", 180);
        Stock google = new Stock("GOOGL", 140);
        Stock tesla = new Stock("TSLA", 250);

        User user = new User("Investor", 10000);

        int choice;

        do {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nMarket Data");
                    System.out.println("AAPL : $" + apple.price);
                    System.out.println("GOOGL: $" + google.price);
                    System.out.println("TSLA : $" + tesla.price);
                    break;

                case 2:
                    System.out.print("Enter Stock Symbol: ");
                    String buySymbol = sc.next().toUpperCase();

                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    if (buySymbol.equals("AAPL"))
                        user.buyStock(apple, buyQty);
                    else if (buySymbol.equals("GOOGL"))
                        user.buyStock(google, buyQty);
                    else if (buySymbol.equals("TSLA"))
                        user.buyStock(tesla, buyQty);
                    else
                        System.out.println("Invalid Stock Symbol!");
                    break;

                case 3:
                    System.out.print("Enter Stock Symbol: ");
                    String sellSymbol = sc.next().toUpperCase();

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    if (sellSymbol.equals("AAPL"))
                        user.sellStock(apple, sellQty);
                    else if (sellSymbol.equals("GOOGL"))
                        user.sellStock(google, sellQty);
                    else if (sellSymbol.equals("TSLA"))
                        user.sellStock(tesla, sellQty);
                    else
                        System.out.println("Invalid Stock Symbol!");
                    break;

                case 4:
                    user.showPortfolio();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
