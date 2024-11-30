package dimanu.shared.domain;

public abstract class IntegerValueObject {
    private final int value;

    protected IntegerValueObject(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IntegerValueObject that = (IntegerValueObject) obj;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
