package dimanu.backoffice.products.application;

import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductRepository;
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
        CreateProductCommand command = new CreateProductCommand("anyId", "anyName", "anyDescription", 100.0, 10);

        productCreator.create(command);

        verify(repository).save(savedProduct);
    }
}