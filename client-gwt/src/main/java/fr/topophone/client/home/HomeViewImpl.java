package fr.topophone.client.home;

import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.topophone.client.widget.MenuEntryWidget;
import fr.topophone.client.widget.MenuWidget;

public class HomeViewImpl extends Composite implements HomeView {
	
	private static HelloViewImplUiBinder uiBinder = GWT
			.create(HelloViewImplUiBinder.class);

	@UiField
	MenuWidget menuPanel;
	
	@UiField
	HTMLPanel detailsPanel;

	interface HelloViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}

	public HomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

//	@Override
//	public void setWidget(IsWidget w) {
//		this.detailsPanel.add(w);
//	}

	@Override
	public void setMenuEntry(Set<MenuEntryWidget> entries) {
		this.menuPanel.setMenuEntryWidget(entries);
	}

}
