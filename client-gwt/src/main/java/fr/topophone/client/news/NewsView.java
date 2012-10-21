package fr.topophone.client.news;

import com.google.gwt.user.client.ui.IsWidget;

public interface NewsView extends IsWidget {

	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void goToHome();
	}
	
}
