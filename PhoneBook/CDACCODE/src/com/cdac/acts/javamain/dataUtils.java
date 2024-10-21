package com.cdac.acts.javamain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class dataUtils {
    public static List<Employee> addData() {
        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(List.of(1234567890, 1236547890), "ankur", LocalDate.parse("2019-10-10"), "ankur@gmail.com"));
        empList.add(new Employee(List.of(1122334455, 1234567890), "salman", LocalDate.parse("2020-10-10"), "salman@gmail.com"));

        return empList;
    }
}
