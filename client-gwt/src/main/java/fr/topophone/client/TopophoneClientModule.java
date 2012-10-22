package fr.topophone.client;

import com.google.code.ginmvp.client.GinMvpModule;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import fr.topophone.client.asso.AssoView;
import fr.topophone.client.asso.AssoViewImpl;
import fr.topophone.client.home.HomePlace;
import fr.topophone.client.home.HomeView;
import fr.topophone.client.home.HomeViewImpl;
import fr.topophone.client.news.NewsPlace;
import fr.topophone.client.news.NewsView;
import fr.topophone.client.news.NewsViewImpl;

public class TopophoneClientModule extends AbstractGinModule {

	@Override
	protected void configure() {		
		
		install(new GinMvpModule(AppActivityMapper.class, NewsPlace.class, HomeView.class));
		
		bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
		
		bind(NewsView.class).to(NewsViewImpl.class).in(Singleton.class);
		
		bind(AssoView.class).to(AssoViewImpl.class).in(Singleton.class);
		
	}
}