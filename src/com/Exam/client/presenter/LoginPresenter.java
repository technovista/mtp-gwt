package com.Exam.client.presenter;

import com.Exam.client.ExamServiceAsync;
import com.Exam.client.event.TestListEvent;
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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


public class LoginPresenter implements Presenter 

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
			Object getHtmlErrorMessage = null;
			Widget asWidget();
			PasswordTextBox getTxtPassword();
			TextBox getTxtUserName();
			HasClickHandlers getButton();
			Label getLblError();
		}  
			  
public LoginPresenter(ExamServiceAsync rpcService, HandlerManager eventBus, Display view) 
		{
			this.rpcService = rpcService;
			this.eventBus = eventBus;
			this.display = view;
		}

		public void go(HasWidgets container) 
		{
			container.clear();
			container.add(display.asWidget());
			bind();
		}

		private void bind() {
			display.getButton().addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					if(display.getTxtUserName().getText().equals("")|| display.getTxtPassword().getText().equals("")){
						display.getLblError().setVisible(true);
						display.getLblError().setText("username / password cannot be empty");
					}
					
					signIn(display.getTxtUserName().getText(),display.getTxtPassword().getText());

//					Window.alert("welcome");
				}
			});
			
		}
		
		public void signIn(String userName,String password)
		{
			 rpcService.signIn(userName,password,new AsyncCallback<String>()
						
						{
							public void onFailure(Throwable caught) {
							Window.alert(caught.getStackTrace().toString());
							}

							public void onSuccess(String result) {
								if(result.equals("loggedIn") )
								{
									display.getLblError().setVisible(false);
									eventBus.fireEvent(new TestListEvent());
								}
								else 
								{
									display.getLblError().setVisible(true);
									display.getLblError().setText("username / password Invalid");
								//	Window.alert("fail user");
								}
							}
						});
			
	   }
		
	
}


