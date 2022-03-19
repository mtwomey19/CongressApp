package com.userinterface;

import com.congress.CongressConnector;
import com.congress.CongressMember;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

import java.util.List;

public class AgeWindow extends TabBuilder {
    private Tab ageTab;
    private VBox ageVBox;

    public AgeWindow() {
        super("Find the Oldest Members of Congress:", "Top N (sorted from oldest to youngest)");
        this.ageTab = new Tab("Age");
        this.ageVBox = new VBox(10);
    }

    public Tab getTab() {
        return ageTab;
    }
    public VBox getVBox(Tab tab) {
        ScrollPane scrollPane = new ScrollPane();
        tab.setContent(scrollPane);
        scrollPane.setContent(ageVBox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        return ageVBox;
    }
    public VBox getVBox() {
        return ageVBox;
    }

    public void searchButtonClicked() {
        getSearchButton().setOnAction((ActionEvent actionEvent) -> {
            int ageTopN = Integer.parseInt(getTextField1().getText());

            if (ageTopN > CongressConnector.getCongressListSize())
                getOutput().setText("The number entered is greater than the number of Congress members.\nPlease enter a smaller number.");

            // Pulling topN oldest Congress members from the oldestCongressPeople method located in the CongressFinder class
            String formattedOutput = "";
            List<CongressMember> oldestCongressPeople = CongressConnector.getAnalyzerAccess().oldestCongressMembers(ageTopN);
            for (int i = 0; i < ageTopN; i++) {
                String congressMemberName = oldestCongressPeople.get(i).getName();
                int congressMemberAge = oldestCongressPeople.get(i).getCongressMemberAge();
                formattedOutput = formattedOutput + "\n" + congressMemberName + " -- " + congressMemberAge;
            }
            getOutput().setText(formattedOutput);
        });
    }
}