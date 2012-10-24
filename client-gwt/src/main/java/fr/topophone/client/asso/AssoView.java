package fr.topophone.client.asso;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class AssoView extends ViewImpl implements AssoPresenter.IView {

	public interface Binder extends UiBinder<Widget, AssoView> {
	}

	private final Widget widget;

	@Inject
	public AssoView(Binder uiBinder) {
		widget = uiBinder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

}