package fr.topophone.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuEntryWidget extends Composite implements HasClickHandlers {

	private static MenuEntryWidgetUiBinder uiBinder = GWT
			.create(MenuEntryWidgetUiBinder.class);

	interface MenuEntryWidgetUiBinder extends UiBinder<Widget, MenuEntryWidget> {
	}

	@UiField
	Element entryLabel;

	@UiConstructor
	public MenuEntryWidget(final String label, ClickHandler handler) {
		initWidget(uiBinder.createAndBindUi(this));
		entryLabel.setInnerHTML(label);
		addClickHandler(handler);
	}

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

}
