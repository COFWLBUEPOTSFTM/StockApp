package view;

import controller.Controller;
import javafx.scene.Parent;

public class View implements FxComponent {
  private final Controller controller;

  public View(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    return null;
  }
}
