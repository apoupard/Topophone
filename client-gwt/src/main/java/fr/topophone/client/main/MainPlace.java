package fr.topophone.client.main;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MainPlace extends Place
{
	private String helloName;
	
	public MainPlace(String token)
	{
		this.helloName = token;
	}

	public String getHelloName()
	{
		return helloName;
	}

	public static class Tokenizer implements PlaceTokenizer<MainPlace>
	{

		@Override
		public String getToken(MainPlace place)
		{
			return place.getHelloName();
		}

		@Override
		public MainPlace getPlace(String token)
		{
			return new MainPlace(token);
		}

	}
	
}
