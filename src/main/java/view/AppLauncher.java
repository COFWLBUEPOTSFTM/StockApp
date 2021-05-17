package view;

import model.ListOfStocks;
import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.util.List;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    List<Stock> stockList = ListOfStocks.create();

    Model model = new ModelImpl(stockList);
    Controller controller = new ControllerImpl(model);
    View view = new View(controller);

    Scene scene = new Scene(view.render());
    stage.setScene(scene);

    model.addObserver(
            new ModelObserver() {
              @Override
              public void update(Model model) {
                scene.setRoot(view.render());
                stage.sizeToScene();
              }
            }
    );

    stage.setTitle("Stocks");
    stage.show();
  }
}
