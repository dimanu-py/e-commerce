package dimanu.backoffice.products.domain;

import dimanu.shared.domain.RandomGenerator;

public class ProductPriceMother {
    public static ProductPrice create() {
        return new ProductPrice(RandomGenerator.doubleBetween(1, 1000));
    }
}
