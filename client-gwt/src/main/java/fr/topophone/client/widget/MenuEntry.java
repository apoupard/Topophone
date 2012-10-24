package fr.topophone.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;

public class MenuEntry extends Composite implements Tab {

	private static MenuEntryWidgetUiBinder uiBinder = GWT
			.create(MenuEntryWidgetUiBinder.class);

	interface MenuEntryWidgetUiBinder extends UiBinder<Widget, MenuEntry> {
	}

	protected interface Style extends CssResource {
		String active();
		String inactive();
	}

	@UiField
	Style style;

	@UiField
	Hyperlink entryLink;
	
	@UiField
	DivElement entry;
	
	@UiField
	Element	entryLabel;
	
	private Boolean isActive;
	
	private final float priority;

	public MenuEntry(final String label, final float priority) {
		initWidget(uiBinder.createAndBindUi(this));
		this.entryLabel.setInnerText(label);
		this.priority = priority;
		this.isActive = false;
		entryLink.addDomHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isActive){
					setActiveStyle();
				}
			}
		}, MouseOverEvent.getType());
		
		entryLink.addDomHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				if(!isActive){
					setInactiveStyle();
				}
				
			}
		}, MouseOutEvent.getType());
	}

	public MenuEntry(TabData tabData) {
		initWidget(uiBinder.createAndBindUi(this));
		entryLabel.setInnerText(tabData.getLabel());
		this.priority = tabData.getPriority();
	}

	@Override
	public void activate() {
		isActive = true;
		setActiveStyle();
	}

	@Override
	public void deactivate() {
		isActive = false;
		setInactiveStyle();
	}

	private void setInactiveStyle() {
		entry.removeClassName(style.active());
		entry.addClassName(style.inactive());
	}
	

	private void setActiveStyle() {
		entry.removeClassName(style.inactive());
		entry.addClassName(style.active());
	}

	@Override
	public float getPriority() {
		return priority;
	} 

	@Override
	public String getText() {
		return entryLabel.getInnerText();
	}

	@Override
	public void setTargetHistoryToken(String historyToken) {
		this.entryLink.setTargetHistoryToken(historyToken);
	}

	@Override
	public void setText(String text) {
		this.entryLabel.setInnerText(text);
	};

}
