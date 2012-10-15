package fr.topophone.client;

import com.google.gwt.place.shared.PlaceController;

import fr.topophone.client.main.MainView;

public interface ClientFactory {
	PlaceController getPlaceController();

	MainView getMainView();

}
