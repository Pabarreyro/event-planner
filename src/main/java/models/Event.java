package models;

import java.util.ArrayList;
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
        this.food = new ArrayList<>();
        this.drink = new ArrayList<>();
        this.entertainment = new ArrayList<>();
        this.price = 200;

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

    public void setFood(String food) {
        this.food.add(food);
    }

    public List<String> getFood() {
        return food;
    }

    public void setDrink(String drink) {
        this.drink.add(drink);
    }

    public List<String> getDrink() {
        return drink;
    }
}
