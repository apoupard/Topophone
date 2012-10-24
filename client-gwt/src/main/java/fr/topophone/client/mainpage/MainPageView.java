/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package fr.topophone.client.mainpage;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.ViewImpl;

import fr.topophone.client.widget.MainMenuView;

public class MainPageView extends ViewImpl implements MainPagePresenter.IView {
	/**
	   */
	public interface Binder extends UiBinder<Widget, MainPageView> {
	}

	public final Widget widget;

	@UiField
	MainMenuView menuPanel;

	@UiField
	HTMLPanel contentPanel;

	@Inject
	public MainPageView(Binder uiBinder) {
		widget = uiBinder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == MainPagePresenter.TYPE_SetTabContent) {
			setPanelContent(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

	public void setPanelContent(Widget content) {
		contentPanel.clear();
		if (content != null) {
			contentPanel.add(content);
		}
	}

	@Override
	public Tab addTab(TabData tabData, String historyToken) {
		return menuPanel.addTab(tabData, historyToken);
	}

	@Override
	public void removeTab(Tab tab) {
		menuPanel.removeTab(tab);
	}

	@Override
	public void removeTabs() {
		menuPanel.removeTabs();
	}

	@Override
	public void setActiveTab(Tab tab) {
		menuPanel.setActiveTab(tab);
	}

	@Override
	public void changeTab(Tab tab, TabData tabData, String historyToken) {
		menuPanel.changeTab(tab, tabData, historyToken);
	}

}
