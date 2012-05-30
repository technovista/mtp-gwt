package com.Exam.shared;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "testobjective")
public class TestObjective implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="testObjectived"
	 */
	@Id
	@Column(name = "testObjectiveId")
	private int testObjectived;
	/**
	 * @uml.property  name="testObjectiveType"
	 */
	@Column(name = "testObjectiveType")
	private String testObjectiveType;
	/**
	 * @uml.property  name="testId"
	 */
	@Column(name ="testId")
	private int testId;
	
	
	public TestObjective(){
		
	}


	/**
	 * @return
	 * @uml.property  name="testObjectived"
	 */
	public int getTestObjectived() {
		return testObjectived;
	}


	/**
	 * @param testObjectived
	 * @uml.property  name="testObjectived"
	 */
	public void setTestObjectived(int testObjectived) {
		this.testObjectived = testObjectived;
	}


	/**
	 * @return
	 * @uml.property  name="testObjectiveType"
	 */
	public String getTestObjectiveType() {
		return testObjectiveType;
	}


	/**
	 * @param testObjectiveType
	 * @uml.property  name="testObjectiveType"
	 */
	public void setTestObjectiveType(String testObjectiveType) {
		this.testObjectiveType = testObjectiveType;
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

	

}
