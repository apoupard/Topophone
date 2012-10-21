package fr.topophone.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

import fr.topophone.client.asso.AssoPlace;
import fr.topophone.client.menu.MenuView;
import fr.topophone.client.news.NewsPlace;

public class MenuViewImpl extends Composite implements MenuView {

	private static MenuViewImplUiBinder uiBinder = GWT.create(MenuViewImplUiBinder.class);

	interface MenuViewImplUiBinder extends UiBinder<Widget, MenuViewImpl> {
	}
	
	@UiField
	HTMLPanel entryContainer;
	
	private Presenter presenter;

	@UiConstructor
	public MenuViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		initEntryContainer();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	private void initEntryContainer() {
		entryContainer.add(new MenuEntryWidget("Qui sommes-nous?", newClickHandler(new AssoPlace())));
		entryContainer.add(new MenuEntryWidget("Artistes", newClickHandler(new NewsPlace())));
		entryContainer.add(new MenuEntryWidget("Actions", newClickHandler(new AssoPlace())));
		entryContainer.add(new MenuEntryWidget("Intégrez le Topophonie", newClickHandler(new NewsPlace())));
		entryContainer.add(new MenuEntryWidget("Partenaires", newClickHandler(new AssoPlace())));
	}

	private ClickHandler newClickHandler(final Place place) {
		return new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				presenter.goTo(place);
			}
		};
	}

	

}
