package dimanu.backoffice.products.application;

import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductMother;
import dimanu.backoffice.products.domain.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductCreatorTest {

    private static final String validId = "8e197c6-0379-4142-acb7-9234f460ca6e";
    private static final String invalidId = "12345";

    @Mock
    private ProductRepository repository;

    @Test
    void should_create_a_valid_product() {
        Product savedProduct = ProductMother.with_valid_id();
        ProductCreator productCreator = new ProductCreator(repository);
        CreateProductCommand command = new CreateProductCommand(
                validId,
                "anyName",
                "anyDescription",
                100.0,
                10
        );

        productCreator.create(command);

        verify(repository).save(savedProduct);
    }

    @Test
    void should_fail_to_create_product_with_invalid_identifier() {
        ProductCreator productCreator = new ProductCreator(repository);
        CreateProductCommand invalidCommand = new CreateProductCommand(
                invalidId,
                "anyName",
                "anyDescription",
                100.0,
                10
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> productCreator.create(invalidCommand)
        );
    }
}