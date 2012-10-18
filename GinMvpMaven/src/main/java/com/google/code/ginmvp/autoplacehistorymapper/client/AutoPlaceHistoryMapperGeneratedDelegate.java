package com.google.code.ginmvp.autoplacehistorymapper.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;

/**
 * This class is used to provide the abstract class that is dynamically sub-classed
 * by the {@link AutoPlaceHistoryMapperGeneratedDelegateGenerator} at GWT-compile time.
 * 
 * <br /><br />
 * 
 * Keeps a delegate reference which back-references the {@link AutoPlaceHistoryMapper} 
 * allowing users to extend the class easily.
 * 
 * @author slynn1324
 *
 */
public abstract class AutoPlaceHistoryMapperGeneratedDelegate implements PlaceHistoryMapper {
	
	/**
	 * The back-reference to the {@link AutoPlaceHistoryMapper}
	 */
	private AutoPlaceHistoryMapper delegate;
	
	/**
	 * @param delegate : back-reference to the AutoPlaceHistoryMapper instance being used
	 */
	public void setDelegate(AutoPlaceHistoryMapper delegate){
		this.delegate = delegate;
	}

	/**
	 * @return : back-reference to the AutoPlaceHistoryMapper instance being used
	 */
	protected AutoPlaceHistoryMapper getDelegate(){
		return delegate;
	}
	
}
