package com.cg.ems.dao;

public interface IQueryMapper {
	public static String IDSEARCH = "SELECT EMP_ID,EMP_FIRST_NAME,EMP_LAST_NAME,DEPT_NAME,EMP_GRADE,EMP_DESIGNATION FROM EMPLOYEE JOIN Department ON EMPLOYEE.EMP_DEPT_ID=DEPARTMENT.DEPT_ID WHERE EMP_ID=?";
	public static String FIRSTNAMESEARCH = "SELECT EMP_ID,EMP_FIRST_NAME,EMP_LAST_NAME,DEPT_NAME,EMP_GRADE,EMP_DESIGNATION FROM EMPLOYEE JOIN Department ON EMPLOYEE.EMP_DEPT_ID=DEPARTMENT.DEPT_ID WHERE EMP_FIRST_NAME=?";
	public static String LASTNAMESEARCH = "SELECT EMP_ID,EMP_FIRST_NAME,EMP_LAST_NAME,DEPT_NAME,EMP_GRADE,EMP_DESIGNATION FROM EMPLOYEE JOIN Department ON EMPLOYEE.EMP_DEPT_ID=DEPARTMENT.DEPT_ID WHERE EMP_LAST_NAME=?";
	public static String DEPTSEARCH = "SELECT EMP_ID,EMP_FIRST_NAME,EMP_LAST_NAME,DEPT_NAME,EMP_GRADE,EMP_DESIGNATION FROM EMPLOYEE JOIN Department ON EMPLOYEE.EMP_DEPT_ID=DEPARTMENT.DEPT_ID WHERE DEPT_NAME=?";
	public static String GRADESEARCH = "SELECT EMP_ID,EMP_FIRST_NAME,EMP_LAST_NAME,DEPT_NAME,EMP_GRADE,EMP_DESIGNATION FROM EMPLOYEE JOIN Department ON EMPLOYEE.EMP_DEPT_ID=DEPARTMENT.DEPT_ID WHERE EMP_GRADE=?";
	public static String MARITALSEARCH = "SELECT EMP_ID,EMP_FIRST_NAME,EMP_LAST_NAME,DEPT_NAME,EMP_GRADE,EMP_DESIGNATION FROM EMPLOYEE JOIN Department ON EMPLOYEE.EMP_DEPT_ID=DEPARTMENT.DEPT_ID WHERE EMP_MARITAL_STATUS=?";
	public static String LEAVEDETAILS = "INSERT INTO LEAVE_HISTORY VALUES(seq_leave_id.nextval,?,?,?,?,?,?,default)";
	public static String USERTYPE = "SELECT user_type,user_id FROM user_master WHERE user_name=? and user_password=?";
	public static String DAYS = "SELECT sysdate - (SELECT applied_date FROM leave_history  WHERE leave_id =?) FROM dual";
	public static String ADDEMP = "INSERT INTO employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String CHECKEMPID = "SELECT emp_id from employee where emp_id=?";
	public static String CHECKSALARY = "SELECT min_salary,max_salary FROM grade_master WHERE grade_code=?";
	public static String MODIFYEMP = "UPDATE employee SET emp_first_name=?,emp_last_name=?,emp_dept_id=?,emp_grade=?,emp_designation=?,emp_basic=?,emp_marital_status=?,emp_home_address=?,emp_contact_num=? WHERE emp_id=?";
	public static String DISPLAYALL = "SELECT EMP_ID,EMP_FIRST_NAME,EMP_LAST_NAME,DEPT_NAME,EMP_GRADE,EMP_DESIGNATION FROM EMPLOYEE JOIN Department ON EMPLOYEE.EMP_DEPT_ID=DEPARTMENT.DEPT_ID ORDER BY EMPLOYEE.EMP_ID";
	public static String LEAVEDECISION = "SELECT l.leave_id,l.emp_id,l.leave_balance,l.noofdays_applied,l.date_from,l.date_to,l.applied_date,l.status FROM leave_history l ,Employee e WHERE e.emp_id = l.emp_id and e.mgr_id=? and status='applied'";
	public static String APPROVELEAVE = "UPDATE leave_history SET status='approved',leave_balance=leave_balance-? WHERE leave_id=?";
	public static String REJECTLEAVE = "UPDATE leave_history SET status='rejected' WHERE leave_id=?";
	public static String FETCHLEAVE = "SELECT leave_balance FROM leave_history WHERE leave_balance=(SELECT min(leave_balance) FROM leave_history where emp_id=?)";
}
