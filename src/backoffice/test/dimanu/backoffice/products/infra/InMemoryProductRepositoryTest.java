package dimanu.backoffice.products.infra;

import dimanu.backoffice.products.ProductsModuleIntegrationTestConfig;
import dimanu.backoffice.products.domain.Product;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class InMemoryProductRepositoryTest extends ProductsModuleIntegrationTestConfig {

    @Test
    void should_save_a_product() {
        this.inMemoryRepository.save(product);

        Optional<Product> savedProduct = inMemoryRepository.search(product.id());
        assertProductMatches(savedProduct);
    }

    @Test
    void should_search_existing_product() {
        this.inMemoryRepository.save(product);

        Optional<Product> productFound = this.inMemoryRepository.search(product.id());

        assertProductMatches(productFound);
    }

    @Test
    void should_not_find_non_existing_product() {
        Optional<Product> productFound = this.inMemoryRepository.search(product.id());

        assertHasNotFound(productFound);
    }

}
