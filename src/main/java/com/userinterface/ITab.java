package com.userinterface;

import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public interface ITab {
    // core components of tab assembly for CongressApp GUI
    Tab getTab();
    VBox getVBox(Tab tab);
    VBox getVBox();
    void searchButtonClicked();
    void addComponentsToTab(VBox vBox);

}
