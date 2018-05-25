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
    public void setGuests_setsGuestsCorrectly_0to50() {
        Event testEvent = new Event("test");
        testEvent.setGuests("0-50");
        assertEquals("0-50", testEvent.getGuests());
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

    @Test
    public void setEntertainment_setsSingleEntertainmentRequestCorrectly_liveBand() {
        Event testEvent = new Event("test");
        testEvent.setEntertainment("live band");
        assertEquals("live band", testEvent.getEntertainment().get(0));
    }

    @Test
    public void setEntertainment_setsMultipleEntertainmentRequestsCorrectly_2() {
        Event testEvent = new Event("test");
        testEvent.setEntertainment("live band");
        testEvent.setEntertainment("dj");
        assertEquals(2, testEvent.getEntertainment().size());
    }

    @Test
    public void setPrice_setsPriceBasedOnGuests_400() {
        Event testEvent = new Event("test");
        Integer testPrice = 400;
        testEvent.setGuests("50-100");
        testEvent.setPrice();
        assertEquals(testPrice, testEvent.getPrice());
    }

    @Test
    public void setPrice_setsPriceBasedOnFood_3400() {
        Event testEvent = new Event("test");
        Integer testPrice = 3400;
        testEvent.setGuests("50-100");
        testEvent.setFood("hors d'oeuvres");
        testEvent.setFood("buffet");
        testEvent.setPrice();
        assertEquals(testPrice, testEvent.getPrice());
    }

    @Test
    public void setPrice_setsPriceBasedOnDrink_1900() {
        Event testEvent = new Event("test");
        Integer testPrice = 1900;
        testEvent.setGuests("50-100");
        testEvent.setDrink("beer & wine");
        testEvent.setDrink("tea & coffee");
        testEvent.setPrice();
        assertEquals(testPrice, testEvent.getPrice());
    }

    @Test
    public void setPrice_setsPriceBasedOnEntertainment_2200() {
        Event testEvent = new Event("test");
        Integer testPrice = 2200;
        testEvent.setGuests("50-100");
        testEvent.setEntertainment("live band");
        testEvent.setEntertainment("dj");
        testEvent.setPrice();
        assertEquals(testPrice, testEvent.getPrice());
    }

    @Test
    public void setCoupon_setsValidDiscountCoupon_partyOn() {
        Event testEvent = new Event("test");
        testEvent.setCoupon("coming out");
        assertEquals("coming out", testEvent.getCoupon());
    }

    @Test
    public void setCoupon_doesNotSetInvalidDiscountCoupon_none() {
        Event testEvent = new Event("test");
        testEvent.setCoupon("I'm a fraud");
        assertEquals("none", testEvent.getCoupon());
    }

    @Test
    public void setPrice_doesNotApplyDiscountWhenCouponAbsent_400() {
        Event testEvent = new Event("test");
        Integer testPrice = 400;
        testEvent.setGuests("50-100");
        testEvent.setPrice();
        assertEquals(testPrice, testEvent.getPrice());
    }

    @Test
    public void setPrice_appliesValidFlatDiscountToPrice_750() {
        Event testEvent = new Event("test");
        Integer testPrice = 750;
        testEvent.setGuests("150-200");
        testEvent.setCoupon("party on");
        testEvent.setPrice();
        assertEquals(testPrice, testEvent.getPrice());
    }

    @Test
    public void setPrice_appliesValidProportionalDiscountToPrice_320() {
        Event testEvent = new Event("test");
        Integer testPrice = 320;
        testEvent.setGuests("50-100");
        testEvent.setCoupon("coming out");
        testEvent.setPrice();
        assertEquals(testPrice, testEvent.getPrice());
    }
}