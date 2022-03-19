package com.userinterface;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class TabBuilder {

    private Label heading;
    private Label context1;
    private Label context2;
    private Button searchButton;
    private TextField textField1;
    private TextField textField2;
    private Label output;

    public TabBuilder(String heading, String context) {
        this.heading = new Label(heading);
        this.context1 = new Label(context);
        this.searchButton = new Button("Search");
        this.textField1 = new TextField();
        this.output = new Label();
    }
    public TabBuilder(String heading, String context1, String context2) {
        this.heading = new Label(heading);
        this.context1 = new Label(context1);
        this.context2 = new Label(context2);
        this.searchButton = new Button("Search");
        this.textField1 = new TextField();
        this.textField2 = new TextField();
        this.output = new Label();
    }

    public void addComponentsToWindow(VBox vBox) {
        vBox.getChildren().addAll(heading, context1, textField1, searchButton, output);
    }
    public void addAdditionalComponentsToWindow(VBox vBox) {
        vBox.getChildren().addAll(heading, context1, textField1, context2, textField2, searchButton, output);
    }

    public Label getHeading() {
        return heading;
    }
    public void setHeading(Label heading) {
        this.heading = heading;
    }

    public Label getContext1() {
        return context1;
    }
    public void setContext1(Label context1) {
        this.context1 = context1;
    }

    public Button getSearchButton() {
        return searchButton;
    }
    public void setSearchButton(Button searchButton) {
        this.searchButton = searchButton;
    }

    public TextField getTextField1() {
        return textField1;
    }
    public void setTextField1(TextField textField1) {
        this.textField1 = textField1;
    }

    public Label getOutput() {
        return output;
    }
    public void setOutput(Label output) {
        this.output = output;
    }

    public Label getContext2() {
        return context2;
    }
    public void setContext2(Label context2) {
        this.context2 = context2;
    }

    public TextField getTextField2() {
        return textField2;
    }
    public void setTextField2(TextField textField2) {
        this.textField2 = textField2;
    }
}
