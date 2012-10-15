package fr.topophone.client;

import javax.inject.Inject;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import fr.topophone.client.main.MainView;
import fr.topophone.client.main.MainViewImpl;

public class ClientFactoryImpl implements ClientFactory {
	
	@Inject
	protected ClientFactoryImpl(){
		
	}
	
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(
			eventBus);
	
	private static final MainView helloView = new MainViewImpl();

	@Override
	public MainView getMainView() {
		return helloView;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

}
