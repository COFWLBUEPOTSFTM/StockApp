package view;

import controller.Controller;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SelectView implements FxComponent{
    private final Controller controller;

    public SelectView(Controller controller){
        this.controller = controller;
    }

    @Override
    public Parent render() {
        VBox selectView = new VBox();
        selectView.setPadding(new Insets(20, 20, 20, 20));
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setEditable(true);

        CheckBox checkOwned = new CheckBox("Owned");
        boolean isSelected = checkOwned.isSelected();

        ObservableList<String> items = FXCollections.observableArrayList("AMC", "GME", "SNAP", "APPL");

        FilteredList<String> filteredItems = new FilteredList<>(items, p -> true);
        comboBox.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            final TextField editor = comboBox.getEditor();
            final String selected = comboBox.getSelectionModel().getSelectedItem();
            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                    filteredItems.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });
        });
        comboBox.setItems(filteredItems);

        Text buyPrice = new Text("Buy Price: ");
        Text amount = new Text("Amount: ");
        Text gain = new Text ("Gain: ");

        comboBox.setOnAction((event) -> {

            int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = comboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   ComboBox.getValue(): " + comboBox.getValue());
        });

        selectView.getChildren().add(comboBox);
        selectView.getChildren().add(checkOwned);
        selectView.getChildren().add(buyPrice);
        selectView.getChildren().add(amount);
        selectView.getChildren().add(gain);

        return selectView;
    }
}
