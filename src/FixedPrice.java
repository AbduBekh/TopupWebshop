import java.time.LocalDateTime;

public class FixedPrice implements Behaviors {
    private String name;
    private double price;
    private String currency;
    private int quantity;
    private LocalDateTime creationDateTime;
    private String type;

    public FixedPrice() {
    }

    public FixedPrice(String name, double price, String currency, int quantity, LocalDateTime creationDateTime, String type) {
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        return  name
                + " , " + price
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
