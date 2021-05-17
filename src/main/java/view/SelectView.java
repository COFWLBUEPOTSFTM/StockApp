package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SelectView implements  FxComponent{
    private final Controller controller;

    public SelectView(Controller controller){
        this.controller = controller;
    }

    @Override
    public Parent render() {
        VBox selectView = new VBox();
        selectView.setPadding(new Insets(20, 20, 20, 20));
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("Test", "Test2");
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
        selectView.getChildren().add(buyPrice);
        selectView.getChildren().add(amount);
        selectView.getChildren().add(gain);
        return selectView;
    }
}
