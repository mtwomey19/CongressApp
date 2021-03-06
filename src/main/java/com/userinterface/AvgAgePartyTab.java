package com.userinterface;

import com.congress.CongressConnector;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import java.util.List;

public class AvgAgePartyTab extends TabBuilder implements ITab {
    private Tab avgAgePartyTab;
    private VBox avgAgePartyVBox;

    public AvgAgePartyTab() {
        super("Find Average Age by Party:", "Party (Democrat, Republican, Independent)");
        this.avgAgePartyTab = new Tab("AvgAgeParty");
        this.avgAgePartyVBox = new VBox(10);
    }

    public Tab getTab() {
        return avgAgePartyTab;
    }
    // adds scroll bar to tab
    public VBox getVBox(Tab tab) {
        ScrollPane scrollPane = new ScrollPane();
        tab.setContent(scrollPane);
        scrollPane.setContent(avgAgePartyVBox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        return avgAgePartyVBox;
    }
    public VBox getVBox() {
        return avgAgePartyVBox;
    }

    public void searchButtonClicked() {
        getSearchButton().setOnAction((ActionEvent actionEvent) -> {
            setTextAvgAgeParty();
        });
    }

    private void setTextAvgAgeParty() {
        String input = getTextField().getText().toLowerCase();
        String avgAge;
        // retrieving average age for party user enters
        List<String> parties = List.of("democrat", "republican", "independent");
        if (parties.contains(input)) {
            input = input.substring(0, 1).toUpperCase() + input.substring(1);
            avgAge = CongressConnector.getAnalyzerAccess().averageAgeByParty().get(input).toString();
            getOutput().setText("Average Age of Party -- " + avgAge);
        }
        else {
            getOutput().setText("There is no member of Congress that is part of the "
                    + "'" + getTextField().getText() + "'" + " party."
                    + "\nPlease enter another party.");
        }
    }
}