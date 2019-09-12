package com.kaytec.employees;

import com.kaytec.utils.MyPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static com.kaytec.utils.MyPrint.*;

public class Main {
    public static void main(String[] args) {

        Employee jon = new Employee("Jon Lee", 45);
        Employee tim = new Employee("Tim Jones", 34);
        Employee jack = new Employee("Jack Reed", 24);
        Employee snow = new Employee("Snow Light", 88);
        Employee red = new Employee("Lil Red", 18);
        Employee charming = new Employee("Charming Salamander", 35);

        List<Employee> employees = new ArrayList<>();
        employees.add(jon);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

//        System.out.println("Employees over 30:");
//        printUnderline();
////        for (Employee employee: employees) {
////            if(employee.getAge() > 30) {
////                System.out.println(employee.getName());
////            }
////        }
//        employees.forEach(employee -> {
//            if (employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        });
//
//        printBlankLine();
//        printSeparator();
//        printBlankLine();
//
//        System.out.println("Employees 30 and younger:");
//        printUnderline();
////        for (Employee employee: employees) {
////            if(employee.getAge() > 30) {
////                System.out.println(employee.getName());
////            }
////        }
//        employees.forEach(employee -> {
//            if (employee.getAge() <= 30) {
//                System.out.println(employee.getName());
//            }
//        });
        printEmployeesByName(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printBlankLine();
        printEmployeesByName(employees, "Employees 30 or under", employee -> employee.getAge() <= 30);

        printBlankLine();
        printBlankLine();
        IntPredicate over15 = i -> i > 15;
        IntPredicate under100 = i -> i < 100;
        System.out.println(over15.test(10));
        System.out.println(over15.test(100));
        System.out.println(over15.test(20 + 5));
        printBlankLine();
        System.out.println(over15.and(under100).test(40));

        printBlankLine();
        printBlankLine();

        System.out.println("Last names: ");

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println(lastName);
        });

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        printBlankLine();
        printBlankLine();

        System.out.println("Last names using function lambda: ");

        employees.forEach(employee -> {
            System.out.println(getLastName.apply(employee));
        });

        Function<Employee, String> upperCaseName = employee -> employee.getName().toUpperCase();
        Function<String, String> getFirstName = name -> name.substring(0, name.indexOf(' '));
        Function<Employee, String> chainedFunction = upperCaseName.andThen(getFirstName);

        printBlankLine();
        printBlankLine();

        System.out.println("First names all caps:");
        employees.forEach(employee -> {
            System.out.println(chainedFunction.apply(employee));
        });


    }

    private static void printEmployeesByName(List<Employee> employees,
                                             String ageText,
                                             Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        printUnderline();
        for(Employee employee: employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
