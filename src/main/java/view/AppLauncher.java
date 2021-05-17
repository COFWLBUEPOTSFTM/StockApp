package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.StockImpl;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage){
    StockImpl.createAll();
  }
}
