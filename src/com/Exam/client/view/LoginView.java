package com.Exam.client.view;

import com.Exam.client.presenter.LoginPresenter.Display;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class LoginView extends Composite implements Display {
	/**
	 * @uml.property  name="button"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Button button;
	/**
	 * @uml.property  name="txtUserName"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private TextBox txtUserName;
	/**
	 * @uml.property  name="txtPassword"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private PasswordTextBox txtPassword;
	/**
	 * @uml.property  name="horizontalPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private HorizontalPanel horizontalPanel;
	/**
	 * @uml.property  name="decoratorPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DecoratorPanel decoratorPanel;
	/**
	 * @uml.property  name="lblError"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Label lblError;
	/**
	 * @uml.property  name="hprlnkNewHyperlink"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Hyperlink hprlnkNewHyperlink;
	/**
	 * @uml.property  name="hprlnkNewHyperlink_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Hyperlink hprlnkNewHyperlink_1;
	/**
	 * @uml.property  name="hpnlError"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private HorizontalPanel hpnlError;
	/**
	 * @uml.property  name="lblEmail"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Label lblEmail;
	
	
	/**
	 * @return
	 * @uml.property  name="lblError"
	 */
	public Label getLblError() {
		return lblError;
	}

	/**
	 * @param lblError
	 * @uml.property  name="lblError"
	 */
	public void setLblError(Label lblError) {
		this.lblError = lblError;
	}

	/**
	 * @return
	 * @uml.property  name="txtUserName"
	 */
	public TextBox getTxtUserName() {
		return txtUserName;
	}

	/**
	 * @param txtUserName
	 * @uml.property  name="txtUserName"
	 */
	public void setTxtUserName(TextBox txtUserName) {
		this.txtUserName = txtUserName;
	}

	/**
	 * @return
	 * @uml.property  name="txtPassword"
	 */
	public PasswordTextBox getTxtPassword() {
		return txtPassword;
	}

	/**
	 * @param txtPassword
	 * @uml.property  name="txtPassword"
	 */
	public void setTxtPassword(PasswordTextBox txtPassword) {
		this.txtPassword = txtPassword;
	}

	

	public LoginView() {
		
	
		
		horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);
		
		decoratorPanel = new DecoratorPanel();
		horizontalPanel.add(decoratorPanel);
		decoratorPanel.setSize("358px", "201px");
		
		FlexTable flexTable = new FlexTable();
		decoratorPanel.setWidget(flexTable);
		flexTable.setSize("387px", "221px");
		
		Label lblWelcomeToMy = new Label("Sign In");
		lblWelcomeToMy.setStyleName("bold");
		flexTable.setWidget(0, 0, lblWelcomeToMy);
		lblWelcomeToMy.setWidth("91px");
		
		hpnlError = new HorizontalPanel();
		flexTable.setWidget(1, 1, hpnlError);
		hpnlError.setWidth("230px");
		
		lblError = new Label("Invalid username / password");
		hpnlError.add(lblError);
		lblError.setVisible(false);
		lblError.setStyleName("red");
		
		Label lblNewLabel = new Label("User Name");
		lblNewLabel.setStyleName("blue");
		lblNewLabel.setWordWrap(false);
		flexTable.setWidget(2, 0, lblNewLabel);
		
		txtUserName = new TextBox();
		txtUserName.setFocus(true);
		txtUserName.setVisibleLength(30);
		flexTable.setWidget(2, 1, txtUserName);
		
		lblEmail = new Label("(Email Address)");
		flexTable.setWidget(3, 1, lblEmail);
		
		Label lblNewLabel_1 = new Label("Password");
		lblNewLabel_1.setStyleName("blue");
		flexTable.setWidget(4, 0, lblNewLabel_1);
		
		txtPassword = new PasswordTextBox();
		txtPassword.setVisibleLength(30);
		flexTable.setWidget(4, 1, txtPassword);
		txtPassword.setWidth("209");
		
		button = new Button("New button");
		button.setText("Log In");
		flexTable.setWidget(5, 1, button);
		button.setWidth("129px");
		
		hprlnkNewHyperlink = new Hyperlink("Register for an account!", false, "createAccount");
		flexTable.setWidget(6, 1, hprlnkNewHyperlink);
		
		hprlnkNewHyperlink_1 = new Hyperlink("Forgot Password", false, "forgotPassword");
		flexTable.setWidget(7, 1, hprlnkNewHyperlink_1);
		flexTable.getCellFormatter().setVerticalAlignment(7, 1, HasVerticalAlignment.ALIGN_TOP);
		flexTable.getCellFormatter().setHorizontalAlignment(7, 1, HasHorizontalAlignment.ALIGN_LEFT);
	}

	/**
	 * @return
	 * @uml.property  name="button"
	 */
	public Button getButton() {
		return button;
	}

	/**
	 * @param button
	 * @uml.property  name="button"
	 */
	public void setButton(Button button) {
		this.button = button;
	}

}
