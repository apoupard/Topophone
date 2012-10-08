package fr.topophone.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import fr.topophone.client.header.HeaderView;
import fr.topophone.client.header.HeaderViewImpl;
import fr.topophone.client.main.MainView;
import fr.topophone.client.main.MainViewImpl;

public class ClientFactoryImpl implements ClientFactory {
	
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(
			eventBus);
	
	private static final MainView helloView = new MainViewImpl();
	private static final HeaderView goodbyeView = new HeaderViewImpl();

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public MainView getHelloView() {
		return helloView;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public HeaderView getGoodbyeView() {
		return goodbyeView;
	}

}
