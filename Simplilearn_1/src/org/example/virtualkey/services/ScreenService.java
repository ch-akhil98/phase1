package org.example.virtualkey.services;

import org.example.virtualkey.screens.FileOptionsScreen;
import org.example.virtualkey.screens.Display;
import org.example.virtualkey.screens.DisplayScreen;

public class ScreenService {

	static DisplayScreen WelcomeScreen = new DisplayScreen();
    public static FileOptionsScreen FileOptionsScreen = new FileOptionsScreen();

    static Display CurrentScreen = WelcomeScreen;
     
	public static Display getCurrentScreen() {
		return CurrentScreen;
	}

	public static void setCurrentScreen(Display currentScreen) {
		CurrentScreen = currentScreen;
	}


}
