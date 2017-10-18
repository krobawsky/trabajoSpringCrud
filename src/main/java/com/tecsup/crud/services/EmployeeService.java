package com.tecsup.crud.services;

import com.tecsup.crud.exception.DAOException;
import com.tecsup.crud.exception.EmptyResultException;
import com.tecsup.crud.model.Employee;

public interface EmployeeService {
	
	Employee find(int employee_id) throws DAOException, EmptyResultException;

}
