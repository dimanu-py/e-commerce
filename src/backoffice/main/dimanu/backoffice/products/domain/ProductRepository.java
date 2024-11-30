package dimanu.backoffice.products.domain;

import java.util.Optional;

public interface ProductRepository {
    void save(Product product);

    Optional<Product> search(String productId);
}
