package com.cg.ems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ems.beans.EmployeeBean;
import com.cg.ems.beans.LeaveBean;
import com.cg.ems.beans.UserBean;
import com.cg.ems.exception.EmployeeMaintenanceException;
import com.cg.ems.exception.IExceptionMessages;
import com.cg.ems.util.DBConnection;

public class EmployeeDaoImpl implements IEmployeeDao {
	public Connection conn;
	DBConnection dbconn = new DBConnection();
	PreparedStatement pst;
	static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class);
	
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to search employee details based on employee id.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public EmployeeBean idSearch(String id) throws EmployeeMaintenanceException {
		EmployeeBean ed = null;
		try {
			conn = dbconn.getConnection();
			PropertyConfigurator.configure("resources/log4j.properties");
			pst = conn.prepareStatement(IQueryMapper.IDSEARCH);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			ed = new EmployeeBean();
			while (rs.next()) {
				ed.setEmpId(rs.getString(1));
				ed.setFirstName(rs.getString(2));
				ed.setLastName(rs.getString(3));
				ed.setDepartment(rs.getString(4));
				ed.setEmpGrade(rs.getString(5));
				ed.setEmpDesignation(rs.getString(6));
				logger.info("idSearch");
			}
		} catch (SQLException exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return ed;
	}

	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to search employee details based on employee first name.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public ArrayList<EmployeeBean> firstNameSearch(String firstName) throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = null;
		try {
			conn = dbconn.getConnection();
			pst = conn.prepareStatement(IQueryMapper.FIRSTNAMESEARCH);
			pst.setString(1, firstName);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				EmployeeBean ed = new EmployeeBean();
				ed.setEmpId(rs.getString(1));
				ed.setFirstName(rs.getString(2));
				ed.setLastName(rs.getString(3));
				ed.setDepartment(rs.getString(4));
				ed.setEmpGrade(rs.getString(5));
				ed.setEmpDesignation(rs.getString(6));
				list.add(ed);
			}
		} catch (SQLException exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return list;
	}

	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to search employee details based on employee last name.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public ArrayList<EmployeeBean> lastNameSearch(String lastName) throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = null;
		try {
			conn = dbconn.getConnection();
			pst = conn.prepareStatement(IQueryMapper.LASTNAMESEARCH);
			pst.setString(1, lastName);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				EmployeeBean ed = new EmployeeBean();
				ed.setEmpId(rs.getString(1));
				ed.setFirstName(rs.getString(2));
				ed.setLastName(rs.getString(3));
				ed.setDepartment(rs.getString(4));
				ed.setEmpGrade(rs.getString(5));
				ed.setEmpDesignation(rs.getString(6));
				list.add(ed);
			}
		} catch (SQLException exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return list;

	}

	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to search employee details based on employee department.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public ArrayList<EmployeeBean> deptSearch(String department) throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = null;
		try {
			conn = dbconn.getConnection();
			pst = conn.prepareStatement(IQueryMapper.DEPTSEARCH);
			pst.setString(1, department);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				EmployeeBean ed = new EmployeeBean();
				ed.setEmpId(rs.getString(1));
				ed.setFirstName(rs.getString(2));
				ed.setLastName(rs.getString(3));
				ed.setDepartment(rs.getString(4));
				ed.setEmpGrade(rs.getString(5));
				ed.setEmpDesignation(rs.getString(6));
				list.add(ed);
			}
		} catch (SQLException exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return list;

	}

	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to search employee details based on employee grade.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public ArrayList<EmployeeBean> gradeSearch(String grade) throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = null;
		try {
			conn = dbconn.getConnection();
			pst = conn.prepareStatement(IQueryMapper.GRADESEARCH);
			pst.setString(1, grade);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				EmployeeBean ed = new EmployeeBean();
				ed.setEmpId(rs.getString(1));
				ed.setFirstName(rs.getString(2));
				ed.setLastName(rs.getString(3));
				ed.setDepartment(rs.getString(4));
				ed.setEmpGrade(rs.getString(5));
				ed.setEmpDesignation(rs.getString(6));
				list.add(ed);
			}
		} catch (SQLException exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return list;
	}

	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to search employee details based on employee marital status.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public ArrayList<EmployeeBean> maritalStatusSearch(String maritalStatus) throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> list = null;
		try {
			conn = dbconn.getConnection();
			pst = conn.prepareStatement(IQueryMapper.MARITALSEARCH);
			pst.setString(1, maritalStatus);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				EmployeeBean ed = new EmployeeBean();
				ed.setEmpId(rs.getString(1));
				ed.setFirstName(rs.getString(2));
				ed.setLastName(rs.getString(3));
				ed.setDepartment(rs.getString(4));
				ed.setEmpGrade(rs.getString(5));
				ed.setEmpDesignation(rs.getString(6));
				list.add(ed);
			}
		} catch (SQLException exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return list;
	}

	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to insert leave details into leave_history table.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public int insertLeaveDetails(EmployeeBean ed) throws EmployeeMaintenanceException {
		int val = 0;
		try {
			conn = dbconn.getConnection();
			pst=conn.prepareStatement(IQueryMapper.FETCHLEAVE);
			pst.setString(1, ed.getEmpId());
			if(pst.executeUpdate()==1){
				ResultSet rs=pst.executeQuery();
				while(rs.next()){
					pst = conn.prepareStatement(IQueryMapper.LEAVEDETAILS);
					pst.setString(1, ed.getEmpId());
					pst.setInt(2, rs.getInt(1));
					pst.setInt(3, ed.getDiff());
					pst.setDate(4, Date.valueOf(ed.getFromDate()));
					pst.setDate(5, Date.valueOf(ed.getToDate()));
					pst.setString(6, "applied");
					val = pst.executeUpdate();
				}
			}
			else{
				pst = conn.prepareStatement(IQueryMapper.LEAVEDETAILS);
				pst.setString(1, ed.getEmpId());
				pst.setInt(2, 12);
				pst.setInt(3, ed.getDiff());
				pst.setDate(4, Date.valueOf(ed.getFromDate()));
				pst.setDate(5, Date.valueOf(ed.getToDate()));
				pst.setString(6, "applied");
				val = pst.executeUpdate();
			}
			
		} catch (SQLException exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		}
		return val;
	}
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to get user type based on user login credentials.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public UserBean getUsertype(UserBean user) throws EmployeeMaintenanceException {
		try {
			conn = dbconn.getConnection();
			pst = conn.prepareStatement(IQueryMapper.USERTYPE);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getUserpassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getString(2));
				user.setUserType(rs.getString(1));
			}
		} catch (SQLException exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return user;

	}
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to insert employee details into employee table.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public boolean addEmployee(EmployeeBean emp) throws EmployeeMaintenanceException {
		boolean result = false;
		try {
			conn = dbconn.getConnection();
			pst = conn.prepareStatement(IQueryMapper.ADDEMP);
			pst.setString(1, emp.getEmpId());
			pst.setString(2, emp.getFirstName());
			pst.setString(3, emp.getLastName());
			pst.setDate(13, Date.valueOf(emp.getDob()));
			pst.setDate(14, Date.valueOf(emp.getDoj()));
			pst.setString(4, emp.getEmpDesignation());
			pst.setInt(5, emp.getEmpSalary());
			pst.setString(6, emp.getGender());
			pst.setString(7, emp.getMaritalStatus());
			pst.setString(8, emp.getAddress());
			pst.setString(9, emp.getContactNo());
			pst.setString(10, emp.getManagerId());
			pst.setInt(11, emp.getDeptId());
			pst.setString(12, emp.getEmpGrade());
			int val = pst.executeUpdate();
			if (val == 1)
				result = true;
			else
				result = false;
		} catch (SQLException e) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		}

		return result;
	}
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to check whether employee is present in database or not.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public boolean checkEmpid(String emyid) throws EmployeeMaintenanceException {
		boolean result = false;
		try {
			conn = dbconn.getConnection();
			pst = conn.prepareStatement(IQueryMapper.CHECKEMPID);
			pst.setString(1, emyid);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return result;
	}

	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to check if salary is in the appropriate band or not.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public boolean checkSalary(String grade, int salary) throws EmployeeMaintenanceException {
		boolean result = false;
		try {
			conn = dbconn.getConnection();
			PreparedStatement pst = conn.prepareStatement(IQueryMapper.CHECKSALARY);
			pst.setString(1, grade);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int min = rs.getInt(1);
				int max = rs.getInt(2);
				if (salary >= min && salary <= max) {
					result = true;
				}
			}

		} catch (SQLException e) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}

		return result;
	}
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to modify employee based on given employee id.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public boolean modifyEmployee(EmployeeBean emp) throws EmployeeMaintenanceException {
		boolean result = false;
		try {
			conn = dbconn.getConnection();
			PreparedStatement pst = conn.prepareStatement(IQueryMapper.MODIFYEMP);
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setInt(3, emp.getDeptId());
			pst.setString(4, emp.getEmpGrade());
			pst.setString(5, emp.getEmpDesignation());
			pst.setInt(6, emp.getEmpSalary());
			pst.setString(7, emp.getMaritalStatus());
			pst.setString(8, emp.getAddress());
			pst.setString(9, emp.getContactNo());
			pst.setString(10, emp.getEmpId());
			int val = pst.executeUpdate();
			if (val == 1)
				result = true;
		} catch (SQLException e) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return result;
	}
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to display all employee details.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public ArrayList<EmployeeBean> display() throws EmployeeMaintenanceException {
		ArrayList<EmployeeBean> empList = new ArrayList<EmployeeBean>();
		try {
			conn = dbconn.getConnection();
			pst = conn.prepareStatement(IQueryMapper.DISPLAYALL);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				EmployeeBean e = new EmployeeBean();
				e.setEmpId(rs.getString(1));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setDepartment(rs.getString(4));
				e.setEmpGrade(rs.getString(5));
				e.setEmpDesignation(rs.getString(6));
				empList.add(e);
			}
		} catch (SQLException e) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return empList;
	}
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to apply for leave.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public ArrayList<LeaveBean> leaveHistory(String userId) throws EmployeeMaintenanceException {
		ArrayList<LeaveBean> list = new ArrayList<>();
		try {
			conn = dbconn.getConnection();
			double days = 0;
			pst = conn.prepareStatement(IQueryMapper.LEAVEDECISION);
			pst.setString(1, userId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				LeaveBean lb = new LeaveBean();
				lb.setLeaveId(rs.getInt(1));
				lb.setEmpId(rs.getString(2));
				lb.setLeaveBalance(rs.getInt(3));
				lb.setNoofdays(rs.getInt(4));
				lb.setDateFrom(rs.getDate(5));
				lb.setDateTo(rs.getDate(6));
				lb.setAppliedDate(rs.getDate(7));
				lb.setStatus(rs.getString(8));
				list.add(lb);
			}
		} catch (SQLException e) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return list;
	}
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to approve leave.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public boolean approval(LeaveBean lb) throws EmployeeMaintenanceException {
		boolean result = false;
		try {
			conn = dbconn.getConnection();

				PreparedStatement pst1 = conn.prepareStatement(IQueryMapper.APPROVELEAVE);
				pst1.setInt(1, lb.getNoofdays());
				pst1.setInt(2, lb.getLeaveId());
				int val = pst1.executeUpdate();
				System.out.println(val);
				if (val == 1)
					result = true;
				else
					result = false;
		} catch (SQLException e) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return result;
	}
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to reject leave.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public boolean rejection(LeaveBean lb) throws EmployeeMaintenanceException {
		boolean result = false;
		try {
			conn = dbconn.getConnection();			
				pst = conn.prepareStatement(IQueryMapper.REJECTLEAVE);
				pst.setInt(1, lb.getLeaveId());
				int val = pst.executeUpdate();
				if (val == 1)
					result = true;
				else
					result = false;
		} catch (SQLException e) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}
		return result;
	}
	/**************************************************************************************
	*Project                   : Employee Maintenance System
	*Author Name               : JEE BATCH-1(Capgemini)
	*Description               : Method to calculate how many days completed after applying leave.
	*Created Date        	   : 11-JUL-2018
	**************************************************************************************/
	@Override
	public String calcDays(LeaveBean lb) throws EmployeeMaintenanceException {
		// TODO Auto-generated method stub
		String msg = null;
		try {
		conn = dbconn.getConnection();
		pst = conn.prepareStatement(IQueryMapper.DAYS);
		pst.setInt(1, lb.getLeaveId());
		ResultSet res = pst.executeQuery();
		double days = 0;
		if (res.next())
			days = res.getDouble(1);
		if (days >= 3) {
			pst = conn.prepareStatement(IQueryMapper.APPROVELEAVE);
			pst.setInt(1, lb.getNoofdays());
			pst.setInt(2, lb.getLeaveId());
			pst.executeUpdate();
		} else
			msg = "Employee eligible for leave.Do you approve or reject??";
	}
		catch (SQLException e) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE1);
		} catch (Exception exception) {
			throw new EmployeeMaintenanceException(IExceptionMessages.MESSAGE2);
		}	
return msg;
}
}
