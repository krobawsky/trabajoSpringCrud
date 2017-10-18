package com.tecsup.crud.dao;

import com.tecsup.crud.exception.DAOException;
import com.tecsup.crud.exception.EmptyResultException;
import com.tecsup.crud.model.Employee;

public interface EmployeeDAO {

	Employee findEmployee(int id) throws DAOException, EmptyResultException;
	
	Employee save(Employee emp) throws DAOException, EmptyResultException;

	Employee save(int id) throws DAOException, EmptyResultException;
	
}
