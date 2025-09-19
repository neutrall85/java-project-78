package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        addCheck("required", map -> map != null && !map.isEmpty());
        return this;
    }

    public <T> MapSchema shape(Map<?, BaseSchema<T>> schemas) {
        if (schemas == null) {
            throw new IllegalArgumentException("Значение не может быть null");
        }

        Predicate<Map<?, ?>> shapeCheck = map -> schemas.keySet().stream()
                .filter(map::containsKey)
                .allMatch(key -> {
                    try {
                        return schemas.get(key).isValid((T) map.get(key));
                    } catch (ClassCastException | NullPointerException e) {
                        return false;
                    }
                });

        addCheck("shape", shapeCheck);
        return this;
    }

    public void sizeof(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Размер не может быть отрицательным");
        }
        addCheck("sizeof", map -> map.size() == num);
    }

}
