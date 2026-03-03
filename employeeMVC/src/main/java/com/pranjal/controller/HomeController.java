package com.pranjal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pranjal.dao.EmployeeDAO;
import com.pranjal.model.Employee;

@Controller
public class HomeController {

    @Autowired
    private EmployeeDAO dao;

    @GetMapping("/")
    public String home() {
        return "empRegistration";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee emp) {
        dao.saveEmployee(emp);
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    public String displayAll(Model model) {
        List<Employee> list = dao.getAllEmployees();
        model.addAttribute("employees", list);
        return "displayAll";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        dao.deleteEmployee(id);
        return "redirect:/displayAll";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Employee emp = dao.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "editEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee emp) {
        dao.updateEmployee(emp);
        return "redirect:/displayAll";
    }
}