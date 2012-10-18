package com.google.code.ginmvp.client.providers;

import javax.inject.Inject;
import javax.inject.Provider;

import com.google.code.ginmvp.client.GinMvpDisplay;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Provides and initializes the ActivityManager necessary to bind the Places and Activities 
 * framework together.  This provider is mapped as an EagerSingleton so that the constructor
 * will be fired immediately on application start, which creates and initializes the framework.
 * 
 * Currently, GinMvp is setup to expect one ActivityManagerProvider in the application.
 *  
 * @author slynn1324
 */
public class ActivityManagerProvider implements Provider<ActivityManager>{

	private final ActivityMapper activityMapper;
	private final EventBus eventBus;
	private final GinMvpDisplay mainView;
	
	private ActivityManager activityManager;
	
	@Inject
	public ActivityManagerProvider(ActivityMapper activityMapper, EventBus eventBus, GinMvpDisplay mainView){
		this.activityMapper = activityMapper;
		this.eventBus = eventBus;
		this.mainView = mainView;
		
		create();
	}
	
	private void create(){
		activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(mainView);
	}
	
	public ActivityManager get(){
		return activityManager;
	}

}
