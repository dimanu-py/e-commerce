package dimanu.app.backoffice.products;

import lombok.Data;

@Data
public class Request {
    private String name;
    private String description;
    private double price;
    private int stock;

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
