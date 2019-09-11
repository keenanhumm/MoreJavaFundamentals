package com.kaytec.lambdas;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from anon. runnable");
//            }
//        }).start();
        // can be more concise here using lambdas

//        new Thread(() -> System.out.println("Printing from lambda")).start();

        Employee jon = new Employee("Jon", 45);
        Employee tim = new Employee("Tim", 34);
        Employee jack = new Employee("Jack", 24);
        Employee snow = new Employee("Snow", 88);

        List<Employee> employees = new ArrayList<>();
        employees.add(jon);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

//        Collections.sort(employees, (Employee employee1, Employee employee2) -> {
//            return employee1.getName().compareTo(employee2.getName());
//        });

        Collections.sort(employees, Comparator.comparing(Employee::getName));

//        for(Employee employee: employees) {
//            System.out.println(employee.getName());
//        }
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String joinedEmployees = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(joinedEmployees);

        System.out.println("-----------");

        for(Employee employee: employees) {
            new Thread(() -> System.out.println(employee.getName() + ", " + employee.getAge() + " | Thread: " + Thread.currentThread().getId())).start();
        }

        System.out.println("-----------");

        employees.forEach(employee -> System.out.println(employee.getName() + ", " + employee.getAge()));
    }
    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}
