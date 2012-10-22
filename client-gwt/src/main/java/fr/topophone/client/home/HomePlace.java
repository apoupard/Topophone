package fr.topophone.client.home;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HomePlace extends Place {

	private Long id;
	
	public HomePlace(){}
	
	public HomePlace(Long id){
		this.id = id;
	}

	public static class Tokenizer implements PlaceTokenizer<HomePlace>
	{

		@Override
		public String getToken(HomePlace place)
		{
			return place.getId().toString();
		}

		@Override
		public HomePlace getPlace(String token)
		{
			Long id = null;
			try{
				id = new Long(token);
			} catch (Exception e){
				// ignore
			}
			
			return new HomePlace(id);
		}

	}
	
	public Long getId(){
		return id;
	}
}
