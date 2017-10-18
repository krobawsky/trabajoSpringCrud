package com.tecsup.crud.dao.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.crud.dao.EmployeeDAO;
import com.tecsup.crud.exception.DAOException;
import com.tecsup.crud.exception.EmptyResultException;
import com.tecsup.crud.mapper.EmployeeMapper;
import com.tecsup.crud.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Employee findEmployee(int employee_id) throws DAOException, EmptyResultException {

		String query = "SELECT employee_id, login, password, first_name, last_name, salary, department_id "
				+ " FROM employees WHERE employee_id = ?";

		Object[] params = new Object[] { employee_id };

		try {

			Employee emp = (Employee) jdbcTemplate.queryForObject(query, params, new EmployeeMapper());
			//
			return emp;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	public Employee save(Employee p) throws EmptyResultException, DAOException{  
	    String query="insert into employees(login, password, first_name, last_name, salary) "
	    		+ "values('"+p.getLogin()+"',"+p.getPassword()+",'"+p.getFirstname()+",'"+p.getLastname()+",'"+p.getSalary()+"')";  
	    
	    Object[] params = new Object[] { p.getEmployeeId() };
	    
	    try {

	    	Employee emp = (Employee) jdbcTemplate.queryForObject(query, params, new EmployeeMapper());
			//
			return emp;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	    
	}

	@Override
	public Employee save(int id) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return null;
	}  

}
