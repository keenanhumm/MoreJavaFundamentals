package com.kaytec.employees;

import com.kaytec.utils.MyPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.kaytec.utils.MyPrint.*;

public class Main {
    public static void main(String[] args) {

        Employee jon = new Employee("Jon", 45);
        Employee tim = new Employee("Tim", 34);
        Employee jack = new Employee("Jack", 24);
        Employee snow = new Employee("Snow", 88);
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
