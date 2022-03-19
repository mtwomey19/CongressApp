package com.congress;

import com.userinterface.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class CongressClientApp extends Application {

    private CongressLoader congressLoader;
    private TabPane root;
    private NameWindow nameWindow;
    private PartyWindow partyWindow;
    private AgeWindow ageWindow;
    private AvgAgePartyWindow avgAgePartyWindow;
    private TimeInOfficeWindow timeInOfficeWindow;

    public CongressClientApp(){
        this.congressLoader = new CongressLoader("src/main/resources/main/CongressPersonTest4.json");
        this.root = new TabPane();
        this.nameWindow = new NameWindow();
        this.partyWindow = new PartyWindow();
        this.ageWindow = new AgeWindow();
        this.avgAgePartyWindow = new AvgAgePartyWindow();
        this.timeInOfficeWindow = new TimeInOfficeWindow();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(500);

        setNameTab();
        setPartyTab();
        setAgeTab();
        setAvgAgePartyTab();
        setTimeInOfficeWindow();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setNameTab() {
        root.getTabs().add(nameWindow.getTab());
        nameWindow.getVBox(nameWindow.getTab());
        nameWindow.searchButtonClicked();
        nameWindow.addAdditionalComponentsToWindow(nameWindow.getVBox());
    }

    private void setPartyTab() {
        root.getTabs().add(partyWindow.getTab());
        partyWindow.getVBox(partyWindow.getTab());
        partyWindow.searchButtonClicked();
        partyWindow.addComponentsToWindow(partyWindow.getVBox(partyWindow.getTab()));
        partyWindow.getVBox().getChildren().addAll(partyWindow.getPieChart(), partyWindow.getPieChartButton());
    }

    private void setAgeTab() {
        root.getTabs().add(ageWindow.getTab());
        ageWindow.getVBox(ageWindow.getTab());
        ageWindow.searchButtonClicked();
        ageWindow.addComponentsToWindow(ageWindow.getVBox());
    }

    private void setAvgAgePartyTab() {
        root.getTabs().add(avgAgePartyWindow.getTab());
        avgAgePartyWindow.getVBox(avgAgePartyWindow.getTab());
        avgAgePartyWindow.searchButtonClicked();
        avgAgePartyWindow.addComponentsToWindow(avgAgePartyWindow.getVBox());
    }

    private void setTimeInOfficeWindow() {
        root.getTabs().add(timeInOfficeWindow.getTab());
        timeInOfficeWindow.getVBox(timeInOfficeWindow.getTab());
        timeInOfficeWindow.searchButtonClicked();
        timeInOfficeWindow.addComponentsToWindow(timeInOfficeWindow.getVBox());
    }
}