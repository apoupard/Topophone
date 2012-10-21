package fr.topophone.client.asso;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AssoViewImpl extends Composite implements AssoView {

	private static DetailsViewImplUiBinder uiBinder = GWT
			.create(DetailsViewImplUiBinder.class);

	interface DetailsViewImplUiBinder extends UiBinder<Widget, AssoViewImpl> {
	}

	public AssoViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	Presenter presenter;

	public void setPresenter(Presenter presenter){
		this.presenter = presenter;
	}
	
}
