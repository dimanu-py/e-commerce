package dimanu.backoffice.products.domain;

import dimanu.shared.domain.ApplicationRepository;

import java.util.Optional;

@ApplicationRepository
public interface ProductRepository {
    void save(Product product);

    Optional<Product> search(ProductId productId);
}
