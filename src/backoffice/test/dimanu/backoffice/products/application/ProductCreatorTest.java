package dimanu.backoffice.products.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductCreatorTest {

    @Mock
    private ProductRepository repository;

    @Test
    void should_create_a_valid_product() {
        Product savedProduct = new Product("anyId", "anyName", "anyDescription", 100.0, 10);
        ProductCreator productCreator = new ProductCreator(repository);

        productCreator.create("anyId", "anyName", "anyDescription", 100.0, 10);

        verify(repository).save(savedProduct);
    }
}