package fr.topophone.client.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MainViewImpl extends Composite implements MainView
{
	private static HelloViewImplUiBinder uiBinder = GWT.create(HelloViewImplUiBinder.class);

	interface HelloViewImplUiBinder extends UiBinder<Widget, MainViewImpl>
	{
	}

	private Presenter listener;

	public MainViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter listener)
	{
		this.listener = listener;
	}
}
