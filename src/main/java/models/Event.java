package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Event {
    private String name;
    private String guests;
    private List<String> food;
    private List<String> drink;
    private List<String> entertainment;
    private Integer price;

    private Map<String, Integer> guestPrices = new HashMap<String, Integer>() {{
        put("0-50", 1);
        put("50-100", 2);
        put("100-150", 3);
        put("150-200", 4);
    }};

    private Map<String, Integer> foodPrices = new HashMap<String, Integer>() {{
        put("hors d'oeuvres", 500);
        put("buffet", 1000);
        put("full service", 2000);
    }};

    private Map<String, Integer> drinkPrices = new HashMap<String, Integer>() {{
        put("tea & coffee", 1);
        put("beer & wine", 2);
        put("full bar", 3);
    }};

    private Map<String, Integer> entertainmentPrices = new HashMap<String, Integer>() {{
        put("dj", 1);
        put("live band", 2);
    }};

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

    public void setEntertainment(String entertainment) {
        this.entertainment.add(entertainment);
    }

    public List<String> getEntertainment() {
        return entertainment;
    }

    public void setPrice() {
        Integer guestMultiplier = this.getGuestPrices(this.guests);
        this.price = 200 * guestMultiplier;
    }

    public Integer getGuestPrices(String key) {
        return guestPrices.get(key);
    }

    public Integer getPrice() {
        return price;
    }
}
