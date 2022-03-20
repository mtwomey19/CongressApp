package com.userinterface;

import com.congress.CongressConnector;
import com.congress.CongressMember;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NameTab extends TabBuilder implements ITab {

    private final Tab name;
    private final VBox nameVBox;
    private Label firstName;
    private Label lastName;
    private TextField firstNameTextField;
    private TextField lastNameTextField;

    public NameTab() {
        super("Find a Member of Congress by Name:");
        this.name = new Tab("Name");
        this.nameVBox = new VBox(10);
        this.firstName = new Label("First Name:");
        this.lastName = new Label("Last Name:");
        this.firstNameTextField = new TextField();
        this.lastNameTextField = new TextField();
    }

    public Tab getTab() {
        return name;
    }
    // adds scroll bar to tab
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
                    firstNameTextField.getText(), lastNameTextField.getText());
            if (congressMember != null)
                getOutput().setText(congressMember.toString());
            else
                getOutput().setText("Could not find a member of Congress with that name. Please try again.");
        });
    }

    @Override
    public void addComponentsToTab(VBox vBox) {
        vBox.getChildren().addAll(getHeading(), firstName, firstNameTextField, lastName,lastNameTextField, getSearchButton(), getOutput());
    }
}
