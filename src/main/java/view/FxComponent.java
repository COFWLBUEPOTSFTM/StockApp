package view;

import javafx.scene.Parent;

import java.io.IOException;

public interface FxComponent {
  Parent render() throws IOException;
}
