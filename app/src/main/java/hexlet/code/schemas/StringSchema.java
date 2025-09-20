package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCheck("required", str -> str != null && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(Integer num) {
        addCheck("minLength", str -> str.length() >= num);
        return this;
    }

    public StringSchema contains(String content) throws IllegalArgumentException {
        if (content == null) {
            throw new IllegalArgumentException("Содержание не должно быть пустым");
        }
        addCheck("contains", str -> str.contains(content));
        return this;
    }
}
