package LessonN03;

import java.io.*;
import java.util.ArrayList;

public class PartB {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String employeeFile = (args.length > 0) ? args[0] : "employees.dat";
        String idFile = "last_id.dat";

        DataInputStream idIn = new DataInputStream(new FileInputStream(idFile));
        int lastUsedID = idIn.readInt();
        System.out.println("Last used ID: " + lastUsedID);

        ArrayList<Employee> employeeList = new ArrayList<>();
        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(employeeFile));

        while (true) {
            try {
                Employee emp = (Employee) objIn.readObject();
                employeeList.add(emp);
            } catch (EOFException eof) {
                break;
            }
        }

        for (Employee emp : employeeList) {
            emp.displayInfo();
            System.out.println();
        }

    }
}
