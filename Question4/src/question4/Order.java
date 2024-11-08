package question4;
import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private int id;
    private String customerName;
    private LinkedList<Game> boughtGames;
    private LocalDateTime date;
    
    public Order() {
        this.id = 0;
        this.customerName = "";
        this.boughtGames = new LinkedList<Game>();
        this.date = LocalDateTime.now();
    }
    
    public Order(int id) {
        this.id = id;
        this.customerName = "";
        this.boughtGames = new LinkedList<Game>();
        this.date = LocalDateTime.now();
    }
    
    public Order(int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
        this.boughtGames = new LinkedList<Game>();
        this.date = LocalDateTime.now();
        
    }
    
    public Order(int id, String customerName, LinkedList<Game> boughtGames) {
        this.id = id;
        this.customerName = customerName;
        this.boughtGames = boughtGames;
        this.date = LocalDateTime.now();
    }
    
    public Order(int id, String customerName, LinkedList<Game> boughtGames, LocalDateTime date) {
        this.id = id;
        this.customerName = customerName;
        this.boughtGames = boughtGames;
        this.date = date;
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getCustomer() {
        return this.customerName;
    }
    
    public boolean setCustomer(String customerName) {
        if (customerName.isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < customerName.length(); i++) {
            if (!Character.isAlphabetic(customerName.charAt(i)) && customerName.charAt(i) != ' ') {
                return false;
            }
        }
        this.customerName = customerName;
        return true;
    }
    
    public LinkedList<Game> getGames() {
        return this.boughtGames;
    }
    
    public void setGames(LinkedList<Game> games) {
        this.boughtGames = games;
    }
    
    public void addGame(Game game) {
        this.boughtGames.add(game);
    }
    
    public LocalDateTime getDate() {
        return this.date;
    }
    
    public String getFormattedDate() {
        return this.date.format(DateTimeFormatter.ISO_DATE);
    }
    
    public String getFormattedGames() {
        String output = "";
        for (int i = 0; i < this.boughtGames.size(); i++) {
            if (i == this.boughtGames.size() - 1) {
                output += this.boughtGames.get(i).getName();
            }
            else {
                output += this.boughtGames.get(i).getName() + ", ";
            }
        }
        return output;
    }
    
}
