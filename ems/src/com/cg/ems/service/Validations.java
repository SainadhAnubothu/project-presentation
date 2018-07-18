package com.cg.ems.service;

import java.util.regex.Pattern;

public class Validations {

public boolean id(String empid){
	boolean res=false;
	if(Pattern.matches("[1-9][0-9][0-9][0-9]",empid))
		res=true;
	return res;
}
public boolean choice(String choice){
	boolean res=false;
	if(Pattern.matches("[0-9]",choice))
		res=true;
	return res;
}
public boolean fname(String fName){
	boolean res=false;
	if(Pattern.matches("^[A-Z][a-zA-Z]*$",fName))
		res=true;
	
	return res;
}
public boolean lname(String lName){
	boolean res=false;
	if(Pattern.matches("^[A-Z][a-zA-Z]*$",lName))
		res=true;
	
	return res;
}
public boolean grade(String gc){
	boolean res=false;
	if(Pattern.matches("^[M][1-7]",gc))
		res=true;
	return res;
}
public boolean designation(String desig){
	boolean res=false;
	if(Pattern.matches("^[a-zA-Z ]{1,50}$",desig))
		res=true;
	return res;
}
public boolean gender(String gender){
	boolean res=false;
	if(Pattern.matches("M|F",gender))
		res=true;
	return res;
}
public boolean marital(String ms){
	boolean res=false;
	if(Pattern.matches("M|S|W|D",ms))	
		res=true;
	return res;
}
public boolean address(String add){
	boolean res=false;
	if(Pattern.matches("^[a-zA-Z0-9-_ ]{1,100}$",add))
		res=true;
	return res;
}
public boolean contact(String contactNo){
	boolean res=false;
	if(Pattern.matches("^[7-9]{1}[0-9]{9}$",contactNo))
		res=true;
	return res;
}
}
