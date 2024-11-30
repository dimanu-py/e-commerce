package dimanu.backoffice.products.domain;

import java.util.Objects;
import java.util.UUID;

public class ProductId {

    private final String value;

    public ProductId(String value) {
        ensureIdHasValid(value);
        this.value = value;
    }

    private void ensureIdHasValid(String value) {
        UUID.fromString(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(value, productId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
