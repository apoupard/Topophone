package com.google.code.ginmvp.client.providers;

import javax.inject.Inject;
import javax.inject.Provider;

import com.google.code.ginmvp.client.GinMvpDefault;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Creates a new PlaceHistoryHandler.  This object is responsible handling navigation based on the browser URL.
 * You only need one of those for the entire app.
 * 
 * @param placeController the place controller.
 * @param historyMapper This is used to map the URL to a Place object and vice versa.
 * @param eventBus the event bus.
 * @return
 */
public class PlaceHistoryHandlerProvider implements
		Provider<PlaceHistoryHandler> {

	private PlaceController placeController;
	private PlaceHistoryMapper historyMapper;
	private EventBus eventBus;
	private Place defaultPlace;
	
	@Inject
	public PlaceHistoryHandlerProvider(PlaceController placeController,
			PlaceHistoryMapper historyMapper, EventBus eventBus,
			@GinMvpDefault Place defaultPlace) {
		this.placeController = placeController;
		this.historyMapper = historyMapper;
		this.eventBus = eventBus;
		this.defaultPlace = defaultPlace;
	}

	public PlaceHistoryHandler get() {
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);
		return historyHandler;
	}
}
