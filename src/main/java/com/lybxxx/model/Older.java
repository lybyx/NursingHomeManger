package com.lybxxx.model;

/**
 * @author lybxxx
 * 
 */
public class Older {
  int  id;
  String name;
  String sex;
  String family;
  String phone;
  int dormitory=-1;
  int bed;
  
  
  
public Older(String name) {
	super();
	this.name = name;
}
public Older(int id, String name, String sex, String family,
		String phone, int dormitory, int bed) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.family = family;
	this.phone = phone;
	this.dormitory = dormitory;
	this.bed = bed;
}
public Older(String name, String sex, String family, String phone,
		int dormitory, int bed) {
	super();
	this.name = name;
	this.sex = sex;
	this.family = family;
	this.phone = phone;
	this.dormitory = dormitory;
	this.bed = bed;
}
public Older() {
	super();
}
public Older(String name, String sex, String family, String phone,
		int dormitory) {
	super();
	this.name = name;
	this.sex = sex;
	this.family = family;
	this.phone = phone;
	this.dormitory = dormitory;
	this.bed = bed;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getFamily() {
	return family;
}
public void setFamily(String family) {
	this.family = family;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getDormitory() {
	return dormitory;
}
public void setDormitory(int dormitory) {
	this.dormitory = dormitory;
}
public int getBed() {
	return bed;
}
public void setBed(int bed) {
	this.bed = bed;
}

  
}
