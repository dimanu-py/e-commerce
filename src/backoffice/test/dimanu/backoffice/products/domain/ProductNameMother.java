package dimanu.backoffice.products.domain;

import dimanu.shared.domain.RandomGenerator;

public class ProductNameMother {
    public static ProductName create() {
        return new ProductName(RandomGenerator.word());
    }
}
