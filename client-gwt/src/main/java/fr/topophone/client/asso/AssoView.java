package fr.topophone.client.asso;

import com.google.gwt.user.client.ui.IsWidget;

public interface AssoView extends IsWidget {

	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void goToHome();
	}
	
}
