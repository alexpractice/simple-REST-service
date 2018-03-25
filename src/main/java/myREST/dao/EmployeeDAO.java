package myREST.dao;

import lombok.extern.slf4j.Slf4j;
import myREST.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class EmployeeDAO {

    private static final Map<String, Employee> empMap = new HashMap<>();

    static {
        initEmps();
    }

    private static void initEmps() {
        log.info("initialization employees on start");
        Employee emp1 = new Employee("E01", "Smith", "Clerk");
        Employee emp2 = new Employee("E02", "Allen", "Salesman");
        Employee emp3 = new Employee("E03", "Jones", "Manager");

        empMap.put(emp1.getEmpNo(), emp1);
        empMap.put(emp2.getEmpNo(), emp2);
        empMap.put(emp3.getEmpNo(), emp3);
    }

    public Employee getEmployee(String empNo) {
        log.info("get employee: " + empNo);
        return empMap.get(empNo);
    }

    public Employee addEmployee(Employee emp) {
        log.info("adding employee: " + emp);
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }

    public Employee updateEmployee(Employee emp) {
        log.info("updating employee: " + emp);
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }

    public void deleteEmployee(String empNo) {
        log.info("deleting employee: " + empNo);
        empMap.remove(empNo);
    }

    public List<Employee> getAllEmployees() {
        log.info("getting all employees");
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<>();
        list.addAll(c);
        return list;
    }

}