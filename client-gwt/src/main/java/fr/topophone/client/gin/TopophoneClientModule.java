package fr.topophone.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import fr.topophone.client.ClientFactory;
import fr.topophone.client.ClientFactoryImpl;
import fr.topophone.client.Topophone;
import fr.topophone.client.main.MainView;
import fr.topophone.client.main.MainViewImpl;

public class TopophoneClientModule extends AbstractGinModule {

	@Override
	protected void configure() {		
		
		bind(ClientFactory.class).to(ClientFactoryImpl.class).in(Singleton.class);
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

		bind(MainView.class).to(MainViewImpl.class).in(Singleton.class);
		
		requestStaticInjection(Topophone.class);
		
//		bindPresenter(GreetingPresenter.class, GreetingPresenter.Display.class, GreetingView.class);
//		bindPresenter(GreetingResponsePresenter.class, GreetingResponsePresenter.Display.class, GreetingResponseView.class);
//		
//		bind(AppPresenter.class).in(Singleton.class);
//		bind(CachingDispatchAsync.class);
	}
}