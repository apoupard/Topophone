package fr.topophone.client.gin;

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

import fr.topophone.client.mainpage.MainPagePresenter;


@GinModules({DispatchAsyncModule.class, TopophoneClientModule.class })
public interface TopophoneGinjector extends Ginjector {

	  EventBus getEventBus();

	  AsyncProvider<MainPagePresenter> getMainPagePresenter();

	  PlaceManager getPlaceManager();

//	  AsyncProvider<ResponsePresenter> getResponsePresenter();
	
}