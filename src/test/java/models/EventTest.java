package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {
    @Test
    public void newEvent_instantiatesCorrectly_test() {
        Event testEvent = new Event("test");
        assertEquals("test", testEvent.getName());
    }

    @Test
    public void setGuests_setsGuestsCorrectly_0to25() {
        Event testEvent = new Event("test");
        testEvent.setGuests("0-25");
        assertEquals("0-25", testEvent.getGuests());
    }
}