package Lesson29;

public class PartB {
    public static void main(String[] args) {
        System.out.println("Have you ever wondered how much money an employee makes versus a manager?");
        Employee bart = new Employee("Bart", 50000);
        System.out.println("Take " + bart.getName() + " for example. He makes " + bart.getSalary() + " a year.");

        Manager homer = new Manager("Homer", 60000, 10000);
        System.out.println("And " + homer.getName() + "? He makes " + homer.getSalary() + " a year, plus a bonus of "
                + homer.getBonus() + " for a total of " + homer.getAnnualIncome() + ".");

    }

    public static class Employee {
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
    }

    public static class Manager extends Employee {
        private double bonus;

        public Manager(String name, double salary, double bonus) {
            super(name, salary);
            this.bonus = bonus;
        }

        public double getAnnualIncome() {
            return super.getAnnualIncome() + bonus;
        }

        public double getBonus() {
            return bonus;
        }

        public void setBonus(double newBonus) {
            bonus = newBonus;
        }
    }
}
