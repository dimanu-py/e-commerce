package dimanu.backoffice.products;

import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductMother;
import dimanu.backoffice.products.infra.InMemoryProductRepository;
import dimanu.shared.infra.IntegrationTestConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsModuleIntegrationTestConfig extends IntegrationTestConfig {
    @Autowired
    protected InMemoryProductRepository inMemoryRepository;

    protected final Product product = ProductMother.withValidId();

    protected static void assertHasNotFound(Optional<Product> product) {
        assertThat(product).isNotPresent();
    }

    protected void assertProductMatches(Optional<Product> product) {
        assertThat(product).isEqualTo(Optional.of(this.product));
    }
}
