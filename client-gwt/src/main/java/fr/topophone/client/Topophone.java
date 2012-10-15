package fr.topophone.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import fr.topophone.client.gin.TopophoneGinjector;
import fr.topophone.client.main.MainPlace;
import fr.topophone.client.main.MainView;
import fr.topophone.client.mvp.AppActivityMapper;
import fr.topophone.client.mvp.AppPlaceHistoryMapper;

public class Topophone implements EntryPoint {

	@Inject
	static EventBus eventBus;
	
	@Inject
	static ClientFactory clientFactory;

	@Inject
	static MainView mainPanel; 
	
	private Place defaultPlace = new MainPlace("World!");
	
	private SimplePanel appWidget = new SimplePanel();

	public void onModuleLoad() {
		GWT.create(TopophoneGinjector.class);
		
		PlaceController placeController = new PlaceController(eventBus);

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootPanel.get().add(appWidget);
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
	}
}
