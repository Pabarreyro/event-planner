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

    @Test
    public void setFood_setsSingleFoodRequestCorrectly_horsDoeuvres() {
        Event testEvent = new Event("test");
        testEvent.setFood("hors d'oeuvres");
        assertEquals("hors d'oeuvres", testEvent.getFood().get(0));
    }

    @Test
    public void setFood_setsMultipleFoodRequestsCorrectly_2() {
        Event testEvent = new Event("test");
        testEvent.setFood("hors d'oeuvres");
        testEvent.setFood("buffet");
        assertEquals(2, testEvent.getFood().size());
    }

    @Test
    public void setDrink_setsSingleDrinkRequestCorrectly_beerAndWine() {
        Event testEvent = new Event("test");
        testEvent.setDrink("beer & wine");
        assertEquals("beer & wine", testEvent.getDrink().get(0));
    }

    @Test
    public void setDrink_setsMultipleDrinkRequestsCorrectly_2() {
        Event testEvent = new Event("test");
        testEvent.setDrink("beer & wine");
        testEvent.setDrink("tea & coffee");
        assertEquals(2, testEvent.getDrink().size());
    }

}