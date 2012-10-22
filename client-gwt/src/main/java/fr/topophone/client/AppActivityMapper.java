package fr.topophone.client;

import com.google.code.ginmvp.client.SimpleActivityMapper;
import com.google.inject.Inject;
import com.google.inject.Provider;

import fr.topophone.client.asso.AssoActivity;
import fr.topophone.client.asso.AssoPlace;
import fr.topophone.client.home.HomeActivity;
import fr.topophone.client.home.HomePlace;
import fr.topophone.client.news.NewsActivity;
import fr.topophone.client.news.NewsPlace;

public class AppActivityMapper extends SimpleActivityMapper {

	@Inject
	public AppActivityMapper(final Provider<HomeActivity> homeActivityProvider, final Provider<NewsActivity> newsActivityProvider, final Provider<AssoActivity> assoActivityProvider) {
		addProvider(HomePlace.class, homeActivityProvider);
		addProvider(NewsPlace.class, newsActivityProvider);
		addProvider(AssoPlace.class, assoActivityProvider);
	}

}
