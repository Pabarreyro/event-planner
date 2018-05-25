
import models.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {

        System.out.println("Let's plan a party!");
        boolean quoterRunning = true;

        while (quoterRunning) {
            try {
                boolean mainMenu = false;
                boolean quotable = false;
                boolean name = false;
                boolean selectGuests = false;
                boolean selectFood = false;
                boolean selectDrinks = false;
                boolean selectEntertainment = false;
                boolean applyCoupon = false;

                Event quotedEvent = new Event();
                BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));

                while (!mainMenu && !name) {
                    System.out.println("First things first, let's give your party a name:");
                    String inputName = bufferedReader.readLine();
                    quotedEvent.setName(inputName);
                    mainMenu = true;
                }

                while (mainMenu && !quotable) {
                    boolean navigating = true;

                    while (navigating) {
                        System.out.println(String.format("Great! Tell us more about %s.", quotedEvent.getName()));
                        System.out.println("Choose from menu options:");
                        System.out.println("1.Guests\t2.Food\t3. Drinks\t 4.Entertainment\t5.Apply Coupon\t6.Exit");
                        String navChoice = bufferedReader.readLine().toLowerCase();
                        if (navChoice == "guests" || navChoice == "1") {
                            navigating = false;
                            mainMenu = false;
                            selectGuests = true;
                        } else if (navChoice.equals("food") || navChoice.equals("2")) {
                            navigating = false;
                            mainMenu = false;
                            selectFood = true;
                        } else if (navChoice.equals("drinks") || navChoice.equals("3")) {
                            navigating = false;
                            mainMenu = false;
                            selectDrinks = true;
                        } else if (navChoice.equals("entertainment") || navChoice.equals("4")) {
                            navigating = false;
                            mainMenu = false;
                            selectEntertainment = true;
                        } else if (navChoice.contains("coupon")  || navChoice.equals("5")) {
                            navigating = false;
                            mainMenu = false;
                            applyCoupon = true;
                        } else if (navChoice.equals("exit")  || navChoice.equals("6")) {
                            System.out.println("So long! Come back soon!");
                        } else {
                            System.out.println("Sorry, that isn't a valid option.");
                        }
                    }

                    while (mainMenu && quotable) {
                        System.out.println("Great! Here's what we've got so far: %s.");
                        System.out.println(String.format("%s", quotedEvent.getName()));
                        System.out.println(String.format("Guests: %s ($%d)", quotedEvent.getGuests(), quotedEvent.getGuestPrices().get(quotedEvent.getGuests())));
                        System.out.println("Food: ");
                        for (String food : quotedEvent.getFood()) {
                            System.out.print(String.format("%s ($%d)", food , quotedEvent.getFoodPrices().get(food)));
                        }
                        System.out.println("Drinks: ");
                        for (String drink : quotedEvent.getDrink()) {
                            System.out.print(String.format("%s ($%d)", drink , quotedEvent.getDrinkPrices().get(drink)));
                        }
                        System.out.println("Entertainment: ");
                        for (String entertainment : quotedEvent.getEntertainment()) {
                            System.out.print(String.format("%s ($%d)", entertainment , quotedEvent.getEntertainmentPrices().get(entertainment)));
                        }
                        if (quotedEvent.getCoupon() != "none") {
                            System.out.println(String.format("%s", quotedEvent.getCoupon()));
                        }
                        System.out.println("----------------------------------------------------------");
                        System.out.println(String.format("Estimated cost: %d", quotedEvent.getPrice()));
                        System.out.println("");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(String.format("Great! Tell us more about %s.", quotedEvent.getName()));
                        System.out.println("Choose from menu options:");
                        System.out.println("1. Guests\t2. Food\t3. Drinks\t 4. Entertainment\t5. Apply Coupon\t6. Exit");
                        String navChoice = bufferedReader.readLine().toLowerCase();
                        if (navChoice == "guests" || navChoice == "1") {
                            navigating = false;
                            mainMenu = false;
                            selectGuests = true;
                        } else if (navChoice.contains("food") || navChoice.contains("2")) {
                            navigating = false;
                            mainMenu = false;
                            selectFood = true;
                        } else if (navChoice.contains("drinks") || navChoice.contains("3")) {
                            navigating = false;
                            mainMenu = false;
                            selectDrinks = true;
                        } else if (navChoice.contains("entertainment") || navChoice.contains("4")) {
                            navigating = false;
                            mainMenu = false;
                            selectEntertainment = true;
                        } else if (navChoice.contains("coupon")  || navChoice.contains("5")) {
                            navigating = false;
                            mainMenu = false;
                            applyCoupon = true;
                        } else if (navChoice.contains("exit")  || navChoice.contains("6")) {
                            System.out.println("So long! Come back soon!");
                        } else {
                            System.out.println("Sorry, that isn't a valid option.");
                        }
                    }

                }



//                System.out.println(String.format("How many do you plan on having at %s?", quotedEvent.getName()));
//                for (Map.Entry<String, Integer> option : quotedEvent.getGuestPrices().entrySet())
//                {
//                    Integer basePriceForDisplay =  200 * option.getValue();
//                    System.out.print(String.format("%s ($%d base)  ", option.getKey(), basePriceForDisplay));
//                }
//                String inputGuests = bufferedReader.readLine().toLowerCase();
//                quotedEvent.setGuests(inputGuests);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
