package dimanu.backoffice.products.infra;

import dimanu.backoffice.products.domain.Product;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryProductRepositoryTest {

    @Test
    void should_save_a_product() {
        Product productToSave = new Product("anyId", "anyName", "anyDescription", 100.0, 10);
        InMemoryProductRepository repository = new InMemoryProductRepository();

        repository.save(productToSave);

        Optional<Product> savedProduct = repository.search("anyId");
        assertThat(savedProduct).isEqualTo(Optional.of(productToSave));
    }

    @Test
    void should_search_existing_product() {
        Product productToSave = new Product("anyId", "anyName", "anyDescription", 100.0, 10);
        InMemoryProductRepository repository = new InMemoryProductRepository();
        repository.save(productToSave);

        Optional<Product> productFound = repository.search("anyId");

        assertThat(productFound).isEqualTo(Optional.of(productToSave));
    }

    @Test
    void should_not_find_non_existing_product() {
        InMemoryProductRepository repository = new InMemoryProductRepository();

        Optional<Product> productFound = repository.search("anyId");

        assertThat(productFound).isNotPresent();
    }
}