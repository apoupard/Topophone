package fr.topophone.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

import fr.topophone.client.gin.TopophoneGinjector;


public class Topophone implements EntryPoint {

	public final TopophoneGinjector ginjector = GWT.create(TopophoneGinjector.class);

	  public void onModuleLoad() {

	    DelayedBindRegistry.bind(ginjector);

	    ginjector.getPlaceManager().revealCurrentPlace();
	  }
}
