package com.cg.ems.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.ems.beans.EmployeeBean;
import com.cg.ems.beans.LeaveBean;
import com.cg.ems.beans.UserBean;
import com.cg.ems.exception.EmployeeMaintenanceException;

public interface IEmployeeService {
	public EmployeeBean idSearch(String id) throws EmployeeMaintenanceException;
	public ArrayList<EmployeeBean> firstNameSearch(String firstName) throws EmployeeMaintenanceException;
	public ArrayList<EmployeeBean> lastNameSearch(String lastName) throws EmployeeMaintenanceException;
	public ArrayList<EmployeeBean> deptSearch(String department) throws EmployeeMaintenanceException;
	public ArrayList<EmployeeBean> gradeSearch(String grade) throws EmployeeMaintenanceException;
	public ArrayList<EmployeeBean> maritalStatusSearch(String maritalStatus) throws EmployeeMaintenanceException;
	public int insertLeaveDetails(EmployeeBean ed) throws EmployeeMaintenanceException;
	public UserBean getUserType(UserBean user) throws EmployeeMaintenanceException;
	public boolean addEmployee(EmployeeBean emp) throws EmployeeMaintenanceException;
	public boolean checkEmpid(String emyid) throws EmployeeMaintenanceException;
	public boolean checkSalary(String grade, int salary) throws EmployeeMaintenanceException;
	public boolean modifyEmployee(EmployeeBean emp) throws EmployeeMaintenanceException;
	public ArrayList<EmployeeBean> display() throws EmployeeMaintenanceException;
	public ArrayList<LeaveBean> leaveHistory(String userId) throws EmployeeMaintenanceException;
	public boolean approval(LeaveBean lb) throws EmployeeMaintenanceException;
	public boolean rejection(LeaveBean lb)throws EmployeeMaintenanceException;
	public String calcDays(LeaveBean lb) throws EmployeeMaintenanceException;
}
