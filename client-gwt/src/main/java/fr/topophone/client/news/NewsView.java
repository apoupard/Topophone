package fr.topophone.client.news;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class NewsView extends ViewImpl implements NewsPresenter.IView {

	public interface Binder extends UiBinder<Widget, NewsView> {
	}

	private final Widget widget;

	@Inject
	public NewsView(Binder uiBinder) {
		widget = uiBinder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

}