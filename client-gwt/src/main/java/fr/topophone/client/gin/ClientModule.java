package fr.topophone.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

import fr.topophone.client.TopophonePlaceManager;
import fr.topophone.client.asso.AssoPresenter;
import fr.topophone.client.asso.AssoView;
import fr.topophone.client.mainpage.MainPagePresenter;
import fr.topophone.client.mainpage.MainPageView;
import fr.topophone.client.news.NewsPresenter;
import fr.topophone.client.news.NewsView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {		
		
		// Default implementation of standard resources
	    install(new DefaultModule(TopophonePlaceManager.class));

	    bindPresenter(MainPagePresenter.class, MainPagePresenter.IView.class,
	            MainPageView.class, MainPagePresenter.IProxy.class);
	    
	    bindPresenter(NewsPresenter.class, NewsPresenter.IView.class,
	            NewsView.class, NewsPresenter.IProxy.class);
	    
	    bindPresenter(AssoPresenter.class, AssoPresenter.IView.class,
	    		AssoView.class, AssoPresenter.IProxy.class);
	    

//	    bindPresenter(ResponsePresenter.class, ResponsePresenter.MyView.class,
//	        ResponseView.class, TopophoneProxy.class);
		
		
//		install(new GinMvpModule(AppActivityMapper.class, NewsPlace.class, HomeView.class));
//		
//		bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
//		
//		bind(NewsView.class).to(NewsViewImpl.class).in(Singleton.class);
//		
//		bind(AssoView.class).to(AssoViewImpl.class).in(Singleton.class);
		
	}
}