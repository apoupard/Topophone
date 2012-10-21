package fr.topophone.client;

//import com.google.code.ginmvp.client.GinMvpDisplay;
import com.google.code.ginmvp.client.GinMvpDisplay;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;


public class Topophone implements EntryPoint {

	public void onModuleLoad() {
		
		TopophoneGinjector ginjector = GWT.create(TopophoneGinjector.class);
		
		GinMvpDisplay display = ginjector.getMainView();
		
		RootPanel.get().add((Widget) display);

		ginjector.getPlaceHistoryHandler().handleCurrentHistory();
		
	}
}
