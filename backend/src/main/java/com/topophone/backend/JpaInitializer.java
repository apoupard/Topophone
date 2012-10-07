package com.topophone.backend;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class JpaInitializer {

	@Inject
	private void MyInitializer(PersistService service) {
		service.start();
	}




}
