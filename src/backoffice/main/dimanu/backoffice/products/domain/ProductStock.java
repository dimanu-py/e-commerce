package dimanu.backoffice.products.domain;

import dimanu.shared.domain.IntegerValueObject;

public class ProductStock extends IntegerValueObject {
    public ProductStock(int value) {
        super(value);
    }

    // Needed by Hibernate
    private ProductStock() {
        super(0);
    }
}
