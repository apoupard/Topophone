package fr.topophone.client.news;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;

import fr.topophone.client.NameTokens;
import fr.topophone.client.mainpage.MainPagePresenter;

public class NewsPresenter extends
		Presenter<NewsPresenter.IView, NewsPresenter.IProxy> {

	@ProxyCodeSplit
	@NameToken(NameTokens.newsPage)
	@TabInfo(container = MainPagePresenter.class, label = "News", priority = 0)
	public interface IProxy extends TabContentProxyPlace<NewsPresenter> {
	}

	public interface IView extends View {
	}

	@Inject
	public NewsPresenter(final EventBus eventBus, final IView view, final IProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetTabContent,
				this);
	}

}