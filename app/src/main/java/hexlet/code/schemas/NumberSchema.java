package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addCheck("required", num -> num != null && num != 0);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", num -> num >= 1);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", num -> min <= num && num <= max);
        return this;
    }
}
