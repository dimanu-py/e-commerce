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

    public void create(CreateProductCommand command) {
        Product product = new Product(
                command.id(),
                command.name(),
                command.description(),
                command.price(),
                command.stock()
        );

        repository.save(product);
    }

}
