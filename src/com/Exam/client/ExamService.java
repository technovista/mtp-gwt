package com.Exam.client;

import java.util.ArrayList;

import com.Exam.shared.Test;
import com.Exam.shared.TestObjective;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MyWebServlet")
public interface ExamService extends RemoteService {
	void myfirstmethod();
	String signIn(String userid, String password) throws Exception;
	ArrayList<Test> fetchTestTypes() throws Exception;
	ArrayList<TestObjective> fetchTestSubTypes(int testId) throws Exception;


}
