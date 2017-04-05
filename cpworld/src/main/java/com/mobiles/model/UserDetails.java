package com.mobiles.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;



@Entity
public class UserDetails {
@Id
private String userid;
private boolean isenabled;
private String role;
@NotEmpty(message="User Name is mandatory")
private String firstname;
private String lastname;
private String email;
private Date dateofBirth;
private String password;
private String contact;
private String address;
private String city;
private String zipcode;
private String country;
@Transient
private MultipartFile imagefile;
public MultipartFile getImagefile() {
	return imagefile;
}
public void setImagefile(MultipartFile imagefile) {
	this.imagefile = imagefile;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public boolean isIsenabled() {
	return isenabled;
}
public void setIsenabled(boolean isenabled) {
	this.isenabled = isenabled;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDateofBirth() {
	return dateofBirth;
}
public void setDateofBirth(Date dateofBirth) {
	this.dateofBirth = dateofBirth;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

}
