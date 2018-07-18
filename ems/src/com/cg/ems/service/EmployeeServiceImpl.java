package com.cg.ems.service;

import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;

import com.cg.ems.beans.EmployeeBean;
import com.cg.ems.beans.LeaveBean;
import com.cg.ems.beans.UserBean;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.dao.IEmployeeDao;
import com.cg.ems.exception.EmployeeMaintenanceException;

public class EmployeeServiceImpl implements IEmployeeService{
	IEmployeeDao di = new EmployeeDaoImpl();

	@Override
	public EmployeeBean idSearch(String id) throws EmployeeMaintenanceException {
		EmployeeBean ed = new EmployeeBean();
		ed = di.idSearch(id);
		return ed;

	}

	@Override
	public ArrayList<EmployeeBean> firstNameSearch(String firstName)
			throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = new ArrayList<>();
		list = di.firstNameSearch(firstName);
		return list;
	}

	@Override
	public ArrayList<EmployeeBean> lastNameSearch(String lastName)
			throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = new ArrayList<>();
		list = di.lastNameSearch(lastName);
		return list;
	}

	@Override
	public ArrayList<EmployeeBean> deptSearch(String department)
			throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = new ArrayList<>();
		list = di.deptSearch(department);
		return list;
	}

	@Override
	public ArrayList<EmployeeBean> gradeSearch(String grade)
			throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = new ArrayList<>();
		list = di.gradeSearch(grade);
		return list;
	}

	@Override
	public ArrayList<EmployeeBean> maritalStatusSearch(String maritalStatus)
			throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = new ArrayList<>();
		list = di.maritalStatusSearch(maritalStatus);
		return list;

	}

	@Override
	public int insertLeaveDetails(EmployeeBean ed) throws EmployeeMaintenanceException {
		return di.insertLeaveDetails(ed);
	}

	@Override
	public UserBean getUserType(UserBean user) throws
			EmployeeMaintenanceException {

		return di.getUsertype(user);
	}

	@Override
	public boolean addEmployee(EmployeeBean emp) throws
			EmployeeMaintenanceException {
	
		 return di.addEmployee(emp);

	}

	@Override
	public boolean checkEmpid(String emyid) throws EmployeeMaintenanceException {
		boolean result=di.checkEmpid(emyid);
		return result;
	}

	@Override
	public boolean checkSalary(String grade, int salary) throws EmployeeMaintenanceException {
		return di.checkSalary(grade,salary);
	}

	@Override
	public boolean modifyEmployee(EmployeeBean emp) throws EmployeeMaintenanceException {
		return di.modifyEmployee(emp);
	}

	@Override
	public ArrayList<EmployeeBean> display() throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list=new ArrayList<EmployeeBean>();
		list= di.display();
		return list;
	}

	@Override
	public ArrayList<LeaveBean> leaveHistory(String userId) throws EmployeeMaintenanceException{
		return di.leaveHistory(userId);
		
	}

	@Override
	public boolean approval(LeaveBean lb) throws EmployeeMaintenanceException{
		// TODO Auto-generated method stub
		return di.approval(lb);
	}

	@Override
	public boolean rejection(LeaveBean lb) throws EmployeeMaintenanceException{
		// TODO Auto-generated method stub
		return di.rejection(lb);
	}

	@Override
	public String calcDays(LeaveBean lb) throws EmployeeMaintenanceException{
		// TODO Auto-generated method stub
		return di.calcDays(lb);
	}
}
