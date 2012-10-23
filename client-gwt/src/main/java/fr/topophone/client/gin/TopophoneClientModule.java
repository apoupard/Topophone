package fr.topophone.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

import fr.topophone.client.TopophonePlaceManager;
import fr.topophone.client.mainpage.MainPagePresenter;
import fr.topophone.client.mainpage.MainPagePresenter.TopophoneProxy;
import fr.topophone.client.mainpage.MainPageView;

public class TopophoneClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {		
		
		// Default implementation of standard resources
	    install(new DefaultModule(TopophonePlaceManager.class));

	    // Presenters
	    bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
	        MainPageView.class, TopophoneProxy.class);

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