package LessonN03;

import java.util.*;
import java.io.*;

public class PartA {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java EmployeeDataWriter <startingID>");
            return;
        }

        Employee.lastIDUsed = Integer.parseInt(args[0]);

        Scanner in = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();

        while (true) {
            System.out.print("Please enter the first name or 'q' to finish: ");
            String firstname = in.nextLine().trim();
            if (firstname.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Please enter the last name: ");
            String lastname = in.nextLine().trim();

            double salary = 0;
            while (true) {
                System.out.print("Enter Salary: ");
                String salaryInput = in.nextLine().trim();
                try {
                    salary = Double.parseDouble(salaryInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid salary. Please enter a number.");
                }
            }

            Employee.lastIDUsed++;
            Employee emp = new Employee(firstname, lastname, Employee.lastIDUsed, salary);
            employeeList.add(emp);
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            for (Employee emp : employeeList) {
                out.writeObject(emp);
            }
            System.out.println("Employee data saved to employees.dat");
        } catch (IOException e) {
            System.out.println("Error writing employee data: " + e.getMessage());
        }

        try (DataOutputStream idOut = new DataOutputStream(new FileOutputStream("last_id.dat"))) {
            idOut.writeInt(Employee.lastIDUsed);
            System.out.println("Last used ID saved to last_id.dat");
        } catch (IOException e) {
            System.out.println("Error writing last ID: " + e.getMessage());
        }
    }
}
