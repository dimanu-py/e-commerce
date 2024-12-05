package dimanu.backoffice.products;

import dimanu.backoffice.products.application.ProductCreator;
import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ProductsModuleUnitTestConfig {

    @Mock
    protected ProductRepository repository;

    protected ProductCreator productCreator;

    protected void shouldHaveSaved(Product savedProduct) {
        verify(repository).save(savedProduct);
    }
}
