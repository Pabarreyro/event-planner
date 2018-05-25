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
    private String coupon;

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
        put("tea & coffee", 250);
        put("beer & wine", 500);
        put("full bar", 1000);
    }};

    private Map<String, Integer> entertainmentPrices = new HashMap<String, Integer>() {{
        put("dj", 600);
        put("live band", 1200);
    }};

    private Map<String, Integer> flatDiscounts = new HashMap<String, Integer>() {{
        put("party on", 50);
        put("high roller", 100);
    }};

    private Map<String, Double> proportionalDiscounts = new HashMap<String, Double>() {{
        put("coming out", 0.2);
        put("party animal", 0.4);
    }};

    public Event(String name) {
        this.name = name;
        this.food = new ArrayList<>();
        this.drink = new ArrayList<>();
        this.entertainment = new ArrayList<>();
        this.price = 200;
        this.coupon = "none";

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

    public Integer getGuestPrice(String key) {
        return guestPrices.get(key);
    }

    public Integer getFoodPrices(String key) {
        return foodPrices.get(key);
    }

    public Integer getDrinkPrices(String key) {
        return drinkPrices.get(key);
    }

    public Integer getEntertainmentPrices(String key) {
        return entertainmentPrices.get(key);
    }

    public void setPrice() {
        Integer guestMultiplier = this.getGuestPrice(this.guests);
        Integer foodSubtotal = 0;
        Integer drinkSubtotal = 0;
        Integer entertainmentSubtotal = 0;
        Integer flatDiscount = 0;
        Double proportionalDiscount = 1.0;
        for (String food : this.food) {
            foodSubtotal += this.getFoodPrices(food);
        }
        for (String drink: this.drink) {
            drinkSubtotal += this.getDrinkPrices(drink);
        }
        for (String entertainment: this.entertainment) {
            entertainmentSubtotal += this.getEntertainmentPrices(entertainment);
        }
        if (this.coupon != "none"){
            if (flatDiscounts.containsKey(this.coupon)) {
                flatDiscount += this.flatDiscounts.get(this.coupon);
            } else {
                proportionalDiscount -= this.proportionalDiscounts.get(this.coupon);
            }
        }
        Double subtotal = Math.floor(((((200 * proportionalDiscount) + foodSubtotal + drinkSubtotal) * guestMultiplier) + entertainmentSubtotal - flatDiscount));
        this.price = subtotal.intValue();
    }

    public Integer getPrice() {
        return price;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        if (flatDiscounts.containsKey(coupon) || proportionalDiscounts.containsKey(coupon)){
            this.coupon = coupon;
        }
    }
}
