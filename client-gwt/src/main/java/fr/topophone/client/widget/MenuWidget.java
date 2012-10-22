package fr.topophone.client.widget;

import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class MenuWidget extends Composite {

	private static MenuWidgetUiBinder uiBinder = GWT.create(MenuWidgetUiBinder.class);

	interface MenuWidgetUiBinder extends UiBinder<Widget, MenuWidget> {
	}
	
	@UiField
	HTMLPanel entryContainer;
	
	@UiConstructor
	public MenuWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setMenuEntryWidget(Set<MenuEntryWidget> entries) {
		entryContainer.clear();
		for(MenuEntryWidget entry : entries){
			entryContainer.add(entry);	
		}
	}

	

}
