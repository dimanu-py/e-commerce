package dimanu.backoffice.products.domain;

import java.util.Objects;

public class Product {

    private final ProductId id;
    private final ProductName name;
    private final ProductDescription description;
    private final ProductPrice price;
    private final ProductStock stock;

    public Product(ProductId id, ProductName name, ProductDescription description, ProductPrice price, ProductStock stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public static Product create(String id, String name, String description, double price, int stock) {
        ProductId productId = new ProductId(id);
        ProductName productName = new ProductName(name);
        ProductDescription productDescription = new ProductDescription(description);
        ProductPrice productPrice = new ProductPrice(price);
        ProductStock productStock = new ProductStock(stock);
        return new Product(productId, productName, productDescription, productPrice, productStock);
    }

    // Needed by Hibernate
    private Product() {
        this.id = null;
        this.name = null;
        this.description = null;
        this.price = null;
        this.stock = null;
    }

    public ProductId id() {
        return id;
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