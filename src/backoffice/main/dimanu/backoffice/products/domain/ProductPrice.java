package dimanu.backoffice.products.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductPrice {
    private final BigDecimal value;

    public ProductPrice(double value) {
        ensureIsPositive(value);
        this.value = BigDecimal.valueOf(value);
    }

    private void ensureIsPositive(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
    }

    public BigDecimal value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    // Needed by Hibernate
    private ProductPrice() {
        this.value = null;
    }
}
