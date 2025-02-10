package Lesson30;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
import java.util.ArrayList;

public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Executive> executives = new ArrayList<>();
        while (true) {
            System.out.print("Enter a letter (E)mployee, (M)anager, e(X)ecutive, or (Q)uit): ");
            String choice = in.nextLine().toLowerCase();
            String name;
            double salary;
            double bonus;
            double shares;
            if (choice.equals("q")) {
                // exit the loop.
                break;
            } else if (choice.equals("e")) {
                // create a new employee;
                System.out.print("Enter name: ");
                name = in.nextLine();
                System.out.print("Enter salary (as a double): ");
                salary = Double.parseDouble(in.nextLine());
                Employee employee = new Employee(name, salary);

                // add to array list.
                employees.add(employee);
            } else if (choice.equals("m")) {
                // create a new manager;
                System.out.print("Enter name: ");
                name = in.nextLine();
                System.out.print("Enter salary (as a double): ");
                salary = Double.parseDouble(in.nextLine());
                System.out.print("Enter bonus (as a double): ");
                bonus = Double.parseDouble(in.nextLine());
                Manager manager = new Manager(name, salary, bonus);

                // add to array list.
                employees.add(manager);
                managers.add(manager);
            } else if (choice.equals("x")) {
                System.out.print("Enter name: ");
                name = in.nextLine();
                System.out.print("Enter salary (as a double): ");
                salary = Double.parseDouble(in.nextLine());
                System.out.print("Enter bonus (as a double): ");
                bonus = Double.parseDouble(in.nextLine());
                System.out.print("Enter shares (as a double): ");
                shares = Double.parseDouble(in.nextLine());
                Executive executive = new Executive(name, salary, bonus, shares);
                managers.add(executive);
                employees.add(executive);
                executives.add(executive);
            } else {
                System.out.println("I don't understand your choice.");
            }

            // put a newline to make it easier to read.
            System.out.println();
        }

        // insert newline to make it easier to read.
        System.out.println();

        // after entering in data, loop through the array list and display info.
        System.out.printf("Your company has %d employees.%n", employees.size());
        System.out.println();

        for (Employee employee : employees) {
            employee.displayInfo();
            System.out.println();
        }
        for (Executive executive : executives) {
            System.out.println();
        }

    }

    static class Executive extends Manager {
        private double shares;

        public Executive(String name, double salary, double bonus, double shares) {
            super(name, salary, bonus);
            this.shares = shares;
        }

        public double getShares() {
            return shares;
        }

        public void setShares(double newShares) {
            shares = newShares;
        }

        @Override // I forgot how to override and found this syntax with an @ just off of a reddit
                  // post which I've never seen is this alright??
        public void displayInfo() {
            super.displayInfo();
            System.out.printf("  Shares = $%,12.2f%n", shares);
        }

    }

    static class Manager extends Employee {
        private double bonus;

        public Manager(String name, double salary, double bonus) {
            // invoke the parent class' constructor.
            super(name, salary);

            // initialize the child class' members.
            this.bonus = bonus;
        }

        public double getBonus() {
            return bonus;
        }

        public void setBonus(double newBonus) {
            bonus = newBonus;
        }

        /*
         * Override the annual income method.
         */
        public double getAnnualIncome() {
            return super.getAnnualIncome() + getBonus();
        }

        public void displayInfo() {
            super.displayInfo();
            System.out.printf("  Bonus  = $%,12.2f%n", bonus);
        }
    }

    static class Employee {
        private String name;
        private double salary;

        /*
         * Constructor.
         */
        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String newName) {
            name = newName;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double newSalary) {
            salary = newSalary;
        }

        public double getAnnualIncome() {
            // Employees only get an annual salary.
            return getSalary();
        }

        public void displayInfo() {
            System.out.println(name + ":");
            System.out.printf("  Salary = $%,12.2f%n", salary);
        }
    }
}
