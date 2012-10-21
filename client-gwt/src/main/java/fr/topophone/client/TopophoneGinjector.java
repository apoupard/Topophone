package fr.topophone.client;

import com.google.code.ginmvp.client.GinMvpDisplay;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;


@GinModules({ TopophoneClientModule.class })
public interface TopophoneGinjector extends Ginjector {

	PlaceHistoryHandler getPlaceHistoryHandler();
	GinMvpDisplay getMainView();
	
}