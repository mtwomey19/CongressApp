package com.userinterface;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class TabBuilder {

    private Label heading;
    private Label prompt;
    private Button searchButton;
    private TextField textField;
    private Label output;

    public TabBuilder(String heading, String context) {
        this.heading = new Label(heading);
        this.prompt = new Label(context);
        this.searchButton = new Button("Search");
        this.textField = new TextField();
        this.output = new Label();
    }
    // used when multiple prompts/labels are needed...see NameTab for usage
    public TabBuilder(String heading) {
        this.heading = new Label(heading);
        this.searchButton = new Button("Search");
        this.output = new Label();
    }

    public void addComponentsToTab(VBox vBox) {
        vBox.getChildren().addAll(heading, prompt, textField, searchButton, output);
    }

    public Label getHeading() {
        return heading;
    }
    public void setHeading(Label heading) {
        this.heading = heading;
    }

    public Label getPrompt() {
        return prompt;
    }
    public void setPrompt(Label prompt) {
        this.prompt = prompt;
    }

    public Button getSearchButton() {
        return searchButton;
    }
    public void setSearchButton(Button searchButton) {
        this.searchButton = searchButton;
    }

    public TextField getTextField() {
        return textField;
    }
    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public Label getOutput() {
        return output;
    }
    public void setOutput(Label output) {
        this.output = output;
    }
}
