package fr.topophone.client.menu;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MenuPlace extends Place
{
	private String goodbyeName;
	
	public MenuPlace(String token)
	{
		this.goodbyeName = token;
	}

	public String getGoodbyeName()
	{
		return goodbyeName;
	}

	public static class Tokenizer implements PlaceTokenizer<MenuPlace>
	{
		@Override
		public String getToken(MenuPlace place)
		{
			return place.getGoodbyeName();
		}

		@Override
		public MenuPlace getPlace(String token)
		{
			return new MenuPlace(token);
		}
	}
	
}
