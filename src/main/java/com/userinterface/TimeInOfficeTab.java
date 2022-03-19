package com.userinterface;

import com.congress.CongressConnector;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class TimeInOfficeTab extends TabBuilder implements ITab {
    private Tab timeInOfficeTab;
    private VBox timeInOfficeVBox;

    public TimeInOfficeTab() {
        super("Find the Congress Members with the Most Years in Office:", "Top N (sorted from most to least)");
        this.timeInOfficeTab = new Tab("TimeInOffice");
        this.timeInOfficeVBox = new VBox(10);
    }

    public Tab getTab() {
        return timeInOfficeTab;
    }

    public VBox getVBox(Tab tab) {
        ScrollPane scrollPane = new ScrollPane();
        tab.setContent(scrollPane);
        scrollPane.setContent(timeInOfficeVBox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        return timeInOfficeVBox;
    }
    public VBox getVBox() {
        return timeInOfficeVBox;
    }

    public void searchButtonClicked() {
        getSearchButton().setOnAction((ActionEvent actionEvent) -> {
            int timeTopNInt = Integer.parseInt(getTextField().getText());
            String tempResultTime = "";
            // Data validation
            if (timeTopNInt > CongressConnector.getCongressListSize())
                getOutput().setText("The number entered is greater than the number of Congress members.\nPlease enter a smaller number.");
            // Gathering and storing data to be displayed
            for (int i = 0; i < timeTopNInt; i++) {
                String congressPersonName = CongressConnector.getAnalyzerAccess().CongressPeopleTimeInOfficeSorted(timeTopNInt).get(i).getName();
                int congressPersonTimeInOffice = CongressConnector.getAnalyzerAccess().CongressPeopleTimeInOfficeSorted(timeTopNInt).get(i).getCongressMemberTimeInOffice();
                tempResultTime = tempResultTime + "\n" + congressPersonName + " -- " + congressPersonTimeInOffice;
            }
            getOutput().setText(tempResultTime);
        });
    }
}
