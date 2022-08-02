package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{
	public EmployeeModel findByEmpName(String empName);
	public EmployeeModel findByDesignation(String designation);
	public void deleteByEmpName(String empName);
	public void deleteByDesignation(String designation);
}
