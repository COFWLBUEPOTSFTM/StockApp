package view;

import controller.Controller;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.ListOfStocks;
import model.Stock;

import java.io.IOException;

public class SelectView implements FxComponent{
    private final Controller controller;

    public SelectView(Controller controller){
        this.controller = controller;
    }

    @Override
    public Parent render(){
        VBox selectView = new VBox();
        selectView.setPadding(new Insets(20, 20, 20, 20));
        ComboBox<Stock> comboBox = new ComboBox<>();
        comboBox.setEditable(true);

        CheckBox checkOwned = new CheckBox("Owned");
        boolean isSelected = checkOwned.isSelected();

        comboBox.setItems(FXCollections.observableList(controller.displayedStocks()));
        comboBox.getSelectionModel().selectFirst();

           comboBox.setCellFactory(new Callback<ListView<Stock>,ListCell<Stock>>(){
                @Override
                public ListCell<Stock> call(ListView<Stock> l){
                    return new ListCell<Stock>(){
                        @Override
                        protected void updateItem(Stock item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText(item.getCompany());
                            }
                        }
                    } ;
                }
            });

        Text buyPrice = new Text("Buy Price: ");
        Text amount = new Text("Amount: ");
        Text profit = new Text ("Profit: "+ controller.getProfit());

        comboBox.setOnAction((event) -> {
            Stock selectedItem = comboBox.getSelectionModel().getSelectedItem();
            buyPrice.setText("Buy Price: " + selectedItem.getCurrentPrice());
            amount.setText("Amount: " + selectedItem.getAmountInvested());
        });

        selectView.getChildren().add(comboBox);
        selectView.getChildren().add(checkOwned);
        selectView.getChildren().add(buyPrice);
        selectView.getChildren().add(amount);
        selectView.getChildren().add(profit);

        return selectView;
    }
}
