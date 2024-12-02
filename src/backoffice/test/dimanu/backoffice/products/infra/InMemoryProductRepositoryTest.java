package dimanu.backoffice.products.infra;

import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryProductRepositoryTest {

    private final Product product = ProductMother.with_valid_id();
    private InMemoryProductRepository repository;

    private static void shouldNotHaveFound(Optional<Product> actual) {
        assertThat(actual).isNotPresent();
    }

    @BeforeEach
    void setUp() {
        repository = new InMemoryProductRepository();
    }

    @Test
    void should_save_a_product() {
        this.repository.save(product);

        Optional<Product> savedProduct = repository.search(product.id());
        shouldHaveSaved(savedProduct);
    }

    @Test
    void should_search_existing_product() {
        this.repository.save(product);

        Optional<Product> productFound = this.repository.search(product.id());

        shouldHaveGot(productFound);
    }

    @Test
    void should_not_find_non_existing_product() {
        Optional<Product> productFound = this.repository.search(product.id());

        shouldNotHaveFound(productFound);
    }

    private void shouldHaveSaved(Optional<Product> actual) {
        compareProducts(
                actual,
                product
        );
    }

    private void shouldHaveGot(Optional<Product> actual) {
        compareProducts(
                actual,
                product
        );
    }

    private void compareProducts(Optional<Product> actual, Product product) {
        assertThat(actual).isEqualTo(Optional.of(product));
    }
}
