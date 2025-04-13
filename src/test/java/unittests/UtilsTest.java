package unittests;

import org.junit.jupiter.api.Test;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {

    private final Utils utils = new Utils();

    @Test
    void testStartDateBeforeEndDate_returnsTrue() {
        String start = "2024-04-01T00:00:00";
        String end = "2024-05-01T00:00:00";
        assertTrue(utils.isStartDateBeforeEndDate(start, end));
    }

    @Test
    void testStartDateEqualsEndDate_returnsFalse() {
        String start = "2024-04-01T00:00:00";
        String end = "2024-04-01T00:00:00";
        assertFalse(utils.isStartDateBeforeEndDate(start, end));
    }

    @Test
    void testStartDateAfterEndDate_returnsFalse() {
        String start = "2024-06-01T00:00:00";
        String end = "2024-05-01T00:00:00";
        assertFalse(utils.isStartDateBeforeEndDate(start, end));
    }

    @Test
    void testHandlesDifferentTimeComponents() {
        String start = "2024-04-01T09:30:00";
        String end = "2024-04-01T18:00:00";
        assertFalse(utils.isStartDateBeforeEndDate(start, end));
    }

    @Test
    void returnsTrueForTrueStrings() {
        assertTrue(utils.parseBoolean("true"));
        assertTrue(utils.parseBoolean("TRUE"));
        assertTrue(utils.parseBoolean("TrUe"));
    }

    @Test
    void returnsFalseForFalseStrings() {
        assertFalse(utils.parseBoolean("false"));
        assertFalse(utils.parseBoolean("FALSE"));
        assertFalse(utils.parseBoolean("FaLsE"));
    }

    @Test
    void returnsFalseForInvalidStrings() {
        assertFalse(utils.parseBoolean("yes"));
        assertFalse(utils.parseBoolean("no"));
        assertFalse(utils.parseBoolean("1"));
    }

}