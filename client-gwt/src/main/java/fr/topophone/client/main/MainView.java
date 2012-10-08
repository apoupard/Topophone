package fr.topophone.client.main;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface MainView extends IsWidget
{
	public interface Presenter
	{
		void goTo(Place place);
	}

	void setPresenter(Presenter listener);
}