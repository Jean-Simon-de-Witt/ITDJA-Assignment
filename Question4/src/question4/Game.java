package question4;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {
    private String name;
    private float price;
    private String category;
    private boolean isSold;
    private LocalDateTime dateSold;
    private ArrayList<String> allowedCategories = new ArrayList() {{add("RPG"); add("Simulation"); add("FPS"); add("Point-and-Click"); add("Souls-Like"); add("Sports");}};
    
    public Game() {
        this.name = "";
        this.price = 0;
        this.category = "";
        this.isSold = false;
        this.dateSold = null;
    }
    
    public Game(String name, float price, String category) {
        this.name = name;
        this.price = price;
        if (this.allowedCategories.contains(category)) {
            this.category = category;
        }
        else {
            this.category = "";
        }
        this.isSold = false;
        this.dateSold = null;
    }
    
    public Game(String name, float price, String category, boolean isSold, LocalDateTime dateSold) {
        this.name = name;
        this.price = price;
        if (this.allowedCategories.contains(category)) {
            this.category = category;
        }
        else {
            this.category = "";
        }
        this.isSold = isSold;
        this.dateSold = dateSold;
    }
    
    
    public String getName() {
        return this.name;
    }
    
    public boolean setName(String name) {
        if (name.isEmpty()) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            if (!(Character.isAlphabetic(name.charAt(i))) && !(name.charAt(i) == ' ') && !(Character.isDigit(name.charAt(i)))) {
                return false;
            }
        }
        this.name = name;
        return true;
    }
    
    public float getPrice() {
        return this.price;
    }
    
    public boolean setPrice(String price) {
        if (price.isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < price.length(); i++) {
            if (!(Character.isDigit(price.charAt(i))) && !(price.charAt(i) == '.')) {
                return false;
            }
        }
        
        float fPrice = Float.valueOf(price);
        if (fPrice < 0) {
            return false;
        }
        this.price = fPrice;
        return true;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public boolean setCategory(String category) {
        if (this.allowedCategories.contains(category)) {
            this.category = category;
            return true;
        }
        return false;
    }
    
    public boolean getIsSold() {
        return this.isSold;
    }
    
    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }
    
    public LocalDateTime getDateSold() {
        return this.dateSold;
    }
    
    public void setDateSold(LocalDateTime dateSold) {
        this.dateSold = dateSold;
    }
    
    public String getFormattedDate() {
        return this.dateSold.format(DateTimeFormatter.ISO_DATE);
    }
}
