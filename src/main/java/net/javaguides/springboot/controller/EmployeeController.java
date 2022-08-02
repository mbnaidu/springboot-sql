package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.EmployeeModel;
import net.javaguides.springboot.service.EmployeeService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
//	Get ALL Employees
	@GetMapping("/list")
	public List<EmployeeModel> getListofAllEmployee() {
		return employeeService.getAllEmployees();
	}
//	Get ALL Employees
	@PostMapping("/add")
	public String addEmployee(@RequestBody EmployeeModel employee) {
		return employeeService.addEmployee(employee);
	}	
//	Get employee BYID
	@GetMapping("/{empId}/get")
	public EmployeeModel getEmployeeById(@PathVariable Long empId) {
		return employeeService.findEmployeeById(empId).get();
	}
	
//	Delete Employee BYID
	@DeleteMapping("/{empId}/delete")
	public String deleteEmployeeById(@PathVariable Long empId) {
		return employeeService.deleteEmployeeById(empId);
	}

//	Update Employee BYID
	@PutMapping("/{empId}/update")
	public String updateEmployeeById(@PathVariable Long empId, @RequestBody EmployeeModel employee) {
	Optional<EmployeeModel> employee2 = employeeService.findEmployeeById(empId);
	
	if(employee2.isPresent()) {
		EmployeeModel employee3 = employee2.get();
		employee3.setDesignation(employee.getDesignation());
		employee3.setEmpName(employee.getEmpName());
		return employeeService.updataEmployee(employee3);
	}
	return 
		"employee can't be updated";
	
	}
}
