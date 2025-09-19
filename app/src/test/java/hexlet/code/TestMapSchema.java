package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

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
        assertTrue(schema.isValid(null));  // По умолчанию null допустим
    }

    @Test
    void testRequiredTrue() {
        schema.required();
        assertFalse(schema.isValid(null));  // При required=true null недопустим
    }

    @Test
    void testSizeValidation() {
        schema.sizeof(2);

        // Карта нужного размера
        assertTrue(schema.isValid(Map.of("key1", "value1", "key2", "value2")));

        // Карта меньшего размера
        assertFalse(schema.isValid(Map.of("key1", "value1")));

        // Карта большего размера
        assertFalse(schema.isValid(Map.of("key1", "value1", "key2", "value2", "key3", "value3")));
    }

    @Test
    void testNullSize() {
        // Без указания размера любая карта допустима
        assertTrue(schema.isValid(Map.of("key1", "value1")));
        assertTrue(schema.isValid(Map.of("key1", "value1", "key2", "value2")));
        assertTrue(schema.isValid(Map.of()));
    }

    @Test
    void testEmptyMap() {
        assertTrue(schema.isValid(Map.of()));  // Пустая карта допустима
    }

    @Test
    void testNegativeSizeThrowsException() {

        // Проверка, что метод выбрасывает исключение при отрицательном размере
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            schema.sizeof(-1)
        );

        assertEquals("Размер не может быть отрицательным", exception.getMessage());
    }

    @Test
    void testChainingMethods() {
        schema.required().sizeof(1);

        // Проверка корректности цепочки вызовов
        assertFalse(schema.isValid(null));  // required=true
        assertFalse(schema.isValid(Map.of()));  // размер не соответствует
        assertTrue(schema.isValid(Map.of("key", "value")));  // все условия соблюдены
    }
}
