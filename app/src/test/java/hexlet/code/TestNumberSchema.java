package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestNumberSchema {
    private final Validator v = new Validator();
    private final NumberSchema schema = v.number();

    @Test
    void testBasicValidation() {

        assertTrue(schema.isValid(5));
        assertTrue(schema.positive().isValid(null));
    }

    @Test
    void testRequiredValidation() {
        schema.required();

        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(0));
    }

    @Test
    void testPositiveValidation() {
        schema.positive();

        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
    }

    @Test
    void testRangeValidation() {
        schema.range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }
}

