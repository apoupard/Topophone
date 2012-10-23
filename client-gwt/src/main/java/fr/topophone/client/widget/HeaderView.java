package fr.topophone.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HeaderView extends Composite {

	private static HeaderViewImplUiBinder uiBinder = GWT.create(HeaderViewImplUiBinder.class);

	interface HeaderViewImplUiBinder extends UiBinder<Widget, HeaderView> {
	}

	@UiConstructor
	public HeaderView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
