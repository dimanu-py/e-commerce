package dimanu.backoffice.products.infra;

import dimanu.backoffice.products.domain.Product;
import dimanu.backoffice.products.domain.ProductId;
import dimanu.backoffice.products.domain.ProductRepository;
import dimanu.shared.domain.ApplicationRepository;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;

import java.util.Optional;

@ApplicationRepository
public class MySqlProductRepository implements ProductRepository {
    private SessionFactory sessionFactory;

    public MySqlProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Product product) {
        sessionFactory.getCurrentSession().merge(product);
    }

    @Override
    public Optional<Product> search(ProductId productId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
