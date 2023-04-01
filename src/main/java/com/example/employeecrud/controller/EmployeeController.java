package com.example.employeecrud.controller;

import com.example.employeecrud.entity.Employee;
import com.example.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listAllEmployees(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }




}
