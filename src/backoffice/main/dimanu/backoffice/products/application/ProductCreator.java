package dimanu.backoffice.products.application;

import dimanu.backoffice.products.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCreator {

    ProductRepository repository;

    public ProductCreator(ProductRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String name, String description, double price, int stock) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
