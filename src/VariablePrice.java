import java.time.LocalDateTime;

public class VariablePrice implements Behaviors {
    private String name;
    private double minPrice;
    private double maxPrice;
    private String currency;
    private int quantity;
    private LocalDateTime creationDateTime;
    private String type;

    public VariablePrice() {
    }

    public VariablePrice(String name, double minPrice, double maxPrice, String currency, int quantity, LocalDateTime creationDateTime, String type) {
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.currency = currency;
        this.quantity = quantity;
        this.creationDateTime = creationDateTime;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name
                + " , " + minPrice
                + " , " + maxPrice
                + " , "+ currency
                + " , "+ quantity
                + " , "+ creationDateTime
                +" , "+ type
                ;
    }

    @Override
    public void topUp(int quantity) {

    }

    @Override
    public void refund(int quantity) {

    }
}
