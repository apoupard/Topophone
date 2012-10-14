package fr.topophone.client;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

import fr.topophone.client.main.MainView;

public interface ClientFactory
{
	EventBus getEventBus();
	PlaceController getPlaceController();
	MainView getHelloView();
}
