package unittests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testGetJsonPath() {
        String mockJson = "{ \"status\": \"OK\", \"id\": 123 }";

        Response response = Mockito.mock(Response.class);
        Mockito.when(response.asString()).thenReturn(mockJson);

        String status = utils.getJsonPath(response, "status");
        String id = utils.getJsonPath(response, "id");

        assertEquals("OK", status);
        assertEquals("123", id);
    }

    @Test
    public void testGetNestedJsonError() {
        String mockJson = "{ \"errors\": { \"Course.Stream.Name\": [ " +
                "\"The Name field is required.\"," +
                "\"The field Name must be a string with a minimum length of 6 and a maximum length of 50.\" ] } }";

        Response response = Mockito.mock(Response.class);
        Mockito.when(response.asString()).thenReturn(mockJson);

        String firstError = utils.getNestedJsonError(response, "Course.Stream.Name", 0);
        String secondError = utils.getNestedJsonError(response, "Course.Stream.Name", 1);

        assertEquals("The Name field is required.", firstError);
        assertEquals("The field Name must be a string with a minimum length of 6 and a maximum length of 50.", secondError);
    }

}