package fr.topophone.client.header;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HeaderPlace extends Place
{
	private String goodbyeName;
	
	public HeaderPlace(String token)
	{
		this.goodbyeName = token;
	}

	public String getGoodbyeName()
	{
		return goodbyeName;
	}

	public static class Tokenizer implements PlaceTokenizer<HeaderPlace>
	{
		@Override
		public String getToken(HeaderPlace place)
		{
			return place.getGoodbyeName();
		}

		@Override
		public HeaderPlace getPlace(String token)
		{
			return new HeaderPlace(token);
		}
	}
	
}
