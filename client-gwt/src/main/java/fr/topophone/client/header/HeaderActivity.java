package fr.topophone.client.header;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.topophone.client.ClientFactory;

public class HeaderActivity extends AbstractActivity {
	private ClientFactory clientFactory;

	public HeaderActivity(HeaderPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
//		HeaderView goodbyeView = clientFactory.getGoodbyeView();
//		containerWidget.setWidget(goodbyeView.asWidget());
	}
}