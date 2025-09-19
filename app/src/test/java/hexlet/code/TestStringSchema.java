package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestStringSchema {
    private final Validator v = new Validator();
    private final StringSchema schema = v.string();

    @Test
    void testBasicValidation() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }

    @Test
    void testRequiredValidation() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    void testMinLengthValidation() {
        schema.minLength(5);
        assertFalse(schema.isValid("test"));
        assertTrue(schema.isValid("testing"));
    }

    @Test
    void testContainsValidation() {
        schema.contains("hex");
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid("test"));
    }

    @Test
    void testExceptionNullString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                schema.contains(null)
        );

        assertEquals("Содержание не должно быть пустым", exception.getMessage());

    }

    @Test
    void testCombinedValidation() {
        schema.required()
                .minLength(5)
                .contains("hex");
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid("hex"));
        assertFalse(schema.isValid("helet"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    void testPriority() {
        schema.required()
                .minLength(10)
                .minLength(4);
        assertTrue(schema.isValid("hexlet"));
    }
}

