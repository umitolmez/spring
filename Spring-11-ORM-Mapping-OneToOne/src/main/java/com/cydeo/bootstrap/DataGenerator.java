package com.cydeo.bootstrap;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.entity.Region;
import com.cydeo.enums.Gender;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    EmployeeRepository employeeRepository;
//    DepartmentRepository departmentRepository;

    public DataGenerator(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
//        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Employee> employeesList = new ArrayList<>();
        List<Department> departmentsList = new ArrayList<>();

        Employee e1 = new Employee("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20), 154864,Gender.F);
        Employee e2 = new Employee("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,04,26), 56752, Gender.F);
        Employee e3 = new Employee("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17), 95313,Gender.F);
        Employee e4 = new Employee("Avrom", "Rowantree", null, LocalDate.of(2014,03,02), 119764,Gender.F);
        Employee e5 = new Employee("Felix", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), 55307, Gender.F);

        Department d1 = new Department("Sports", "Outdoors");
        Department d2 = new Department("Tools", "Hardware");
        Department d3 = new Department("Clothing", "Home");
        Department d4 = new Department("Phones & Tablets", "Electronics");
        Department d5 = new Department("Computers", "Electronics");

        Region r1 = new Region("Southwest", "United States");
        Region r2 = new Region("Central", "United States");
        Region r3 = new Region("Northwest", "United States");
        Region r4 = new Region("Quebec", "Canada");
        Region r5 = new Region("Central", "Asia");

        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e4.setDepartment(d4);
        e5.setDepartment(d5);

        e1.setRegion(r1);
        e2.setRegion(r2);
        e3.setRegion(r3);
        e4.setRegion(r4);
        e5.setRegion(r5);

        employeesList.addAll(Arrays.asList(e1,e2,e3,e4,e5));
        departmentsList.addAll(Arrays.asList(d1,d2,d3,d4,d5));

        employeeRepository.saveAll(employeesList);
//        departmentRepository.saveAll(departmentsList);  setDepartment()
    }
}
