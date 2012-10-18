package com.google.code.ginmvp.client;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Marker interface to combine the AcceptsOneWidget and IsWidget interfaces
 * that is used to provide the type of widget that should be created and used
 * as the 'MainView' for the application, which is the display to be set on
 * the ActivityManager.
 * 
 * 
 * @author slynn1324
 */
public interface GinMvpDisplay extends AcceptsOneWidget,IsWidget {

}
