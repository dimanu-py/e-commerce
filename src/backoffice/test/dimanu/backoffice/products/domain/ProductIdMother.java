package dimanu.backoffice.products.domain;

import dimanu.shared.domain.RandomGenerator;


public class ProductIdMother {
    public static ProductId create() {
        return new ProductId(RandomGenerator.uuid());
    }
}
