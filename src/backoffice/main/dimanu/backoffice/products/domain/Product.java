package dimanu.backoffice.products.domain;

import java.util.Objects;

public class Product {

    private final ProductId id;
    private final ProductName name;
    private final ProductDescription description;
    private final ProductPrice price;
    private final ProductStock stock;

    public Product(String id, String name, String description, double price, int stock) {
        this.id = new ProductId(id);
        this.name = new ProductName(name);
        this.description = new ProductDescription(description);
        this.price = new ProductPrice(price);
        this.stock = new ProductStock(stock);
    }

    public String id() {
        return id.value();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}