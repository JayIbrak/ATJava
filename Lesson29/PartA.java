/*
 * Jahja Ibrakovic
 * 2-6-25
 */
package Lesson29;

public class PartA {
    public static void main(String[] args) {
        Bicycle speedster = new Bicycle();
        speedster.setSpeed(10);
        // arbitrary setting for comparison

        System.out.println("Speedster breaking sim:");
        while (speedster.getSpeed() > 0) {
            speedster.brake();
            System.out.println(speedster.getSpeed() + "mph");
        }

        GearedBicycle shimano = new GearedBicycle();
        shimano.setSpeed(10);
        shimano.shiftUp();
        // arbitrary setting for comparison + shifting up to demonstrate a diff here

        System.out.println("Shimano breaking sim:");
        while (shimano.getSpeed() > 0) {
            shimano.brake();
            System.out.println(shimano.getSpeed() + "mph");
        }
    }
}

class Bicycle {
    private int speed; // current speed
    private final int MAX_SPEED = 30;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public void pedal() {
        speed = speed + 1;
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }
    }

    public void brake() {
        speed = speed - 1;
        if (speed < 0) {
            speed = 0;
        }
    }
}

class GearedBicycle extends Bicycle {
    private final int GEAR_MAX_SPEED = 50;
    private int gear = 1;
    private final int MAX_GEAR = 6;
    private final int MIN_GEAR = 1;

    public int getGear() {
        return gear;
    }

    public void setGear(int newGear) {
        if (newGear > MAX_GEAR) {
            gear = MAX_GEAR;
        } else if (newGear < MIN_GEAR) {
            gear = MIN_GEAR;
        } else {
            gear = newGear;
        }
    }

    public void shiftUp() {
        if (gear < MAX_GEAR) {
            gear = gear + 1;
        }
    }

    public void shiftDown() {
        if (gear > MIN_GEAR) {
            gear = gear - 1;
        }
    }

    public void pedal() {
        int newSpeed = getSpeed() + getGear();
        if (newSpeed > GEAR_MAX_SPEED) {
            newSpeed = GEAR_MAX_SPEED;
        }
        setSpeed(newSpeed);
    }

    public void brake() {
        int newSpeed = getSpeed() - getGear();
        if (newSpeed < 0) {
            newSpeed = 0;
        }
        setSpeed(newSpeed);
    }
}