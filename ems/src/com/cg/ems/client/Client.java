package com.cg.ems.client;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.ems.beans.EmployeeBean;
import com.cg.ems.beans.LeaveBean;
import com.cg.ems.beans.UserBean;
import com.cg.ems.service.EmployeeServiceImpl;
import com.cg.ems.service.IEmployeeService;
import com.cg.ems.service.Validations;

public class Client {
	public static void main(String[] args) {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("***************************** EMPLOYEE MAINTENANCE SYSTEM ******************************");
		System.out.println("----------------------------------------------------------------------------------------");
		try {
			UserBean user = new UserBean();
			EmployeeBean emp = new EmployeeBean();
			IEmployeeService empserv = new EmployeeServiceImpl();
			String uname;
			String pwd;
			String usertype = "";
			Scanner sc = new Scanner(System.in);
			System.out.println("Employee Maintenance System");
			System.out.println();
			System.out.println("Enter your username:");
			uname = sc.next();
			System.out.println("Enter your password:");
			pwd = sc.next();
			Validations valid = new Validations();
			user.setUserName(uname);
			user.setUserpassword(pwd);

			UserBean userBean = empserv.getUserType(user);
			/**************************************************************************************
			*Project                   : Employee Maintenance System
			*Author Name               : JEE BATCH-1(Capgemini)
			*Description               : Logic to check the credentials of user.
			*Created Date        	   : 11-JUL-2018
			**************************************************************************************/
			if(userBean.getUserType()==null){
				System.err.println("No such user exists");
			}
			/**************************************************************************************
			*Project                   : Employee Maintenance System
			*Author Name               : JEE BATCH-1(Capgemini)
			*Description               : Admin privileges.
			*Created Date        	   : 11-JUL-2018
			**************************************************************************************/
			else if (userBean.getUserType().equalsIgnoreCase("admin")) {
				System.out.println("Welcome" + " " + userBean.getUserName());
				String choice = "";
				do {
					System.out.println("Select any one as a Admin you can perform !!");
					System.out.println("1.Add Employee");
					System.out.println("2.Modify Employee");
					System.out.println("3.Display Employee");
					System.out.println("4.Approve Leave");
					System.out.println("5.Exit");
					System.out.println("choose one :");
					choice = sc.next();
					boolean resultchoice = false;
					do {
						resultchoice = valid.choice(choice);
						if (resultchoice) {
							break;
						} else
							resultchoice = true;
						System.err.println("Enter choice again.It should not be string or characters!!");
						choice = sc.next();
					} while (resultchoice);
					switch (Integer.parseInt(choice)) {
					case 1:
						System.out.println("Enter employee id");
						String empid = sc.next();
						boolean res = false;
						do {
							res = valid.id(empid);
							if (res) {
								emp.setEmpId(empid);
								break;
							} else
								res = true;
							System.err.println("Enter employee Id again.Should not start with 0 and should have 4 characters!!");
							empid = sc.next();
							emp.setEmpId(empid);
						} while (res);

						System.out.println("Enter the firstname");
						String fn = sc.next();
						boolean res1 = false;
						do {
							res1 = valid.fname(fn);
							if (res1) {
								emp.setFirstName(fn);
								break;
							}

							else
								res1 = true;
							System.err
									.println("Enter employee First Name again. First Letter must be capital!!");
							fn = sc.next();
							emp.setFirstName(fn);
						} while (res1);

						System.out.println("Enter the lastname");
						String ln = sc.next();
						boolean res2 = false;
						do {
							res2 = valid.lname(ln);
							if (res2) {
								emp.setLastName(ln);
								break;
							} else
								res2 = true;
							System.err
									.println("Enter employee Last Name again!!");
							ln = sc.next();
							emp.setLastName(ln);
						} while (res2);

						System.out.println("Enter the date of birth(format should be dd/MM/yyyy)");
						String dob = sc.next();
						DateTimeFormatter fr = DateTimeFormatter
								.ofPattern("dd/MM/yyyy");
						LocalDate lcdate = LocalDate.parse(dob, fr);
						emp.setDob(lcdate);
						System.out.println("Enter the date of joining(format should be dd/MM/yyyy)");
						String doj = sc.next();
						DateTimeFormatter f = DateTimeFormatter
								.ofPattern("dd/MM/yyyy");
						LocalDate ldate = LocalDate.parse(doj, f);
						boolean res4 = false;
						do {
							Period age = Period.between(lcdate, ldate);
							if (ldate.isAfter(lcdate) && age.getYears() >= 18
									&& age.getYears() <= 58) {
								emp.setDoj(ldate);
								break;
							}

							else
								res4 = true;
							System.err
									.println("Enter the date of joining  again.It should be after date of birth and age should be between 18 and 58!!");
							doj = sc.next();
							f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							ldate = LocalDate.parse(doj, f);
							emp.setDoj(ldate);

						} while (res4);

						System.out.println("Enter the Designation");
						String desig = sc.next();
						boolean res6 = false;
						do {
							res6 = valid.designation(desig);
							if (res6) {
								emp.setEmpDesignation(desig);
								break;
							} else
								res6 = true;
							System.err
									.println("Enter employee designation again!!");
							desig = sc.next();
							emp.setEmpDesignation(desig);
						} while (res6);
						System.out.println("Enter the basic");
						int basic = sc.nextInt();
						emp.setEmpSalary(basic);
						System.out
								.println("Enter the gender M for male F for female");
						String gender = sc.next();

						boolean res7 = false;
						do {
							res7 = valid.gender(gender);
							if (res7) {
								emp.setGender(gender);
								break;
							} else
								res7 = true;
							System.err.println("Enter employee gender again!!");
							gender = sc.next();
							emp.setGender(gender);
						} while (res7);
						System.out
								.println("Enter marital status M-married D-Divorsed S-Single W-widowed ");
						String ms = sc.next();

						boolean res8 = false;
						do {
							res8 = valid.marital(ms);
							if (res8) {
								emp.setMaritalStatus(ms);
								;
								break;
							} else
								res8 = true;
							System.err
									.println("Enter employee marital status again!!");
							ms = sc.next();
							emp.setMaritalStatus(ms);
						} while (res8);
						System.out.println("Enter address");
						String add = sc.next();
						boolean res9 = false;
						do {
							res9 = valid.address(add);
							if (res9) {
								emp.setAddress(add);
								break;
							} else
								res9 = true;
							System.err
									.println("Enter employee address again.It should be less than 100 characters!!");
							add = sc.next();
							emp.setAddress(add);
						} while (res9);

						System.out.println("Enter contact number");
						String contactNo = sc.next();

						boolean res10 = false;
						do {
							res10 = valid.contact(contactNo);
							if (res10) {
								emp.setContactNo(contactNo);
								break;
							} else
								res10 = true;
							System.err
									.println("Enter employee Contact Number again.Should not have more than 10!!");
							contactNo = sc.next();
							emp.setContactNo(contactNo);
						} while (res10);

						System.out.println("Enter manager Id");
						String mid = sc.next();

						boolean res11 = false;
						do {
							res11 = valid.id(mid);
							if (res11) {
								emp.setManagerId(mid);
								break;
							} else
								res11 = true;
							System.err
									.println("Enter Manager Id again. It Should not start with 0 and should have 4 characters!!");
							mid = sc.next();
							emp.setManagerId(mid);
						} while (res11);

						System.out.println("Enter dept Id");
						int did = sc.nextInt();

						emp.setDeptId(did);
						System.out.println("Enter grade code");
						String gc = sc.next();
						boolean res5 = false;
						do {
							res5 = valid.grade(gc);
							if (res5) {
								emp.setEmpGrade(gc);
								break;
							} else
								res5 = true;
							System.err
									.println("Enter employee Grade again. It should be between M1-M7!!");
							gc = sc.next();
							emp.setEmpGrade(gc);
						} while (res5);
						boolean result = empserv.addEmployee(emp);
						if (result) {
							System.out.println();
							System.out
									.println("Inserted into database Successfully !!");
						} else {
							System.out.println();
							System.out.println("Not inserted into database !!");
						}
						break;
					case 2:
						System.out.println("Enter the employee id");
						String emyid = sc.next();

						boolean res3 = empserv.checkEmpid(emyid);
						if (res3) {
							emp.setEmpId(emyid);
							System.out.println("Enter the firstname");
							String first = sc.next();

							boolean res12 = false;
							do {
								res12 = valid.fname(first);
								if (res12) {
									emp.setFirstName(first);
									break;
								}

								else
									res12 = true;
								System.err
										.println("Enter employee First Name again. First Letter must be capital!!");
								first = sc.next();
								emp.setFirstName(first);
							} while (res12);

							System.out.println("Enter the lastname");
							String last = sc.next();
							boolean res13 = false;
							do {
								res13 = valid.lname(last);
								if (res13) {
									emp.setLastName(last);
									break;
								} else
									res13 = true;
								System.err
										.println("Enter employee Last Name again!!");
								last = sc.next();
								emp.setLastName(last);
							} while (res13);

							System.out.println("Enter dept Id");
							int departid = sc.nextInt();
							emp.setDeptId(departid);

							System.out.println("Enter grade code");
							String grade = sc.next();
							boolean res14 = false;
							do {
								res14 = valid.grade(grade);
								if (res14) {
									emp.setEmpGrade(grade);
									break;
								} else
									res14 = true;
								System.err
										.println("Enter employee Grade again should be between M1-M7!!");
								grade = sc.next();
								emp.setEmpGrade(grade);
							} while (res14);

							System.out.println("Enter the basic ");
							int salary = sc.nextInt();
							boolean res15 = false;
							do {
								res15 = empserv.checkSalary(grade, salary);
								if (res15) {
									emp.setEmpSalary(salary);
									break;
								} else
									res15 = true;
								System.err
										.println("Enter employee salary again.It should match with the salary of grade band!!");
								salary = sc.nextInt();
							} while (res15);
							System.out.println("Enter the Designation");
							String designation = sc.next();
							boolean res16 = false;
							do {
								res16 = valid.designation(designation);
								if (res16) {
									emp.setEmpDesignation(designation);
									break;
								} else
									res16 = true;
								System.err
										.println("Enter employee designation again!!");
								designation = sc.next();
								emp.setEmpDesignation(designation);
							} while (res16);

							System.out
									.println("Enter marital status M-married D-Divorsed S-Single W-widowed ");
							String maritals = sc.next();
							boolean res17 = false;
							do {
								res17 = valid.marital(maritals);
								if (res17) {
									emp.setMaritalStatus(maritals);
									break;
								} else
									res17 = true;
								System.err
										.println("Enter employee marital status again!!");
								maritals = sc.next();
								emp.setMaritalStatus(maritals);
							} while (res17);

							System.out.println("Enter address");
							String address = sc.next();
							boolean res18 = false;
							do {
								res18 = valid.address(address);
								if (res18) {
									emp.setAddress(address);
									break;
								} else
									res18 = true;
								System.err
										.println("Enter employee address again.It should be less than 100 characters!!");
								address = sc.next();
								emp.setAddress(address);
							} while (res18);

							System.out.println("Enter contact number");
							String contactNum = sc.next();
							boolean res19 = false;
							do {
								res19 = valid.contact(contactNum);
								if (res19) {
									emp.setContactNo(contactNum);
									break;
								} else
									res19 = true;
								System.err
										.println("Enter employee Contact Number again.Should not have more than 10!!");
								contactNum = sc.next();
								emp.setContactNo(contactNum);
							} while (res19);

							if (empserv.modifyEmployee(emp)) {
								System.out.println();
								System.out.println("Modified Successfully !!");
							} else
								System.out.println("Not Modified !!");
						} else {
							System.out.println();
							System.out.println("Details Not Found !!");
						}
						break;
					case 3:
						ArrayList<EmployeeBean> empList = new ArrayList<EmployeeBean>();
						empList = empserv.display();
						System.out.println();
						System.out.println("Employee Details are:");
						if(empList.isEmpty()){
							System.err.println("There are no records");
						}
						else{
						for (EmployeeBean employeeDetails : empList) {
							System.out.println();
							System.out.println(employeeDetails.getEmpId() + " "
									+ employeeDetails.getFirstName() + " "
									+ employeeDetails.getLastName() + " "
									+ employeeDetails.getDepartment() + " "
									+ employeeDetails.getEmpGrade() + " "
									+ employeeDetails.getEmpDesignation());
						}
						}
						break;
					case 4:
						ArrayList<LeaveBean> list = new ArrayList<>();
						list = empserv.leaveHistory(user.getUserId());
						if (list.isEmpty()) {
							System.out.println();
							System.out
									.println("There are no pending records to approve or reject !!");
						} else {
							System.out.println();
							System.out.println("Leave applied employees data");
							for (LeaveBean leaveBean : list) {

								System.out.println();
								System.out.println();
								System.out.println();
								System.out.printf("%10s %10s %15s %15s %15s %20s %15s %12s","LeaveId","Emp_id","Leavebalance","Date From","Date To","No Of Days Applied","AppliedDate","Status");
								System.out.println();
								System.out.printf("%10s %10s %15d %17s %15s %15d %17s %13s",leaveBean.getLeaveId(),leaveBean.getEmpId(),leaveBean.getLeaveBalance(),leaveBean.getDateFrom(), leaveBean.getDateTo(),leaveBean.getNoofdays(),leaveBean.getAppliedDate(),leaveBean.getStatus());
								System.out.println();
								String msg = empserv.calcDays(leaveBean);
								System.out.println(msg);
								System.out.println();
								System.out.println("1)Approve" + "\n"
										+ "2)Reject");
								int choice1 = sc.nextInt();
								if (choice1 == 1) {
									if (empserv.approval(leaveBean)) {
										System.out.println();
										System.out.println("Leave approved");
									}

								} else if (choice1 == 2) {
									if (empserv.rejection(leaveBean)) {
										System.out.println();
										System.out.println("Leave rejected");
									}
								}
							}
						}
						break;
					case 5:
						System.out.println("Thank You !!");
						System.exit(0);
						break;
					default:
						System.err.println("You have entered a wrong input");
	
							
					}
				} while (Integer.parseInt(choice) != 5);
			} 
			/**************************************************************************************
			*Project                   : Employee Maintenance System
			*Author Name               : JEE BATCH-1(Capgemini)
			*Description               : User privileges.
			*Created Date        	   : 11-JUL-2018
			**************************************************************************************/
			else if (userBean.getUserType().equalsIgnoreCase("user")) {
				
				System.out.println();
				System.out.println("Welcome" + " " + userBean.getUserName());
				System.out.println();
				System.out
						.println("Select any one as a User you can perform !!");
				ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
				EmployeeBean ed = new EmployeeBean();
				ed.setEmployeeType("user");
				if (ed.getEmployeeType().equalsIgnoreCase("User")) {
					IEmployeeService si = new EmployeeServiceImpl();
					int choice;
					do {
						System.out.println();
						System.out.println("Enter the operation required\n");
						System.out.println("1)Search Details" + "\n"
								+ "2)Apply for Leave" + "\n" + "3)Exit");
						choice = sc.nextInt();

						switch (choice) {
						case 1:
							System.out
									.println("Enter parameter in any one of the fields mentioned below");
							System.out.println("1)Id" + "\n" + "2)First Name"
									+ "\n" + "3)Last Name" + "\n"
									+ "4)Department" + "\n" + "5)Grade" + "\n"
									+ "6)Marital Status");
							int search = sc.nextInt();
							switch (search) {
							case 1:
								System.out.println("Enter the Employee Id");
								String id = sc.next();
								ed = si.idSearch(id);
								
								if(ed==null){
									System.out.println("There is no employee data for the given id");
								}
								else{
								System.out.println();
								System.out
										.println("Details of employees having employee id as "
												+ id);
								System.out.println(ed.getEmpId() + " "
										+ ed.getFirstName() + " "
										+ ed.getLastName() + " "
										+ ed.getDepartment() + " "
										+ ed.getEmpGrade() + " "
										+ ed.getEmpDesignation());
								}
								break;
							case 2:
								System.out.println();
								System.out
										.println("Enter the Employee First Name");
								String fname = sc.next();
								list = si.firstNameSearch(fname);
								if(list.isEmpty()){
									System.out.println("There is no Employee Data for the given first name!!");
								}
								else{
								System.out.println();
								System.out
										.println("Details of employees having first name as"
												+ " " + fname);
								for (EmployeeBean employeeDetails : list) {
									System.out.println(employeeDetails
											.getEmpId()
											+ " "
											+ employeeDetails.getFirstName()
											+ " "
											+ employeeDetails.getLastName()
											+ " "
											+ employeeDetails.getDepartment()
											+ " "
											+ employeeDetails.getEmpGrade()
											+ " "
											+ employeeDetails
													.getEmpDesignation());
									System.out.println("\n");
								}
								}
								break;
							case 3:
								System.out.println();
								System.out
										.println("Enter the Employee Last Name");
								String lname = sc.next();
								list = si.lastNameSearch(lname);
								if(list.isEmpty()){
									System.out.println("There is no Employee Data for the given last name!!");
								}
								else{
								System.out.println();
								System.out
										.println("Details of employees having last name as"
												+ " " + lname);
								for (EmployeeBean employeeDetails : list) {
									System.out.println(employeeDetails
											.getEmpId()
											+ " "
											+ employeeDetails.getFirstName()
											+ " "
											+ employeeDetails.getLastName()
											+ " "
											+ employeeDetails.getDepartment()
											+ " "
											+ employeeDetails.getEmpGrade()
											+ " "
											+ employeeDetails
													.getEmpDesignation());
									System.out.println("\n");
								}
								}
								break;
							case 4:
								System.out.println();
								System.out.println("Enter the Department");
								String dept = sc.next();
								list = si.deptSearch(dept);
								if(list.isEmpty()){
									System.out.println("There is no Employee Data for the given department name!!");
								}
								else{
								System.out.println();
								System.out
										.println("Details of employees having department as"
												+ " " + dept);
								for (EmployeeBean employeeDetails : list) {
									System.out.println(employeeDetails
											.getEmpId()
											+ " "
											+ employeeDetails.getFirstName()
											+ " "
											+ employeeDetails.getLastName()
											+ " "
											+ employeeDetails.getDepartment()
											+ " "
											+ employeeDetails.getEmpGrade()
											+ " "
											+ employeeDetails
													.getEmpDesignation());
									System.out.println("\n");
								}
								}
								break;
							case 5:
								System.out.println();
								System.out.println("Grade");
								String grade = sc.next();

								list = si.gradeSearch(grade);
								if(list.isEmpty()){
									System.out.println("There is no Employee Data for the given grade !!");
								}
								else{
								System.out.println();
								System.out
										.println("Details of employees having grade as"
												+ " " + grade);
								for (EmployeeBean employeeDetails : list) {
									System.out.println(employeeDetails
											.getEmpId()
											+ " "
											+ employeeDetails.getFirstName()
											+ " "
											+ employeeDetails.getLastName()
											+ " "
											+ employeeDetails.getDepartment()
											+ " "
											+ employeeDetails.getEmpGrade()
											+ " "
											+ employeeDetails
													.getEmpDesignation());
									System.out.println("\n");
								}
								}
								break;
							case 6:
								System.out.println();
								System.out.println("Enter marital status");
								String mStatus = sc.next();
								list = si.maritalStatusSearch(mStatus);
								if(list.isEmpty()){
									System.out.println("There is no Employee Data for the given marital status!!");
								}
								else{
								System.out.println();
								System.out
										.println("Details of employees having marital status as"
												+ " " + mStatus);
								for (EmployeeBean employeeDetails : list) {
									System.out.println(employeeDetails
											.getEmpId()
											+ " "
											+ employeeDetails.getFirstName()
											+ " "
											+ employeeDetails.getLastName()
											+ " "
											+ employeeDetails.getDepartment()
											+ " "
											+ employeeDetails.getEmpGrade()
											+ " "
											+ employeeDetails
													.getEmpDesignation());
									System.out.println("\n");
								}
									break;
							}
								break;
							default:
								System.err.println("You have entered a wrong input");
							}
							break;
						case 2:
							System.out.println();
							System.out
									.println("Enter the date from which you want leave");
							String fd = sc.next();
							DateTimeFormatter dtf = DateTimeFormatter
									.ofPattern("dd/MM/yyyy");
							LocalDate ld = LocalDate.parse(fd, dtf);
							ed.setFromDate(ld);
							ed.setEmpId(userBean.getUserId());
							System.out
									.println("Enter the date up to which you want leave");
							String td = sc.next();
							LocalDate ld1 = LocalDate.parse(td, dtf);
							ed.setToDate(ld1);
							int diff = (int) ChronoUnit.DAYS.between(ld, ld1);
							ed.setDiff(diff);
							int val = si.insertLeaveDetails(ed);
							if (val == 1)
								System.out
										.println("Successfully leave details are persisted !!");
							else
								System.out
										.println("Failed to persist the leave details !!");
							break;
						case 3:
							System.out.println("Thank You !!");
							System.exit(0);
						default:
							System.out.println("You have entered wrong input");
						}
					} while (choice != 3);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
