package fr.topophone.client.gin;

import net.customware.gwt.dispatch.client.gin.ClientDispatchModule;
import net.customware.gwt.presenter.client.place.PlaceManager;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({ ClientDispatchModule.class, AppleGuiceClientModule.class })
public interface TopophoneInjector extends Ginjector {

	AppPresenter getAppPresenter();

	PlaceManager getPlaceManager();

}