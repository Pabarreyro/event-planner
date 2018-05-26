
import models.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        System.out.println("Let's plan a party!");
        boolean quoterRunning = true;

        while (quoterRunning) {
            try {
                boolean name = false;

                Event quotedEvent = new Event();
                BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));

                while (!name) {
                    System.out.println("First things first, let's give your event a name:");
                    String inputName = bufferedReader.readLine();
                    if (inputName != null){
                        quotedEvent.setName(inputName);
                        name = true;
                    }
                }

                while (name) {
                    boolean navigating = true;

                    while (navigating) {
                        boolean selectGuests = false;
                        boolean selectFood = false;
                        boolean selectDrinks = false;
                        boolean selectEntertainment = false;
                        boolean applyCoupon = false;

                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(String.format("EVENT SUMMARY for %s", quotedEvent.getName()));
                        System.out.println("");
                        System.out.println("Guests:\t\t\t\t");
                        if (quotedEvent.getGuests() != null) {
                            Integer basePriceForDisplay =  200 * quotedEvent.getGuestPrices().get(quotedEvent.getGuests());
                            System.out.print(String.format("%s ($%d base)\n", quotedEvent.getGuests(), basePriceForDisplay));
                        }
                        System.out.println("");
                        System.out.println("Food:\t\t\t\t");
                        if (quotedEvent.getFood().size() > 0) {
                            for (String food : quotedEvent.getFood()) {
                                System.out.print(String.format("%s ($%d/ 50 guests)\n", food , quotedEvent.getFoodPrices().get(food)));
                            }
                        }
                        System.out.println("");
                        System.out.println("Drinks:\t\t\t\t");
                        if (quotedEvent.getDrink().size() > 0) {
                            for (String drink : quotedEvent.getDrink()) {
                                System.out.print(String.format("%s ($%d/ 50 guests)\n", drink , quotedEvent.getDrinkPrices().get(drink)));
                            }
                        }
                        System.out.println("");
                        System.out.println("Entertainment:\t\t\t\t");
                        if (quotedEvent.getEntertainment().size() > 0) {
                            for (String entertainment : quotedEvent.getEntertainment()) {
                                System.out.print(String.format("%s ($%d)\n", entertainment , quotedEvent.getEntertainmentPrices().get(entertainment)));
                            }
                        }
                        System.out.println("");
                        if (quotedEvent.getCoupon() != "none") {
                            System.out.println(String.format("%s", quotedEvent.getCoupon()));
                        }
                        System.out.println("----------------------------------------------------------");
                        System.out.println(String.format("Estimated cost:\t\t\t\t\t$%d", quotedEvent.getPrice()));
                        System.out.println("");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(String.format("Anything else you'd like to tell us about %s?", quotedEvent.getName()));
                        System.out.println("Choose from menu options:");
                        System.out.println("1.Guests\t2.Food\t3. Drinks\t 4.Entertainment\t5.Apply Coupon\t6.Exit");
                        String navChoice = bufferedReader.readLine().toLowerCase();
                        if (navChoice.equals("guests") || navChoice.equals("1")) {
                            selectGuests = true;
                            while (selectGuests) {
                                System.out.println(String.format("How many do you plan on having at %s?", quotedEvent.getName()));
                                for (Map.Entry<String, Integer> option : quotedEvent.getGuestPrices().entrySet())
                                {
                                    Integer basePriceForDisplay =  200 * option.getValue();
                                    System.out.print(String.format("%s ($%d base)  ", option.getKey(), basePriceForDisplay));
                                }
                                String inputGuests = bufferedReader.readLine().toLowerCase();
                                if (quotedEvent.getGuestPrices().containsKey(inputGuests)) {
                                    quotedEvent.setGuests(inputGuests);
                                    quotedEvent.setPrice();
                                    selectGuests = false;
                                } else {
                                    System.out.println("Sorry, that isn't a valid option.");
                                }
                            }
                        } else if (navChoice.equals("food") || navChoice.equals("2")) {
                            selectFood = true;
                            while (selectFood) {
                                System.out.println(String.format("What kind of food would you like served at %s? (prices for 50 guests)", quotedEvent.getName()));
                                for (Map.Entry<String, Integer> option : quotedEvent.getFoodPrices().entrySet())
                                {
                                    System.out.print(String.format("%s ($%d)  ", option.getKey(), option.getValue()));
                                }
                                String inputFood = bufferedReader.readLine().toLowerCase();
                                if (quotedEvent.getFoodPrices().containsKey(inputFood)) {
                                    quotedEvent.setFood(inputFood);
                                    quotedEvent.setPrice();
                                    selectFood = false;
                                } else {
                                    System.out.println("Sorry, that isn't a valid option.");
                                }
                            }
                        } else if (navChoice.equals("drinks") || navChoice.equals("3")) {
                            selectDrinks = true;
                            while (selectDrinks) {
                                System.out.println(String.format("What kind of drinks would you like served at %s? (prices for 50 guests)", quotedEvent.getName()));
                                for (Map.Entry<String, Integer> option : quotedEvent.getDrinkPrices().entrySet())
                                {
                                    System.out.print(String.format("%s ($%d)  ", option.getKey(), option.getValue()));
                                }
                                String inputDrink = bufferedReader.readLine().toLowerCase();
                                if (quotedEvent.getDrinkPrices().containsKey(inputDrink)) {
                                    quotedEvent.setDrink(inputDrink);
                                    quotedEvent.setPrice();
                                    selectDrinks = false;
                                } else {
                                    System.out.println("Sorry, that isn't a valid option.");
                                }
                            }
                        } else if (navChoice.equals("entertainment") || navChoice.equals("4")) {
                            selectEntertainment = true;
                            while (selectEntertainment) {
                                System.out.println(String.format("What kind of entertainment would you like %s?", quotedEvent.getName()));
                                for (Map.Entry<String, Integer> option : quotedEvent.getEntertainmentPrices().entrySet())
                                {
                                    System.out.print(String.format("%s ($%d)  ", option.getKey(), option.getValue()));
                                }
                                String inputEntertainment = bufferedReader.readLine().toLowerCase();
                                if (quotedEvent.getEntertainmentPrices().containsKey(inputEntertainment)) {
                                    quotedEvent.setEntertainment(inputEntertainment);
                                    quotedEvent.setPrice();
                                    selectEntertainment = false;
                                } else {
                                    System.out.println("Sorry, that isn't a valid option.");
                                }
                            }
                        } else if (navChoice.contains("coupon") || navChoice.equals("5")) {
                            applyCoupon = true;
                            while (applyCoupon) {
                                System.out.println(String.format("Please enter your valid coupon here:", quotedEvent.getName()));
                                String inputCoupon = bufferedReader.readLine().toLowerCase();
                                if (quotedEvent.getFlatDiscounts().containsKey(inputCoupon) || quotedEvent.getProportionalDiscounts().containsKey(inputCoupon)) {
                                    quotedEvent.setCoupon(inputCoupon);
                                    quotedEvent.setPrice();
                                    applyCoupon = false;
                                } else {
                                    System.out.println("Sorry, that isn't a valid option.");
                                }
                            }
                        } else if (navChoice.equals("exit") || navChoice.equals("6")) {
                            System.out.println("So long! Come back soon!");
                            navigating = false;
                            name= false;
                            quoterRunning = false;
                        } else {
                            System.out.println("Sorry, that isn't a valid option.");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
