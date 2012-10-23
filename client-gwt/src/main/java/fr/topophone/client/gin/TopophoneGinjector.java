package fr.topophone.client.gin;

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

import fr.topophone.client.asso.AssoPresenter;
import fr.topophone.client.mainpage.MainPagePresenter;
import fr.topophone.client.news.NewsPresenter;


@GinModules({ClientModule.class })
public interface TopophoneGinjector extends Ginjector {

	  EventBus getEventBus();

	  Provider<MainPagePresenter> getMainPagePresenter();

	  PlaceManager getPlaceManager();

	  AsyncProvider<NewsPresenter> getNewsPresenter();
	  
	  AsyncProvider<AssoPresenter> getAssoPresenter();
	
}