package com.Exam.client.view;

import java.util.ArrayList;

import com.Exam.client.presenter.TestListPresenter.Display;
import com.Exam.shared.Test;
import com.Exam.shared.TestObjective;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TesListView extends Composite implements Display {
	/**
	 * @uml.property  name="vpnlMain"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private VerticalPanel vpnlMain;
	/**
	 * @uml.property  name="subTypeWidget"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	TestSubTypesWIdget subTypeWidget = new TestSubTypesWIdget();
	/**
	 * @uml.property  name="btnSubmit"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Button btnSubmit;
	/**
	 * @uml.property  name="btnCancel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Button btnCancel;
	/**
	 * @uml.property  name="vpnlRadio"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private VerticalPanel vpnlRadio;
	/**
	 * @uml.property  name="listRadios"
	 */
	ArrayList<RadioButton> listRadios = new ArrayList<RadioButton>();
	/**
	 * @uml.property  name="listCheckBox"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.google.gwt.user.client.ui.CheckBox"
	 */
	ArrayList<CheckBox> listCheckBox= new ArrayList<CheckBox>();
	/**
	 * @uml.property  name="scrollPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ScrollPanel scrollPanel = new ScrollPanel();
	/**
	 * @uml.property  name="hpnlMain"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private HorizontalPanel hpnlMain;
	
	
	public TesListView() {
		
		vpnlMain = new VerticalPanel();
		Label lbl = new Label("Test List");
		initWidget(vpnlMain);
		
		hpnlMain = new HorizontalPanel();
		hpnlMain.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hpnlMain.setSpacing(5);
		vpnlMain.add(hpnlMain);
		hpnlMain.setWidth("1049px");
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		hpnlMain.add(decoratorPanel);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		decoratorPanel.setWidget(verticalPanel);
		verticalPanel.setSize("406px", "261px");
		
		Label lblHeading = new Label("Test List");
		lblHeading.setStyleName("heading");
		verticalPanel.add(lblHeading);
		
		Label lblNewLabel_1 = new Label("Select one of the test below");
		verticalPanel.add(lblNewLabel_1);
		
		vpnlRadio = new VerticalPanel();
		verticalPanel.add(scrollPanel);
		vpnlRadio.setSize("216px", "54px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setSpacing(1);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setWidth("185px");
		
		btnCancel = new Button("New button");
		btnCancel.setText("Cancel");
		horizontalPanel.add(btnCancel);
		
		btnSubmit = new Button("New button");
		btnSubmit.setText("Submit");
		horizontalPanel.add(btnSubmit);
		scrollPanel.add(vpnlRadio);
		scrollPanel.setSize("396px", "58px");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setHeight("28px");
		
	}

	public void createTestList(ArrayList<Test> result){
		
		VerticalPanel vpnlList = new VerticalPanel();
		listRadios.add(null);
		for(int i =0 ; i< result.size();i++){
			RadioButton rd = new RadioButton("group", result.get(i).getTestType());
			listRadios.add(result.get(i).getTestId(), rd);
			vpnlRadio.add(rd);
		}
	}
	
	public void createSubTestList(ArrayList<TestObjective> result){
		listCheckBox.clear();
		subTypeWidget.getVpnlCheckBox().clear();
		hpnlMain.add(subTypeWidget);
		listCheckBox.add(null);
		for(int i =0 ; i< result.size();i++){
			CheckBox rd = new CheckBox();//("group", result.get(i).getTestObjectiveType());
			rd.setText(result.get(i).getTestObjectiveType());
			listCheckBox.add(rd);
			subTypeWidget.getVpnlCheckBox().add(rd);
		}
	}
	
	public void selectAllCheckBoxes(boolean select){
		for(int i = 1; i<listCheckBox.size() ; i++){
			listCheckBox.get(i).setChecked(select);
			
		}
		
	}
	
	/**
	 * @return
	 * @uml.property  name="btnSubmit"
	 */
	public Button getBtnSubmit() {
		return btnSubmit;
	}

	/**
	 * @param btnSubmit
	 * @uml.property  name="btnSubmit"
	 */
	public void setBtnSubmit(Button btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public ArrayList<RadioButton> getListRadios() {
		return listRadios;
	}

	public void setListRadios(ArrayList<RadioButton> listRadios) {
		this.listRadios = listRadios;
	}

	/**
	 * @return
	 * @uml.property  name="subTypeWidget"
	 */
	public TestSubTypesWIdget getSubTypeWidget() {
		return subTypeWidget;
	}

	/**
	 * @param subTypeWidget
	 * @uml.property  name="subTypeWidget"
	 */
	public void setSubTypeWidget(TestSubTypesWIdget subTypeWidget) {
		this.subTypeWidget = subTypeWidget;
	}

	
}
