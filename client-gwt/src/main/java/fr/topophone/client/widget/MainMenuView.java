package fr.topophone.client.widget;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.TabPanel;

public class MainMenuView extends Composite implements TabPanel {

	private final List<Tab> tabList;

	private Tab currentActiveTab;

	private static Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, MainMenuView> {
	}

	@UiField
	FlowPanel entryContainer;

	@UiConstructor
	public MainMenuView() {
		initWidget(binder.createAndBindUi(this));
		tabList = Lists.newArrayList();
	}

	@Override
	public Tab addTab(TabData tabData, String historyToken) {
		Tab newTab = createNewTab(tabData);
		int beforeIndex;
		for (beforeIndex = 0; beforeIndex < tabList.size(); ++beforeIndex) {
			if (newTab.getPriority() < tabList.get(beforeIndex).getPriority()) {
				break;
			}
		}
		entryContainer.insert(newTab.asWidget(), beforeIndex);
		tabList.add(beforeIndex, newTab);
		newTab.setTargetHistoryToken(historyToken);
		return newTab;
	}

	@Override
	public void removeTab(Tab tab) {
		entryContainer.getElement().removeChild(tab.asWidget().getElement());
		tabList.remove(tab);
	}

	@Override
	public void removeTabs() {
		for (Tab tab : tabList) {
			entryContainer.getElement()
					.removeChild(tab.asWidget().getElement());
		}
		tabList.clear();
	}

	@Override
	public void setActiveTab(Tab tab) {
		if (currentActiveTab != null) {
			currentActiveTab.deactivate();
		}
		if (tab != null) {
			tab.activate();
		}
		currentActiveTab = tab;
	}

	@Override
	public void changeTab(Tab tab, TabData tabData, String historyToken) {
		tab.setText(tabData.getLabel());
		tab.setTargetHistoryToken(historyToken);
	}

	private Tab createNewTab(TabData tabData) {
		return new MenuEntry(tabData);
	}

}
