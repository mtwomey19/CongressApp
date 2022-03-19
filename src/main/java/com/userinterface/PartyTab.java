package com.userinterface;

import com.congress.CongressConnector;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class PartyTab extends TabBuilder implements ITab {

    private Tab partyTab;
    private VBox partyVBox;
    private PieChart pieChart;
    private Button pieChartButton;

    public PartyTab() {
        super("Find the Number of Congress People in Each Party:", "Party (Democrat, Republican, Independent)");
        this.partyTab = new Tab("Party");
        this.partyVBox = new VBox(10);
        this.pieChart = new PieChart();
        this.pieChartButton = new Button("Search");
    }

    public Tab getTab() {
        return partyTab;
    }
    public VBox getVBox(Tab tab) {
        ScrollPane scrollPane = new ScrollPane();
        tab.setContent(scrollPane);
        scrollPane.setContent(partyVBox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        return partyVBox;
    }
    public VBox getVBox() {
        return partyVBox;
    }

    public PieChart getPieChart() {
        return pieChart;
    }
    public Button getPieChartButton() {
        return pieChartButton;
    }

    public void searchButtonClicked() {
        getSearchButton().setOnAction((ActionEvent actionEvent) -> {
            String partyEntered = getTextField().getText().toLowerCase();
            if (!partyEntered.equals("democrat") && !partyEntered.equals("republican") && !partyEntered.equals("independent"))
            getOutput().setText("There is no member of Congress that is part of the "
                    + "'" + getTextField().getText() + "'"
                    + " party.\nPlease enter another party.");
        else {
            int numberInParty = CongressConnector.getAnalyzerAccess().numberOfCongressMembersInParty(getTextField().getText());
            getOutput().setText("Number of Congress Members: " +  numberInParty);
        }
        });
    }

    public PieChart makePieChart() {
        int numDemocrat = CongressConnector.getAnalyzerAccess().numberOfCongressMembersInParty("democrat");
        int numRepublican = CongressConnector.getAnalyzerAccess().numberOfCongressMembersInParty("republican");
        int numIndependent = CongressConnector.getAnalyzerAccess().numberOfCongressMembersInParty("independent");
        PieChart.Data democratSection = new PieChart.Data("Democrat", numDemocrat);
        PieChart.Data republicanSection= new PieChart.Data("Republican", numRepublican);
        PieChart.Data independentSection = new PieChart.Data("Independent", numIndependent);
        pieChart.getData().addAll(democratSection, republicanSection, independentSection);
        return pieChart;
    }

    public void pieChartButtonClicked() {
        pieChartButton.setOnAction((ActionEvent actionEvent) -> {
            makePieChart();
            pieChartButton.setDisable(true); // to prevent multiple pie charts from appearing
        });
    }
}
