package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Number> {

    public NumberSchema required() {
        addCheck("required", num -> num != null && (Integer) num != 0);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", num -> (Integer) num >= 1);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", num -> min <= (Integer) num && (Integer) num <= max);
        return this;
    }
}
