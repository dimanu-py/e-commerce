package dimanu.backoffice.products.application;

import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductMother;
import dimanu.backoffice.products.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductCreatorTest {

    @Mock
    private ProductRepository repository;

    private ProductCreator productCreator;

    @BeforeEach
    void setUp() {
        productCreator = new ProductCreator(repository);
    }

    @Test
    void should_create_a_valid_product() {
        CreateProductCommand command = CreateProductCommandMother.withValidId();
        Product savedProduct = ProductMother.fromRequest(command);

        productCreator.create(command);

        verify(repository).save(savedProduct);
    }

    @Test
    void should_fail_to_create_product_with_invalid_identifier() {
        CreateProductCommand invalidCommand = CreateProductCommandMother.withInvalidId();

        assertThrows(
                IllegalArgumentException.class,
                () -> productCreator.create(invalidCommand)
        );
    }
}