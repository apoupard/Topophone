package fr.topophone.client.news;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class NewsPlace extends Place {

	private Long id;
	
	public NewsPlace(){}
	
	public NewsPlace(Long id){
		this.id = id;
	}

	public static class Tokenizer implements PlaceTokenizer<NewsPlace>
	{

		@Override
		public String getToken(NewsPlace place)
		{
			return place.getId().toString();
		}

		@Override
		public NewsPlace getPlace(String token)
		{
			Long id = null;
			try{
				id = new Long(token);
			} catch (Exception e){
				// ignore
			}
			
			return new NewsPlace(id);
		}

	}
	
	public Long getId(){
		return id;
	}
}
