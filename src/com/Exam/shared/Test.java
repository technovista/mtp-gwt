package com.Exam.shared;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "test")
public class Test implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="testId"
	 */
	@Id
	@Column(name = "testId")
	private int testId;
	/**
	 * @uml.property  name="testName"
	 */
	@Column(name = "testname")
	private String testName;
	/**
	 * @uml.property  name="passingPercentage"
	 */
	@Column(name ="passingpercentage")
	private int passingPercentage;
	/**
	 * @uml.property  name="totalnumberofquestion"
	 */
	@Column(name ="totalnumberofquestion")
	private int totalnumberofquestion;
	/**
	 * @uml.property  name="testType"
	 */
	@Column(name = "testType")
	private String testType;
	
	public Test(){
		
	}

	/**
	 * @return
	 * @uml.property  name="testId"
	 */
	public int getTestId() {
		return testId;
	}

	/**
	 * @param testId
	 * @uml.property  name="testId"
	 */
	public void setTestId(int testId) {
		this.testId = testId;
	}

	/**
	 * @return
	 * @uml.property  name="testName"
	 */
	public String getTestName() {
		return testName;
	}

	/**
	 * @param testName
	 * @uml.property  name="testName"
	 */
	public void setTestName(String testName) {
		this.testName = testName;
	}

	/**
	 * @return
	 * @uml.property  name="passingPercentage"
	 */
	public int getPassingPercentage() {
		return passingPercentage;
	}

	/**
	 * @param passingPercentage
	 * @uml.property  name="passingPercentage"
	 */
	public void setPassingPercentage(int passingPercentage) {
		this.passingPercentage = passingPercentage;
	}

	/**
	 * @return
	 * @uml.property  name="totalnumberofquestion"
	 */
	public int getTotalnumberofquestion() {
		return totalnumberofquestion;
	}

	/**
	 * @param totalnumberofquestion
	 * @uml.property  name="totalnumberofquestion"
	 */
	public void setTotalnumberofquestion(int totalnumberofquestion) {
		this.totalnumberofquestion = totalnumberofquestion;
	}

	/**
	 * @return
	 * @uml.property  name="testType"
	 */
	public String getTestType() {
		return testType;
	}

	/**
	 * @param testType
	 * @uml.property  name="testType"
	 */
	public void setTestType(String testType) {
		this.testType = testType;
	}
	
	

}
