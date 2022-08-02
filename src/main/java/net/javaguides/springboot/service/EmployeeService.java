package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.EmployeeModel;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	To get ALL
	public List<EmployeeModel> getAllEmployees() {
		return employeeRepository.findAll();
	}
// To get BYID
	public Optional<EmployeeModel> findEmployeeById(Long empId) {
		return employeeRepository.findById(empId);
	}
// To get byEmpName
	public EmployeeModel getByEmployeeName(String empName) {
		return employeeRepository.findByEmpName(empName);
	}
// To get byEmpDesignation
	public EmployeeModel getByEmployeeDesignation(String designation) {
		return employeeRepository.findByDesignation(designation);
	}
// To delete byID
	public String deleteEmployeeById(Long empId) {
		employeeRepository.deleteById(empId);
		return "deleted";
	}
// To delete byEmpName
	public String deleteEmployeeByName(String empName) {
		employeeRepository.deleteByEmpName(empName);
		return "deleted";
	}
// To deleted byEmpOrgnaisation
	public String deleteEmployeeByOrganisation(String designation) {
		employeeRepository.deleteByDesignation(designation);
		return "deleted";
	}
//	To save 
	public String addEmployee(EmployeeModel employee) {
		employeeRepository.save(employee);
		return "saved";
	}
//	To Update
	public String updataEmployee(EmployeeModel employee) {
		employeeRepository.save(employee);
		return "updated";
	}
//	To Delete
	public String deleteEmployee(EmployeeModel employee) {
		employeeRepository.delete(employee);
		return "deleted";
	}
}
