package question4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author jeans
 */
public class Shop {
    private String name;
    private LinkedList<Game> games;
    private Queue<Order> orders;
    private Stack<Game> gamesSold;
    
    public Shop() {
        this.name = "";
        this.games = new LinkedList<Game>();
        this.orders = new LinkedList<Order>();
        this.gamesSold = new Stack<Game>();
    }
    
    public Shop(String name, LinkedList<Game> games) {
        this.name = name;
        this.games = games;
        this.orders = new LinkedList<Order>();
        this.gamesSold = new Stack<Game>();
    }
    
    public Shop(String name, LinkedList<Game> games, Queue<Order> orders, Stack<Game> gamesSold) {
        this.name = name;
        this.games = games;
        this.orders = orders;
        this.gamesSold = gamesSold;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public LinkedList<Game> getGames() {
        return this.games;
    }
    
    public void setGames(LinkedList<Game> games) {
        this.games = games;
    }
    
    public String addGame(String name, String price, String category) {
        Game game = new Game();
        if (!game.setName(name)) {
            return "Invalid name entered";
        }
        if (!game.setPrice(price)) {
            return "Invalid price entered";
        }
        if (!game.setCategory(category)) {
            return "Invalid category entered";
        }
        this.games.add(game);
        return null;
    }
    
    public Queue<Order> getOrders() {
        return this.orders;
    }
    
    public Queue<Order> getOrdersDuring(Month month, int year) {
        Queue<Order> ordersDuring = new LinkedList<>();
        
        for (Order order : this.orders) {
            if(order.getDate().getMonth().equals(month) && order.getDate().getYear() == year) {
                ordersDuring.add(order);
            }
        }
        return ordersDuring;
    }
    
    public void setOrders(Queue<Order> orders) {
        this.orders = orders;
    }
    
    protected void addOrder(int id, String customerName, LinkedList<Game> boughtGames) {
        this.orders.add(new Order(id, customerName, boughtGames));
    }
    
    protected void addOrder(int id, String customerName, LinkedList<Game> boughtGames, LocalDateTime date) {
        this.orders.add(new Order(id, customerName, boughtGames, date));
    }
    
    protected void clearOrders() {
        this.orders.clear();
    }
    
    public Stack<Game> getGamesSold() {
        return this.gamesSold;
    }
    
    public Stack<Game> getGamesSoldDuring(Month month, int year) {
        Stack<Game> gamesSoldDuring = new Stack<Game>();
        for (int i = 0; i < this.gamesSold.size(); i++) {
            if (this.gamesSold.get(i).getDateSold().getMonth().equals(month) && this.gamesSold.get(i).getDateSold().getYear() == year) {
                gamesSoldDuring.add(this.gamesSold.get(i));
            }
        }
        return gamesSoldDuring;
    }
    
    public void setGamesSold(Stack<Game> gamesSold) {
        this.gamesSold = gamesSold;
    }
    
    public String addGameSold(Game game, String custName) {
        if (this.games.contains(game)) {
            int id;
            if (this.orders.isEmpty()) {
                id = 1;
            }
            else {
               id = this.orders.peek().getID() + this.orders.size() + 1; 
            }
            
            Order order = new Order(id);
            if (!order.setCustomer(custName)) {
                return "Invalid customer name entered";
            }
            order.setCustomer(custName);
            this.gamesSold.add(new Game(game.getName(), game.getPrice(), game.getCategory(), true, LocalDateTime.now()));
            if (!this.orders.contains(order)) {
                order.addGame(game);
                this.addOrder(order.getID(), order.getCustomer(), order.getGames());
            }
            else {
                return "Order already exists";
            }
            this.games.remove(game);
            return null;
        }
        return "Selected game is not owned";
    }
    
    public String addGamesSold(LinkedList<Game> games, String custName) {
        if (this.games.containsAll(games)) {
            int id = this.orders.size() + 1;
            Order order = new Order(id);
            if (order.setCustomer(custName)) {
                order.setCustomer(custName);
                if (!this.orders.contains(order)) {
                for (int i = 0; i < games.size(); i++) {
                    this.games.remove(games.get(i));
                    this.gamesSold.add(games.get(i));
                }
                
                for (int i = 0; i < games.size(); i++) {
                    games.get(i).setIsSold(true);
                    games.get(i).setDateSold(LocalDateTime.now());
                }
                order.setGames(games);
                this.addOrder(order.getID(), order.getCustomer(), order.getGames());
                return null;
                }
                else {
                    return "Order already exists";
                }
            }
             return "Invalid customer name entered";
        }
        return "Selected games are not owned";
    }
    
    
    protected void clearGamesSold() {
        this.gamesSold.clear();
    }
    
    public String formatCurrency(float number) {
        return String.format("R%.2f", number);
    }
    
    protected float getSum(LocalDateTime reportTime) {
        Stack<Game> gamesSoldDuring = this.getGamesSoldDuring(reportTime.getMonth(), reportTime.getYear());
        float sum = 0;
        for (int i = 0; i < gamesSoldDuring.size(); i++) {
            sum += gamesSoldDuring.get(i).getPrice();
        }
        return sum;
    }
    
    protected String generateGamesSoldString(LocalDateTime reportTime) {
        Stack<Game> gamesSoldDuring = this.getGamesSoldDuring(reportTime.getMonth(), reportTime.getYear());
        String gamesSoldStr = "Games sold during this month:\n";
        for (int i = 0; i < gamesSoldDuring.size(); i++) {
            if (i == gamesSoldDuring.size() - 1) {
                gamesSoldStr += gamesSoldDuring.get(i).getName() + ": " +  formatCurrency(gamesSoldDuring.get(i).getPrice()) + "\n\n";
            }
            else {
                gamesSoldStr += gamesSoldDuring.get(i).getName() + ": " +  formatCurrency(gamesSoldDuring.get(i).getPrice()) + "\n";
            }
        }
        return gamesSoldStr;
    }
    
    protected String generateOrdersString(LocalDateTime reportTime) {
        Queue<Order> ordersDuring = this.getOrdersDuring(reportTime.getMonth(), reportTime.getYear());
        String ordersDuringStr = "Orders for this month:\n";
        int i = 0;
        for (Order order : ordersDuring) {
            if (i == ordersDuring.size() - 1) {
                ordersDuringStr += order.getCustomer() + ": {" + order.getFormattedGames() + "}\n\n";
            }
            else {
                ordersDuringStr += order.getCustomer() + ": {" + order.getFormattedGames() + "}\n";
            }
        }
        return ordersDuringStr;
    }
    
    
    public String generateReport(LocalDateTime reportTime) {
        String report = "Report of sales for " + this.name + " during the month of " + reportTime.getMonth().getDisplayName(TextStyle.FULL, Locale.UK) + " " + String.valueOf(reportTime.getYear()) + ":\n\n";
        report += this.generateGamesSoldString(reportTime);
        report += this.generateOrdersString(reportTime);
        report += "Total revenue for this month: " + this.formatCurrency(this.getSum(reportTime));
        return report;
    }
}
