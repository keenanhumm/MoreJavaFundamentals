package com.kaytec.streams;

import com.kaytec.employees.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static com.kaytec.utils.MyPrint.*;

public class Main {
    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71"
        );
        List<String> gNums = new ArrayList<>();

        bingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNums.add(number);
            }
        });

        gNums.sort(Comparator.naturalOrder());
        gNums.forEach(num -> System.out.println(num));

        printBlankLine();
        printBlankLine();

        System.out.println("Using streams:");

        bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(num -> num.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        printBlankLine();
        printBlankLine();

        Employee jon = new Employee("John Doe",30);
        Employee janet = new Employee("Janet Green",32);
        Employee abe = new Employee("Abe Parnell",45);
        Employee grant = new Employee("Grant Will",23);
        Employee filip = new Employee("Filip Branson",76);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jon);
        hr.addEmployee(janet);
        hr.addEmployee(abe);

        Department accounting = new Department("Accounting");
        hr.addEmployee(grant);
        hr.addEmployee(filip);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream().flatMap(department -> department.getEmployees().stream())
            .forEach(System.out::println);

        printBlankLine();
        printBlankLine();

        List<String> sortedGNums = bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        sortedGNums.forEach(System.out::println);

        printBlankLine();

        Map<Integer, List<Employee>> groupedEmployees = departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()/10));

        groupedEmployees.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "0's");
            printUnderline();
            entry.getValue().forEach(System.out::println);
            printBlankLine();
        });


    }
}
