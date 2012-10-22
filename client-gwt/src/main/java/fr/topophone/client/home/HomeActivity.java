package fr.topophone.client.home;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import fr.topophone.client.asso.AssoPlace;
import fr.topophone.client.news.NewsPlace;
import fr.topophone.client.widget.MenuEntryWidget;

public class HomeActivity extends AbstractActivity {

	private HomeView view;
	private PlaceController placeController;

	@Inject
	public HomeActivity(HomeView view, PlaceController placeController) {
		this.view = view;
		this.placeController = placeController;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
//		panel.setWidget(view.asWidget());
		view.setMenuEntry(getMenuEntry());
	}

	private Set<MenuEntryWidget> getMenuEntry() {
		ImmutableSet.Builder<MenuEntryWidget> staticMenu  = ImmutableSet.builder();
		staticMenu.add(new MenuEntryWidget("Qui sommes-nous?", newClickHandler(new AssoPlace())));
		staticMenu.add(new MenuEntryWidget("Artistes", newClickHandler(new NewsPlace())));
		staticMenu.add(new MenuEntryWidget("Actions", newClickHandler(new AssoPlace())));
		staticMenu.add(new MenuEntryWidget("Intégrez le Topophonie", newClickHandler(new NewsPlace())));
		staticMenu.add(new MenuEntryWidget("Partenaires", newClickHandler(new AssoPlace())));
		return staticMenu.build();
	}

	private ClickHandler newClickHandler(final Place place) {
		return new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				placeController.goTo(place);
			}
		};
	}
}
