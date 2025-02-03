/*
 * Jahja Ibrakovic
 * 1-2-25
 */
package Lesson25;

class Car {
    public static final int MAX_SPEED = 120;
    public static final int MIN_SPEED = 0;
    private double speed;

    public Car() {
        this.speed = 0;
    }

    public void accelerate() {
        if (speed < MAX_SPEED) {
            speed = speed + 1;
        } else {
            speed = MAX_SPEED;
        }
    }

    public void brake() {
        if (speed > MIN_SPEED) {
            speed = speed - 1;
        } else {
            speed = MIN_SPEED;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public Car(double initialSpeed) {
        if (initialSpeed < MIN_SPEED) {
            this.speed = MIN_SPEED;
        } else if (initialSpeed > MAX_SPEED) {
            this.speed = MAX_SPEED;
        } else {
            this.speed = initialSpeed;
        }
        // I have a question here. Do I need to include 'this' in the method for
        // specification of variables or is it optional?
    }
}

public class PartA {
    public static void main(String[] args) {
        Car lambo = new Car();
        System.out.println("Welcome to the Lamborghini dealership! Let's take your Lamborghini for a test drive!");
        System.out.println("Your current speed is: " + lambo.getSpeed() + " mph");
        System.out.println("Give it some gas!");
        for (int i = 0; i < 20; i++) {
            lambo.accelerate();
            System.out.println("Your current speed is: " + lambo.getSpeed() + " mph");
        }
        System.out.println("You are going too fast this is a parking lot! Slam on the brakes!");
        for (int i = 0; i < 10; i++) {
            lambo.brake();
            System.out.println("Your current speed is: " + lambo.getSpeed() + " mph");
        }
        System.out.println("How was that? Would you like to buy a Lamborghini?");
    }
}
