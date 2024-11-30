package dimanu.backoffice.products.infra;

import dimanu.backoffice.products.domain.Product;
import org.junit.jupiter.api.Test;

class InMemoryProductRepositoryTest {

    @Test
    void should_save_a_product() {
        Product productToSave = new Product("anyId", "anyName", "anyDescription", 100.0, 10);
        InMemoryProductRepository repository = new InMemoryProductRepository();

        repository.save(productToSave);
    }

}