package dimanu.backoffice.products.application;

public class CreateProductCommand {
    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private final int stock;

    public CreateProductCommand(String id, String name, String description, double price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public double price() {
        return price;
    }

    public int stock() {
        return stock;
    }
}
