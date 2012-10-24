package fr.topophone.client.asso;

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

public class AssoPresenter extends
		Presenter<AssoPresenter.IView, AssoPresenter.IProxy> {

	@ProxyCodeSplit
	@NameToken(NameTokens.assoPage)
	@TabInfo(container = MainPagePresenter.class, label = "Qui somme nous ?", priority = 1)
	public interface IProxy extends TabContentProxyPlace<AssoPresenter> {
	}

	public interface IView extends View {
	}

	@Inject
	public AssoPresenter(final EventBus eventBus, final IView view, final IProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetTabContent,	this);
	}

}