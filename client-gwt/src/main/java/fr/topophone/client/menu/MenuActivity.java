package fr.topophone.client.menu;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.topophone.client.ClientFactory;

public class MenuActivity extends AbstractActivity {
	private ClientFactory clientFactory;

	public MenuActivity(MenuPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
//		HeaderView goodbyeView = clientFactory.getGoodbyeView();
//		containerWidget.setWidget(goodbyeView.asWidget());
	}
}