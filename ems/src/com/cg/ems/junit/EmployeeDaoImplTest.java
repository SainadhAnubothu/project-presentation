package com.cg.ems.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.ems.beans.EmployeeBean;
import com.cg.ems.beans.LeaveBean;
import com.cg.ems.beans.UserBean;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.exception.EmployeeMaintenanceException;

public class EmployeeDaoImplTest {

	@Before
	public void setUp() throws EmployeeMaintenanceException {
	}

	@After
	public void tearDown() throws EmployeeMaintenanceException {
	}

	@Test
	public void testIdSearch() throws EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean=daoImpl.idSearch("1001");
		assertEquals("krishnan", employeeBean.getLastName());
		
	}
	
	@Test
	public void failureTestIdSearch() throws EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean=daoImpl.idSearch("1001");
		assertEquals("raju", employeeBean.getFirstName());
		
	}

	@Test
	public void testFirstNameSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.firstNameSearch("seetha");
		assertEquals("M3",arrayList.get(0).getEmpGrade());
	}
	@Test
	public void failureTestFirstNameSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.firstNameSearch("Chandu");
		assertEquals("M4",arrayList.get(0).getEmpGrade());
	}
	
	@Test
	public void testLastNameSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.lastNameSearch("krishnan");
		assertEquals("M6",arrayList.get(0).getEmpGrade());
	}
	@Test
	public void failureTestLastNameSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.lastNameSearch("kumar");
		assertEquals("teamleader",arrayList.get(0).getEmpDesignation());
	}
	
	@Test
	public void testDeptSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl. deptSearch("it");
		assertEquals("raj",arrayList.get(0).getFirstName());
	}
	@Test
	public void failureTestDeptSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl. deptSearch("it");
		assertEquals("kiran",arrayList.get(0).getFirstName());
	}
	
	@Test
	public void testGradeSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.gradeSearch("M6");
		assertEquals("ram",arrayList.get(0).getFirstName());
	}
	@Test
	public void failureTestGradeSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.gradeSearch("M4");
		assertEquals("mumbai",arrayList.get(0).getAddress());
	}

	@Test
	public void testMaritalStatusSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.maritalStatusSearch("M");
		assertEquals("it",arrayList.get(0).getDepartment());
	}
	@Test
	public void failureTestMaritalStatusSearch() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.maritalStatusSearch("M");
		assertEquals("Raj",arrayList.get(0).getLastName());
	}
	
	@Test
	public void testInsertLeaveDetails() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmpId("1004");
		employeeBean.setDiff(3);
		String dob1="13/05/2018";
		String dob2="16/05/2018";
		DateTimeFormatter fr = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");
		LocalDate lcdate = LocalDate.parse(dob1, fr);
	
		LocalDate lcdate2 = LocalDate.parse(dob2, fr);
		employeeBean.setFromDate(lcdate);
		employeeBean.setToDate(lcdate2);
		employeeBean.setStatus("approved");
		 int ptr=daoImpl.insertLeaveDetails(employeeBean);
		assertEquals(1,ptr);
	}
	
	@Test
	public void faiureTestInsertLeaveDetails() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmpId("1004");
		employeeBean.setDiff(3);
		String dob1="13/05/2018";
		String dob2="16/05/2018";
		DateTimeFormatter fr = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");
		LocalDate lcdate = LocalDate.parse(dob1, fr);
	
		LocalDate lcdate2 = LocalDate.parse(dob2, fr);
		employeeBean.setFromDate(lcdate);
		employeeBean.setToDate(lcdate2);
		employeeBean.setStatus("approved");
		 int ptr=daoImpl.insertLeaveDetails(employeeBean);
		assertEquals(1,ptr);
	}
	
	@Test
	public void testdisplay() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.display();
		assertEquals("1001",arrayList.get(0).getEmpId());
	}
	@Test
	public void failureTestdisplay() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		ArrayList<EmployeeBean> arrayList=daoImpl.display();
		assertEquals("2100",arrayList.get(0).getEmpId());
	}
	
	@Test
	public void testGetUserType() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		UserBean userBean2=new UserBean();
		UserBean user=new UserBean();
		user.setUserId("1002");
		user.setUserName("divya");
		user.setUserpassword("divya1002");
		userBean2=daoImpl.getUsertype(user);
		assertEquals("admin", userBean2.getUserType());
	
	}
	@Test
	public void failureTestGetUserType() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		UserBean userBean2=new UserBean();
		UserBean user=new UserBean();
		user.setUserId("1002");
		userBean2=daoImpl.getUsertype(user);
		assertEquals("admin", userBean2.getUserType());
	
	}
	
	
	@Test
	public void testAddEmployee() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmpId("1111");
		employeeBean.setFirstName("Geetha");
		employeeBean.setLastName("parameswaran");
		String dob1="12/02/1996";
		String dob2="20/06/2018";
		DateTimeFormatter fr = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");
		LocalDate lcdate = LocalDate.parse(dob1, fr);
	
		LocalDate lcdate2 = LocalDate.parse(dob2, fr);
		employeeBean.setDob(lcdate);
		employeeBean.setDoj(lcdate2);
		employeeBean.setDeptId(2);
		employeeBean.setEmpGrade("M3");
		employeeBean.setEmpDesignation("Trainee");
		employeeBean.setMaritalStatus("S");
		employeeBean.setEmpSalary(12000);
		employeeBean.setGender("M");
		employeeBean.setAddress("Vizag");
		employeeBean.setContactNo("8883116462");
		employeeBean.setManagerId("1004");
		boolean val=daoImpl.addEmployee(employeeBean);
		assertEquals(true,val);
	}
	@Test
	public void failureTestAddEmployee() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmpId("1009");
		employeeBean.setFirstName("Geetha");
		employeeBean.setLastName("Subramanyam");
		String dob1="10/12/1997";
		String dob2="16/05/2018";
		DateTimeFormatter fr = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");
		LocalDate lcdate = LocalDate.parse(dob1, fr);
	
		LocalDate lcdate2 = LocalDate.parse(dob2, fr);
		employeeBean.setDob(lcdate);
		employeeBean.setDoj(lcdate2);
		employeeBean.setDeptId(2);
		employeeBean.setEmpGrade("M3");
		employeeBean.setEmpDesignation("Trainee");
		employeeBean.setManagerId("1002");
		boolean val=daoImpl.addEmployee(employeeBean);
		assertEquals(false,val);
	}
	
	@Test
	public void testModifyEmployee() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmpId("1009");
		employeeBean.setFirstName("Geetha");
		employeeBean.setLastName("parameswaran");
		String dob1="10/12/1997";
		String dob2="16/05/2018";
		DateTimeFormatter fr = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");
		LocalDate lcdate = LocalDate.parse(dob1, fr);
	
		LocalDate lcdate2 = LocalDate.parse(dob2, fr);
		employeeBean.setDob(lcdate);
		employeeBean.setDoj(lcdate2);
		employeeBean.setDeptId(2);
		employeeBean.setEmpGrade("M3");
		employeeBean.setEmpDesignation("Trainee");
		employeeBean.setMaritalStatus("S");
		employeeBean.setEmpSalary(12000);
		employeeBean.setGender("F");
		employeeBean.setAddress("Vizag");
		employeeBean.setContactNo("8883116462");
		employeeBean.setManagerId("1002");
		boolean val=daoImpl.modifyEmployee(employeeBean);
		assertEquals(true,val);
	}
	@Test
	public void failureTestModifyEmployee() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmpId("1009");
		employeeBean.setFirstName("Geetha");
		employeeBean.setLastName("parameswaran");
		String dob1="10/12/1997";
		String dob2="16/05/2018";
		DateTimeFormatter fr = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");
		LocalDate lcdate = LocalDate.parse(dob1, fr);
	
		LocalDate lcdate2 = LocalDate.parse(dob2, fr);
		employeeBean.setDob(lcdate);
		employeeBean.setDoj(lcdate2);
		employeeBean.setDeptId(2);

		employeeBean.setEmpGrade("M3");
		employeeBean.setEmpDesignation("Trainee");
		boolean val=daoImpl.modifyEmployee(employeeBean);
		assertEquals(false,val);
	}
	

	
	@Test
	public void testApproval() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		
		LeaveBean lb=new LeaveBean();
		lb.setEmpId("1001");
		lb.setLeaveId(96);
		lb.setNoofdays(2);
		boolean value=daoImpl.approval(lb);
		assertEquals(true,value);
	
	}
	@Test
	public void failureTestApproval() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		LeaveBean lb=new LeaveBean();
		lb.setEmpId("1001");
		lb.setLeaveId(96);
		lb.setNoofdays(2);
		boolean value=daoImpl.approval(lb);
		assertEquals(false,value);
	
	}
	
	@Test
	public void testRejection() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		LeaveBean lb=new LeaveBean();
		lb.setEmpId("1001");
		lb.setLeaveId(96);
		lb.setNoofdays(2);
		boolean value=daoImpl.rejection(lb);
		assertEquals(true,value);
	
	}
	@Test
	public void failureTestRejection() throws SQLException, EmployeeMaintenanceException {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		LeaveBean lb=new LeaveBean();
		lb.setEmpId("1001");
		lb.setLeaveId(96);
		lb.setNoofdays(2);
		boolean value=daoImpl.rejection(lb);
		assertEquals(false,value);
	
	}
}
