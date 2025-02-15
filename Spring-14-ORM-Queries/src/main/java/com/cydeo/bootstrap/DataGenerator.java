package com.cydeo.bootstrap;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---REGION START---");

        System.out.println("findByCounrty: " + regionRepository.findByCountry("Canada"));
        System.out.println("findByDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("filterByCountryContaining:" + regionRepository.findByCountryContaining("United"));
        System.out.println("filterByCountryContainingOrderByCountry:" + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("" + regionRepository.findTop2ByCountry("Canada"));
        
        System.out.println("---REGION END---");

        System.out.println("---DEPARTMENT START---");

        System.out.println("findByCounrty: " + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findDistinctTop3ByDepartmentContains: " + departmentRepository.findDistinctTop3ByDepartmentContains("Hea"));

        System.out.println("---DEPARTMENT END---");

        System.out.println("---EMPLOYEE START---");

        System.out.println("findByCounrty: " + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findDistinctTop3ByDepartmentContains: " + departmentRepository.findDistinctTop3ByDepartmentContains("Hea"));

        System.out.println("getEmployeeDetail:" + employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary: " + employeeRepository.getEmployeeSalary());

        System.out.println("---EMPLOYEE END---");

        System.out.println("---COURSE START---");

        courseRepository.findByCategory("Spring").forEach(System.out::println);
        System.out.println("----------");
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println("----------");
        System.out.println(courseRepository.existsByName("JavaScript for All"));
        System.out.println("----------");
        System.out.println(courseRepository.countByCategory("Spring"));
        System.out.println("----------");
        courseRepository.findByNameStartsWith("Scalable").forEach(System.out::println);
        System.out.println("----------");
        courseRepository.streamByCategory("Spring").forEach(System.out::println);

        System.out.println("---COURSE END---");
    }
}
