package dimanu.backoffice.products.application;

import dimanu.backoffice.products.ProductsModuleUnitTestConfig;
import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductsCreatorTest extends ProductsModuleUnitTestConfig {

    @BeforeEach
    void setUp() {
        productCreator = new ProductCreator(repository);
    }

    @Test
    void should_create_a_valid_product() {
        CreateProductCommand command = CreateProductCommandMother.withValidId();
        Product product = ProductMother.fromRequest(command);

        productCreator.create(command);

        shouldHaveSaved(product);
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