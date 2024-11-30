package dimanu.shared.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Uuid {
    private final String value;

    protected Uuid(String value) {
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
        Uuid productId = (Uuid) o;
        return Objects.equals(
                value,
                productId.value
        );
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
