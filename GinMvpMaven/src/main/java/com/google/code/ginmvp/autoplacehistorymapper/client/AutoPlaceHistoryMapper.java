package com.google.code.ginmvp.autoplacehistorymapper.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.PlaceTokenizer;


/**
 * Provides a mechanism for binding all places into the GWT Activities system
 * automatically by searching for all types that implement {@link Place}. For this 
 * mechanism to work, the code assumes that all places either:
 * <br />
 * <ol>
 * 	<li>Have a default constructor.</li>
 *  <li>Have a custom {@link PlaceTokenizer} defined as a public static inner class named &quot;Tokenizer&quot;</li>
 *  <li>Have a @{@link UseTokenizer} annotation that defines a {@link PlaceTokenizer} to be used to handle this {@link Place} type</li>
 * </ol>
 * If this is not true you will receive an excecption because the generated code will not compile.
 * 
 * <br /><br />
 * 
 * This class can be extended to modify the default tokens used (override getDefaultToken()), or to modify (or replace)
 * the created Place (override beforeReturnPlace(...))
 * 
 * @author slynn1324
 *
 */
public class AutoPlaceHistoryMapper implements PlaceHistoryMapper {

	/**
	 * This delegate holds our GWT-Generated mapper where the real magic happens. The delegate
	 * is wrapped instead of exposed directly so that this class can easily be extended without relying on
	 * generated code in its ancestry.
	 */
	private AutoPlaceHistoryMapperGeneratedDelegate delegate = GWT.create(AutoPlaceHistoryMapperGeneratedDelegate.class);
	
	/**
	 * Default constructor : creates the back-reference from the delegate to this class so that
	 * the getDefaultToken() and beforeReturnPlace() methods are accessible from the generated code
	 * allowing this class to be easily extended.
	 */
	public AutoPlaceHistoryMapper(){
		delegate.setDelegate(this);
	}
	
	/**
	 * Returns the default token to use. 
	 * 
	 * <br /><br />
	 * 
	 * By default, this method simply returns an empty string but can be overridden to provide 
	 * additional information or custom handling of the token.  In this case, then token is 
	 * similar to the token passed to a {@link PlaceTokenizer} in that it only contains the portion
	 * after the &quot;prefix:&quot;
	 * 
	 * 
	 * @param place : the place to be tokenized
	 * @return The &quot;token&quot; portion of the string, that is after the &quot;prefix:&quot; By default: an empty string.
	 */
	public String getDefaultToken(Place place){
		return "";
	}
	
	/**
	 * Override this method to modify or replace the {@link Place} instance that was
	 * created by the factory or custom tokenizer. 
	 * 
	 * @param place : the place that was created by the factory or a custom tokenizer
	 * @param token : the token that was used to create the place
	 * @return the new place. By default: just returns the place parameter with no modifications.
	 */
	public Place beforeReturnPlace(Place place, String token){
		return place;
	}

	/**
	 * Delegates to the generated factory.
	 */
	@Override
	public Place getPlace(String token) {
		return delegate.getPlace(token);
	}

	/**
	 * Delegates to the generated factory.
	 */
	@Override
	public String getToken(Place place) {
		return delegate.getToken(place);
	}
	
}


