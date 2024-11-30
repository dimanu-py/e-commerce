package dimanu.backoffice.products.application;

import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductRepository;
import dimanu.shared.domain.ApplicationService;

@ApplicationService
public class ProductCreator {

    ProductRepository repository;

    public ProductCreator(ProductRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String name, String description, double price, int stock) {
        Product product = new Product(id, name, description, price, stock);

        repository.save(product);
    }
}
