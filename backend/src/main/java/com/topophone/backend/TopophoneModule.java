package com.topophone.backend;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

public class TopophoneModule extends ServletModule {

	protected void configureServlets() {
		install(new JpaPersistModule("TopophoneJpa")); // like we saw earlier.

		install(new ServletModule());
		
		filter("/*").through(PersistFilter.class);
	}
}
