package com.pos.shared;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name="testtaker")
public class User   implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="testTakerId"
	 */
	@Id 
	@Column(name="testtakerid")
	private int testTakerId;
	/**
	 * @uml.property  name="emailId"
	 */
	@Column(name = "emailId")
	private String emailId;
	/**
	 * @uml.property  name="password"
	 */
	@Column(name = "password")
	private String password;
	/**
	 * @uml.property  name="isAdmin"
	 */
	@Column(name = "isAdmin")
	private int isAdmin;
	/**
	 * @uml.property  name="firstName"
	 */
	@Column(name = "firstName")
	private String firstName;
	/**
	 * @uml.property  name="lastName"
	 */
	@Column(name = "lastName")
	private String lastName;
	
		
	
	public User(){}



	/**
	 * @return
	 * @uml.property  name="testTakerId"
	 */
	public int getTestTakerId() {
		return testTakerId;
	}

	/**
	 * @param testTakerId
	 * @uml.property  name="testTakerId"
	 */
	public void setTestTakerId(int testTakerId) {
		this.testTakerId = testTakerId;
	}



	/**
	 * @return
	 * @uml.property  name="emailId"
	 */
	public String getEmailId() {
		return emailId;
	}



	/**
	 * @param emailId
	 * @uml.property  name="emailId"
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	/**
	 * @return
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password
	 * @uml.property  name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return
	 * @uml.property  name="isAdmin"
	 */
	public int getIsAdmin() {
		return isAdmin;
	}



	/**
	 * @param isAdmin
	 * @uml.property  name="isAdmin"
	 */
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}



	/**
	 * @return
	 * @uml.property  name="firstName"
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName
	 * @uml.property  name="firstName"
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return
	 * @uml.property  name="lastName"
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @param lastName
	 * @uml.property  name="lastName"
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
