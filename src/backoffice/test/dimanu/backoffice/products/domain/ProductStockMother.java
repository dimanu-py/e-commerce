package dimanu.backoffice.products.domain;

import dimanu.shared.domain.RandomGenerator;

public class ProductStockMother {
    public static ProductStock create() {
        return new ProductStock(RandomGenerator.integerBetween(1, 100));
    }
}
