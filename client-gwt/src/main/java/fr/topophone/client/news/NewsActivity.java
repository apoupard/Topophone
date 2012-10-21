package fr.topophone.client.news;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class NewsActivity extends AbstractActivity implements NewsView.Presenter {

	private NewsView view;
	private PlaceController placeController;
	
	@Inject
	public NewsActivity(NewsView view, PlaceController placeController){
		this.view = view;
		this.placeController = placeController;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view.asWidget()); 
		
		GWT.log("currentPlace = " + getPlace() + " id=" + getPlace().getId() );
	}

	@Override
	public void goToHome() {
//		placeController.goTo();
	}
	
	public NewsPlace getPlace(){
		return (NewsPlace) placeController.getWhere();
	}
	
}
