package fr.topophone.client.menu;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface MenuView extends IsWidget {
	
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		public void goTo(Place place);
	}
}