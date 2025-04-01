package Lesson33;

import java.util.ArrayList;
import Lesson33.Animal;

public class PartB {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Elephant", 1200.5));
        animals.add(new Animal("Tiger", 300.0));
        animals.add(new Animal("Giraffe", 800.0));
        animals.add(new Animal("Zebra", 500.0));

        double averageWeight = Animal.calcAvg(animals);
        System.out.printf("Average weight of animals: %.2f lbs%n", averageWeight);

        Animal a1 = animals.get(0);
        Animal a2 = animals.get(1);
        int comparison = a1.compareTo(a2);

        if (comparison < 0) {
            System.out.println(a1.getName() + " is lighter than " + a2.getName());
        } else if (comparison > 0) {
            System.out.println(a1.getName() + " is heavier than " + a2.getName());
        } else {
            System.out.println(a1.getName() + " and " + a2.getName() + " have the same weight.");
        }

        animals.sort(null);
        System.out.println("Animals sorted by weight:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
