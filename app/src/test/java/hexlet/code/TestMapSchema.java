package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestMapSchema {
    private final Validator v = new Validator();
    private final MapSchema schema = v.map();

    @Test
    void testRequiredDefault() {
        assertTrue(schema.isValid(null));
    }

    @Test
    void testRequiredTrue() {
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    void testSizeValidation() {
        schema.sizeof(2);
        assertTrue(schema.isValid(Map.of("key1", "value1", "key2", "value2")));
        assertFalse(schema.isValid(Map.of("key1", "value1")));
        assertFalse(schema.isValid(Map.of("key1", "value1", "key2", "value2", "key3", "value3")));
    }

    @Test
    void testNullSize() {
        assertTrue(schema.isValid(Map.of("key1", "value1")));
        assertTrue(schema.isValid(Map.of("key1", "value1", "key2", "value2")));
        assertTrue(schema.isValid(Map.of()));
    }

    @Test
    void testEmptyMap() {
        assertTrue(schema.isValid(Map.of()));
    }

    @Test
    void testNegativeSizeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            schema.sizeof(-1)
        );
        assertEquals("Размер не может быть отрицательным", exception.getMessage());
    }

    @Test
    void testChainingMethods() {
        schema.required().sizeof(1);
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(Map.of()));
        assertTrue(schema.isValid(Map.of("key", "value")));
    }

    @Test
    void testStringShapeMethod() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));
    }
}
