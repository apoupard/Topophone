package fr.topophone.client.home;

import java.util.Set;

import com.google.code.ginmvp.client.GinMvpDisplay;

import fr.topophone.client.widget.MenuEntryWidget;

public interface HomeView extends GinMvpDisplay {

	void setMenuEntry(Set<MenuEntryWidget> entries);

}