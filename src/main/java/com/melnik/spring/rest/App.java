package com.melnik.spring.rest;

import com.melnik.spring.rest.configuration.MyConfig;
import com.melnik.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = applicationContext.getBean("communication", Communication.class);

        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        Employee employee = communication.getEmployee(2);
        System.out.println(employee);

        Employee employeeNew = new Employee("Sveta", "Sokolova", "HR", 1300);
        employee.setId(12);
        communication.saveEmployee(employeeNew);

        communication.deleteEmployee(12);

    }
}
