package dimanu.backoffice.products.infra;

import dimanu.backoffice.products.ProductsModuleIntegrationTestConfig;
import dimanu.backoffice.products.domain.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@Transactional
class MySqlProductRepositoryTest extends ProductsModuleIntegrationTestConfig {

    @Test
    void should_save_a_valid_product() {
        mySqlRepository.save(product);

        Optional<Product> savedProduct = mySqlRepository.search(product.id());
        assertProductMatches(savedProduct);
    }
}