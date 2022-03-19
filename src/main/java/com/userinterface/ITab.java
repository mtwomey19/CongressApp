package com.userinterface;

import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public interface ITab {
    Tab getTab();
    VBox getVBox(Tab tab);
    VBox getVBox();
    void searchButtonClicked();
    void addComponentsToTab(VBox vBox);

}
