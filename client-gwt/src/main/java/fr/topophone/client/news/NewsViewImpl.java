package fr.topophone.client.news;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NewsViewImpl extends Composite implements NewsView {

	private static DetailsViewImplUiBinder uiBinder = GWT
			.create(DetailsViewImplUiBinder.class);

	interface DetailsViewImplUiBinder extends UiBinder<Widget, NewsViewImpl> {
	}

	public NewsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	Presenter presenter;

//	@UiField
//	Button homeButton;
	
//	@UiHandler("homeButton")
//	void handleHomeButtonClick(ClickEvent e){
//		presenter.goToHome();
//	}
	
	public void setPresenter(Presenter presenter){
		this.presenter = presenter;
	}
	
}
