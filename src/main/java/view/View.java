package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Stock;

import java.util.List;

public class View implements FxComponent {
  private final Controller controller;

  public View(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox mainLayout = new HBox();
    SelectView selectView = new SelectView(controller);
    mainLayout.getChildren().add(selectView.render());
    return mainLayout;
  }
}
