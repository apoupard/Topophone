package fr.topophone.client.asso;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AssoPlace extends Place {

	private Long id;
	
	public AssoPlace(){}
	
	public AssoPlace(Long id){
		this.id = id;
	}

	public static class Tokenizer implements PlaceTokenizer<AssoPlace>
	{

		@Override
		public String getToken(AssoPlace place)
		{
			return place.getId().toString();
		}

		@Override
		public AssoPlace getPlace(String token)
		{
			Long id = null;
			try{
				id = new Long(token);
			} catch (Exception e){
				// ignore
			}
			
			return new AssoPlace(id);
		}

	}
	
	public Long getId(){
		return id;
	}
}
