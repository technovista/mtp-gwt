package com.Exam.client.event;

import com.google.gwt.event.shared.GwtEvent;

		public class TestListEvent extends GwtEvent<TestListEventHandler> {
		  public static Type<TestListEventHandler> TYPE = new Type<TestListEventHandler>();

		@Override
		public com.google.gwt.event.shared.GwtEvent.Type<TestListEventHandler> getAssociatedType() {
		    return TYPE;
		}

		@Override
		protected void dispatch(TestListEventHandler handler) {
		    handler.onMy(this);
			
		}

	}


