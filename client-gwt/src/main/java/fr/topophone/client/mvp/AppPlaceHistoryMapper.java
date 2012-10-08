package fr.topophone.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import fr.topophone.client.main.MainPlace;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers( { MainPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
