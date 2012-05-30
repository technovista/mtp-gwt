package com.Exam.client.presenter;

import java.util.ArrayList;

import com.Exam.client.ExamServiceAsync;
import com.Exam.client.view.TestSubTypesWIdget;
import com.Exam.shared.Test;
import com.Exam.shared.TestObjective;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


public class TestListPresenter implements Presenter 

{
	/**
	 * @uml.property  name="rpcService"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final ExamServiceAsync rpcService;
	/**
	 * @uml.property  name="eventBus"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final HandlerManager eventBus;
	/**
	 * @uml.property  name="display"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final Display display;

	public interface Display 
	{
		Widget asWidget();
		void createTestList(ArrayList<Test> result);
		void createSubTestList(ArrayList<TestObjective> result);
		HasClickHandlers getBtnSubmit();
		ArrayList<RadioButton> getListRadios();
		TestSubTypesWIdget getSubTypeWidget() ;
		void selectAllCheckBoxes(boolean select);
	}  

	public TestListPresenter(ExamServiceAsync rpcService, HandlerManager eventBus, Display view) 
	{
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
	}

	public void go(HasWidgets container) 
	{
		container.clear();
		container.add(display.asWidget());
		fetchTestTypes();
		bind();
	}

	private void bind() {
		
		display.getSubTypeWidget().getChkAllSubTypes().addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				if(display.getSubTypeWidget().getChkAllSubTypes().isChecked()){
					display.selectAllCheckBoxes(true);
				}
					else{
						display.selectAllCheckBoxes(false);
					}
				
			}});
		display.getBtnSubmit().addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				RadioButton selected = new RadioButton("");
				int i;
				int testId = 0 ;
				for(i =1 ;i<display.getListRadios().size() ; i++){
					if(display.getListRadios().get(i).isChecked()){
						selected = display.getListRadios().get(i);
						testId = i ;
					}
				}
				
				fetchSubTypes(testId);
			}});
	}

	public void fetchTestTypes(){
		rpcService.fetchTestTypes(new AsyncCallback<ArrayList<Test>>(){

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(ArrayList<Test> result) {
				display.createTestList(result);
			}});
	}
	
	public void fetchSubTypes(int testId){
		rpcService.fetchTestSubTypes(testId,new AsyncCallback<ArrayList<TestObjective>>(){

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(ArrayList<TestObjective> result) {
				display.createSubTestList(result)	;
			}});
	}
	


}


