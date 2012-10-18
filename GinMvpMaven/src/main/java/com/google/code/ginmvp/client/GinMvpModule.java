package com.google.code.ginmvp.client;

import com.google.code.ginmvp.autoplacehistorymapper.client.AutoPlaceHistoryMapper;
import com.google.code.ginmvp.client.providers.ActivityManagerProvider;
import com.google.code.ginmvp.client.providers.PlaceControllerProvider;
import com.google.code.ginmvp.client.providers.PlaceHistoryHandlerProvider;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * This module sets up the GWT MVP framework with Guice in a 
 * reusable, Type-Safe fashion.
 * 
 * To use, install this module in your app module, passing
 * the classes to use for the ActivityMapper, PlaceHistoryMapper,
 * and Place.
 * 
 * Example:
 * 
 * 		install(new GinVPModule(AppActivityMapper.class, AppPlaceHistoryMapper.class, HomePlace.class));
 * 
 * @author slynn1324
 *
 */
public class GinMvpModule extends AbstractGinModule {

	/**
	 * Hold the defaultPlaceClass that should be used by the binder to set up
	 * the static injection of the defaultPlace
	 */
	private Class<? extends Place> defaultPlaceClass;
	private Class<? extends PlaceHistoryMapper> placeHistoryMapperClass;
	private Class<? extends ActivityMapper> activityMapperClass;
	private Class<? extends GinMvpDisplay> displayClass;
	
	/**
	 * Constructor to be used when installing the MvpModule into another
	 * module.
	 * 
	 * Example: 
	 * 
	 *    install(new MvpModule(MyPlace.class));
	 *    
	 * @param defaultPlaceClass
	 */
	public GinMvpModule(
			Class<? extends ActivityMapper> activityMapperClass,
			Class<? extends Place> defaultPlaceClass,
			Class<? extends GinMvpDisplay> displayClass,
			Class<? extends PlaceHistoryMapper> placeHistoryMapperClass
			){
		this.placeHistoryMapperClass = placeHistoryMapperClass;
		this.defaultPlaceClass = defaultPlaceClass;
		this.activityMapperClass = activityMapperClass;
		this.displayClass = displayClass;
	}
	
	public GinMvpModule(
			Class<? extends ActivityMapper> activityMapperClass,
			Class<? extends Place> defaultPlaceClass,
			Class<? extends GinMvpDisplay> displayClass
			){
		this(activityMapperClass, defaultPlaceClass, displayClass, AutoPlaceHistoryMapper.class);
	}
	
	public GinMvpModule(
			Class<? extends ActivityMapper> activityMapperClass,
			Class<? extends Place> defaultPlaceClass
			){
		this(activityMapperClass, defaultPlaceClass, SimplePanelDisplay.class);
	}
	
	public GinMvpModule(
			Class<? extends ActivityMapper> activityMapperClass
			){
		this(activityMapperClass, Place.NOWHERE.getClass());
	}
	
	
	@Override
	protected void configure() {
	
		// create a simple global event bus
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		
		// set up the binding for the default place above.
		bind(Place.class).annotatedWith(GinMvpDefault.class).to(defaultPlaceClass);
		
		// PlaceHistoryMapper instantiate new places based on the browser URL. You 
		// only need one of these for the entire app.
		bind(PlaceHistoryMapper.class).to(placeHistoryMapperClass).in(Singleton.class);
		
		if ( activityMapperClass != null ){
			bind(ActivityMapper.class).to(activityMapperClass).in(Singleton.class);
		}
		
		// we have to bind this as an eager singleton to force it to happen right away, 
		// otherwise the clients would have to request an instance to initialize it
		bind(ActivityManager.class).toProvider(ActivityManagerProvider.class).asEagerSingleton();
		
		bind(GinMvpDisplay.class).to(displayClass).in(Singleton.class);
		
		bind(PlaceHistoryHandler.class).toProvider(PlaceHistoryHandlerProvider.class).in(Singleton.class);
		bind(PlaceController.class).toProvider(PlaceControllerProvider.class).in(Singleton.class);
	}
	
}
