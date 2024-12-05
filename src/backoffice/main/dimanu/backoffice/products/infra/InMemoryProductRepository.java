package dimanu.backoffice.products.infra;

import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductId;
import dimanu.backoffice.products.domain.ProductRepository;
import dimanu.shared.domain.ApplicationRepository;

import java.util.HashMap;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {

    private final HashMap<String, Product> products = new HashMap<>();

    @Override
    public void save(Product product) {
        products.put(
                product.id().value(),
                product
        );
    }

    @Override
    public Optional<Product> search(ProductId productId) {
        return Optional.ofNullable(products.get(productId.value()));
    }
}
