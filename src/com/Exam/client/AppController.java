package com.Exam.client;



import com.Exam.client.event.TestListEvent;
import com.Exam.client.event.TestListEventHandler;
import com.Exam.client.presenter.LoginPresenter;
import com.Exam.client.presenter.Presenter;
import com.Exam.client.presenter.TestListPresenter;
import com.Exam.client.view.LoginView;
import com.Exam.client.view.TesListView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
	/**
	 * @uml.property  name="eventBus"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final HandlerManager eventBus;
	/**
	 * @uml.property  name="rpcService"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final ExamServiceAsync rpcService; 
	/**
	 * @uml.property  name="container"
	 * @uml.associationEnd  
	 */
	private HasWidgets container;

	public AppController(ExamServiceAsync rpcService, HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;

		bind();
	}


	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(TestListEvent.TYPE,
				new TestListEventHandler() {
			public void onMy(TestListEvent event) {
				doMy();
			}
			private void doMy() { 
				History.newItem("testlist");

			}
		});  
	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("login");
		}
		else {
			History.fireCurrentHistoryState();
		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("login")) {
				presenter = new LoginPresenter(rpcService, eventBus, new LoginView());
			}

			if (token.equals("testlist")) {
				presenter = new TestListPresenter(rpcService, eventBus, new TesListView());
			}

			if (presenter != null) {
				presenter.go(container);
			}
		}
	} 
}
