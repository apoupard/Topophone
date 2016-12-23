package io.enscene.topophone.config;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.google.common.collect.ImmutableList;
import com.google.inject.Injector;
import com.google.inject.Module;

import io.enscene.core.impl.resteasy.MicroApplicationBootstrapServletContextListener;

@WebListener
public class TopophoneGuiceConfiguration extends MicroApplicationBootstrapServletContextListener {

	@Override
	protected Collection<Module> bindModules(ServletContext context)
	{
			return ImmutableList.of(new TopophoneModule());
	}
	
	@Override
	protected Optional<Class<? extends Application>> getApplication() {
		return Optional.of(TopophoneMicroApplication.class);
	}

	@ApplicationPath("html")
	public static class TopophoneMicroApplication extends Application {}

	@Override
	protected void withInjector(Injector injector) {
	}

}
