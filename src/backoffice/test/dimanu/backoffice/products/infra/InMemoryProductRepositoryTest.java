package dimanu.backoffice.products.infra;

import dimanu.backoffice.products.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryProductRepositoryTest {

    private final String anyValidId = "e4e33753-e0b3-41be-8efd-e365bf338431";
    private final Product product = new Product(anyValidId, "anyName", "anyDescription", 100.0, 10);
    private InMemoryProductRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryProductRepository();
    }

    @Test
    void should_save_a_product() {
        this.repository.save(product);

        Optional<Product> savedProduct = repository.search(anyValidId);
        shouldHaveSaved(savedProduct);
    }

    @Test
    void should_search_existing_product() {
        this.repository.save(product);

        Optional<Product> productFound = this.repository.search(anyValidId);

        shouldHaveGot(productFound);
    }

    @Test
    void should_not_find_non_existing_product() {
        Optional<Product> productFound = this.repository.search(anyValidId);

        shouldNotHaveFound(productFound);
    }

    private static void shouldNotHaveFound(Optional<Product> actual) {
        assertThat(actual).isNotPresent();
    }

    private void shouldHaveSaved(Optional<Product> actual) {
        compareProducts(actual, product);
    }

    private void shouldHaveGot(Optional<Product> actual) {
        compareProducts(actual, product);
    }

    private void compareProducts(Optional<Product> actual, Product product) {
        assertThat(actual).isEqualTo(Optional.of(product));
    }
}
