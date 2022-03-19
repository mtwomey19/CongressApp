package com.userinterface;

import com.congress.CongressConnector;
import com.congress.CongressMember;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class NameWindow extends TabBuilder {

    private final Tab name;
    private final VBox nameVBox;

    public NameWindow() {
        super("Find a Member of Congress by Name:", "First Name:", "Last Name:");
        this.name = new Tab("Name");
        this.nameVBox = new VBox(10);
    }

    public Tab getTab() {
        return name;
    }
    public VBox getVBox(Tab tab) {
        ScrollPane scrollPane = new ScrollPane();
        tab.setContent(scrollPane);
        scrollPane.setContent(nameVBox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        return nameVBox;
    }
    public VBox getVBox() {
        return nameVBox;
    }
    public void searchButtonClicked() {
        getSearchButton().setOnAction((ActionEvent actionEvent) -> {
            CongressMember congressMember = CongressConnector.getAnalyzerAccess().findCongressMemberByName(
                    getTextField1().getText(), getTextField2().getText());
            if (congressMember != null)
                getOutput().setText(congressMember.toString());
            else
                getOutput().setText("Could not find a member of Congress with that name. Please try again.");
        });
    }
}
