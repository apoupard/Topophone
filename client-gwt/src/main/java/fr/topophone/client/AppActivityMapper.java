package fr.topophone.client;

import com.google.code.ginmvp.client.SimpleActivityMapper;
import com.google.inject.Inject;
import com.google.inject.Provider;

import fr.topophone.client.news.NewsActivity;
import fr.topophone.client.news.NewsPlace;

public class AppActivityMapper extends SimpleActivityMapper {

	@Inject
	public AppActivityMapper(final Provider<NewsActivity> detailsActivityProvider) {
		addProvider(NewsPlace.class, detailsActivityProvider);
	}

}
