package models;

import java.util.List;

public class Event {
    private String name;
    private String guests;
    private List<String> food;
    private List<String> drink;
    private List<String> entertainment;
    private Integer price;

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public String getGuests() {
        return guests;
    }
}
