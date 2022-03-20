package com.congress;

import com.userinterface.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class CongressMain extends Application {

    private CongressLoader congressLoader;
    private TabPane root;
    private NameTab nameTab;
    private PartyTab partyTab;
    private AgeTab ageTab;
    private AvgAgePartyTab avgAgePartyTab;
    private TimeInOfficeTab timeInOfficeTab;

    public CongressMain(){
        this.congressLoader = new CongressLoader("src/main/resources/json/CongressMembers.json");
        this.root = new TabPane();
        this.nameTab = new NameTab();
        this.partyTab = new PartyTab();
        this.ageTab = new AgeTab();
        this.avgAgePartyTab = new AvgAgePartyTab();
        this.timeInOfficeTab = new TimeInOfficeTab();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(500);

        setTab(nameTab);

        setTab(partyTab);
        partyTab.getVBox().getChildren().addAll(partyTab.getPieChartButton(), partyTab.getPieChart());
        partyTab.pieChartButtonClicked();

        setTab(avgAgePartyTab);
        setTab(ageTab);
        setTab(timeInOfficeTab);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setTab(ITab tab) {
        root.getTabs().add(tab.getTab());
        tab.getVBox(tab.getTab());
        tab.searchButtonClicked();
        tab.addComponentsToTab(tab.getVBox());
    }
}