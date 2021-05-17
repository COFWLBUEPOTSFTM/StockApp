package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class OwnedView implements FxComponent{
    private final Controller controller;

    public OwnedView(Controller controller){
        this.controller = controller;
    }

    @Override
    public Parent render() {
        VBox ownedView = new VBox();
        ownedView.setPadding(new Insets(20, 20,20,20));
        VBox titlePane = new VBox();
        titlePane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY,Insets.EMPTY)));
        titlePane.setAlignment(Pos.CENTER);
        Text title = new Text();
        title.setText("Stocks Bought");
        title.setFont(new Font(20));
        title.setFill(Color.WHITE);
        titlePane.getChildren().add(title);
        ScrollPane scrollPane = new ScrollPane();
        ownedView.getChildren().add(titlePane);
        ownedView.getChildren().add(scrollPane);
        return ownedView;
    }
}
