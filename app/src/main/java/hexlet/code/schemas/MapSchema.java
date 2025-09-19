package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        addCheck("required", map -> map != null && !map.isEmpty());
        return this;
    }

    public void sizeof(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Размер не может быть отрицательным");
        }
        addCheck("sizeof", map -> map.size() == num);
    }

}
