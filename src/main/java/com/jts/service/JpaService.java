package com.jts.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jts.entity.Address;
import com.jts.entity.Employee;
import com.jts.entity.EmployeeRespository;

@Service
public class JpaService {
	private static final Logger log = LoggerFactory.getLogger(JpaService.class);

	@Autowired
	private EmployeeRespository employeeRepository;
	
	public void save() {
		Employee emp = new Employee();
		emp.setName("Demo User");
		
		Address add = new Address();
		add.setCity("Demo User");
		add.setStreet("Demo User");
		add.setZipCode(000000);
		add.setEmployee(emp);
		
		emp.setAddresses(Arrays.asList(add));
		
		employeeRepository.save(emp);
		
		log.info("Employee and Address saved successfully into database with id {}", emp.getId());
	}
	
	public void update(Employee emp) {
		Employee employee = employeeRepository.findById(emp.getId()).get();
		employee.setName(emp.getName());
		
		Address add = employee.getAddresses().get(0);
		add.setCity("Update User");
		add.setStreet("Updated User");
		add.setZipCode(000000);
		add.setEmployee(employee);
		
		employeeRepository.save(employee);
		
		log.info("Employee and Address updated successfully into database with id {}", employee.getId());
	}
	
	public void delete(long id) {
		Employee employee = employeeRepository.findById(id).get();
		employeeRepository.delete(employee);

		log.info("Employee and Address deleted successfully from database for id {}", employee.getId());
	}
}
