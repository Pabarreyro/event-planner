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
                BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));
                System.out.println("First things first, let's give your party a name:");
                String inputName = bufferedReader.readLine();

                Event quotedEvent = new Event(inputName);
                System.out.println(String.format("How many people are attending %s?", quotedEvent.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
