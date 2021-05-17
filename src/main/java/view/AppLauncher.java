package view;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import model.ModelImpl;
import model.ModelObserver;
import model.StockImpl;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage){
    StockImpl.createAll();

    Model model = new ModelImpl();
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
