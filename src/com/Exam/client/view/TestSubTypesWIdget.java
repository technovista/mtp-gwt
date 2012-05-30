package com.Exam.client.view;

import java.util.ArrayList;

import com.Exam.shared.Test;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;

public class TestSubTypesWIdget extends Composite {
	
	/**
	 * @uml.property  name="listRadios"
	 */
	ArrayList<RadioButton> listRadios = new ArrayList<RadioButton>();
	
	/**
	 * @uml.property  name="btnCancel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Button btnCancel;
	/**
	 * @uml.property  name="btnSubmit"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Button btnSubmit;
	/**
	 * @uml.property  name="scrollPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private ScrollPanel scrollPanel;
	/**
	 * @uml.property  name="vpnlCheckBox"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private VerticalPanel vpnlCheckBox;
	/**
	 * @uml.property  name="chkAllSubTypes"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private CheckBox chkAllSubTypes;
	
	TestSubTypesWIdget(){
		DecoratorPanel decPanel = new DecoratorPanel();
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(decPanel);
		decPanel.setWidth("416px");
		decPanel.add(verticalPanel);
		verticalPanel.setSize("406px", "261px");
		
		Label lblSubTopicTest = new Label("Sub Topic Test List");
		lblSubTopicTest.setStyleName("heading");
		verticalPanel.add(lblSubTopicTest);
		
		Label lblSelectASubtopic = new Label("Select a subtopic Test");
		verticalPanel.add(lblSelectASubtopic);
		
		chkAllSubTypes = new CheckBox("Select All SubTests");
		verticalPanel.add(chkAllSubTypes);
		
		scrollPanel = new ScrollPanel();
		verticalPanel.add(scrollPanel);
		scrollPanel.setSize("376px", "59px");
		
		vpnlCheckBox = new VerticalPanel();
		scrollPanel.setWidget(vpnlCheckBox);
		vpnlCheckBox.setSize("216px", "54px");
		
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
			vpnlCheckBox.add(rd);
		}
	}

	/**
	 * @return
	 * @uml.property  name="vpnlCheckBox"
	 */
	public VerticalPanel getVpnlCheckBox() {
		return vpnlCheckBox;
	}

	/**
	 * @param vpnlCheckBox
	 * @uml.property  name="vpnlCheckBox"
	 */
	public void setVpnlCheckBox(VerticalPanel vpnlCheckBox) {
		this.vpnlCheckBox = vpnlCheckBox;
	}

	/**
	 * @return
	 * @uml.property  name="chkAllSubTypes"
	 */
	public CheckBox getChkAllSubTypes() {
		return chkAllSubTypes;
	}

	/**
	 * @param chkAllSubTypes
	 * @uml.property  name="chkAllSubTypes"
	 */
	public void setChkAllSubTypes(CheckBox chkAllSubTypes) {
		this.chkAllSubTypes = chkAllSubTypes;
	}
	
}
