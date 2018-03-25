package myREST.controller;

import myREST.dao.EmployeeDAO;
import myREST.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRESTController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return new StringBuilder().
                append("Welcome to my simple REST service").
                append("<br>").
                append("Employee is entity like {empNo=\"E05\", empName=\"Smith\", position=\"Clerk\"}").
                append("<br>").
                append("GET /employees | for getting all employees list").
                append("<br>").
                append("GET /employee/{empNo} | for getting employee by his number").
                append("<br>").
                append("POST /employee <Employee> | for adding employee").
                append("<br>").
                append("PUT /employee <Employee> | for updating employee's info").
                append("<br>").
                append("DELETE /employees/{empNo} | for deleting employee by his number").toString();

    }

    @RequestMapping(value = "/employees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }

    @RequestMapping(value = "/employee/{empNo}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("empNo") String empNo) {
        return employeeDAO.getEmployee(empNo);
    }

    @RequestMapping(value = "/employee", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {
        return employeeDAO.addEmployee(emp);
    }

    @RequestMapping(value = "/employee", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee emp) {
        return employeeDAO.updateEmployee(emp);
    }

    @RequestMapping(value = "/employees/{empNo}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("empNo") String empNo) {
        employeeDAO.deleteEmployee(empNo);
    }
}
