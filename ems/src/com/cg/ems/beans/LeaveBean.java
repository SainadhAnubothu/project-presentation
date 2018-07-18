package com.cg.ems.beans;

import java.sql.Date;


public class LeaveBean {
private Integer leaveId;
private String empId;
private Integer leaveBalance;
private Integer noofdays;
private Date dateFrom;
private Date dateTo;
private Date appliedDate;
private String status;
public Integer getLeaveId() {
	return leaveId;
}
public void setLeaveId(Integer leaveId) {
	this.leaveId = leaveId;
}
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public Integer getLeaveBalance() {
	return leaveBalance;
}
public void setLeaveBalance(Integer leaveBalance) {
	this.leaveBalance = leaveBalance;
}
public Integer getNoofdays() {
	return noofdays;
}
public void setNoofdays(Integer noofdays) {
	this.noofdays = noofdays;
}
public Date getDateFrom() {
	return dateFrom;
}
public void setDateFrom(Date dateFrom) {
	this.dateFrom = dateFrom;
}
public Date getDateTo() {
	return dateTo;
}
public void setDateTo(Date dateTo) {
	this.dateTo = dateTo;
}
public Date getAppliedDate() {
	return appliedDate;
}
public void setAppliedDate(Date appliedDate) {
	this.appliedDate = appliedDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
} 


}
