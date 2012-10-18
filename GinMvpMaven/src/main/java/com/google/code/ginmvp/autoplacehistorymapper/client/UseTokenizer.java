package com.google.code.ginmvp.autoplacehistorymapper.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Indicates which @{link PlaceTokenizer} type is to be used to tokenize this place,
 * allowing multiple Places to use the same @{link PlaceTokenizer} or to implement
 * the @{link PlaceTokenizer} as anything other than a static inner class named &quot;Tokenizer&quot;
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UseTokenizer {
  Class<? extends PlaceTokenizer<?>> value();
}

