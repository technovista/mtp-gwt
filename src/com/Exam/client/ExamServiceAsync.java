package com.Exam.client;

import java.util.ArrayList;

import com.Exam.shared.Test;
import com.Exam.shared.TestObjective;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExamServiceAsync {
	void myfirstmethod(AsyncCallback asyncCallback);
	void signIn(String userid, String password, AsyncCallback<String> callback);
	void fetchTestTypes(AsyncCallback<ArrayList<Test>> callback);
	void fetchTestSubTypes(int testId, AsyncCallback<ArrayList<TestObjective>> callback);
}
