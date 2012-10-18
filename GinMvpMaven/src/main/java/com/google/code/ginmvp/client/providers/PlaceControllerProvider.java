package com.google.code.ginmvp.client.providers;

import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Creates a new PlaceController. The place controller is used by the PlaceHistoryHandler and activities
 * to tell the app to navigate to a different place. You only need one for the
 * entire app. However, it is essential for it to get instantiated in order
 * for the application navigation to work.
 * 
 * @param eventBus the event bus.
 * @return
 */
public class PlaceControllerProvider implements Provider<PlaceController>{
	
	private final EventBus eventBus;
	
	@Inject
	public PlaceControllerProvider(EventBus eventBus){
		this.eventBus = eventBus;
	}
	
	public PlaceController get(){
	    return new PlaceController(eventBus);
	}
}
