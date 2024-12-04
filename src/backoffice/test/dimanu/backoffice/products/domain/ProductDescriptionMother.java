package dimanu.backoffice.products.domain;

import dimanu.shared.domain.RandomGenerator;

public class ProductDescriptionMother {
    public static ProductDescription create() {
        return new ProductDescription(RandomGenerator.sentence());
    }
}
