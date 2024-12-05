package dimanu.backoffice.products.domain;

import dimanu.shared.domain.StringValueObject;

public class ProductDescription extends StringValueObject {

    public ProductDescription(String value) {
        super(value);
    }

    // Needed by Hibernate
    private ProductDescription() {
        super("");
    }
}
