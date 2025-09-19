package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCheck("required", str -> str != null && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(Integer num) {
        addCheck("minLength", str -> str.length() >= num);
        return this;
    }

    public void contains(String content) throws IllegalArgumentException {
        if (content == null) {
            throw new IllegalArgumentException("Содержание не должно быть пустым");
        }
        addCheck("contains", str -> str.contains(content));

    }
}
