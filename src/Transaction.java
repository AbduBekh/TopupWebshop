import java.time.LocalDateTime;

public class Transaction {
    private static int nextId = 1;
    private int id;
    private FixedPrice fixedproduct;
    private VariablePrice varproduct;
    private double variablePrice;
    private LocalDateTime purchasedDateTime;
    private Status status;

    // constructor for fixed_priced_products
    public Transaction( FixedPrice fixedproduct, LocalDateTime purchasedDateTime, Status status) {
        this.id = nextId++;
        this.fixedproduct = fixedproduct;
        this.purchasedDateTime = purchasedDateTime;
        this.status = status;
    }

    // constructor for variable_priced_products
    public Transaction( VariablePrice varproduct, double variablePrice, LocalDateTime purchasedDateTime, Status status) {
        this.id = nextId++;
        this.varproduct = varproduct;
        this.variablePrice = variablePrice;
        this.purchasedDateTime = purchasedDateTime;
        this.status = status;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public double getVariablePrice() {
        return variablePrice;
    }

    public int getId() {
        return id;
    }

    public FixedPrice getFixedproduct() {
        return fixedproduct;
    }

    public VariablePrice getVarproduct() {
        return varproduct;
    }

    public LocalDateTime getPurchasedDateTime() {
        return purchasedDateTime;
    }

    public Status getStatus() {
        return status;
    }
}

enum Status {
    PAID,
    REFUNDED
}
