package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, 1024, 768);

        Canvas graphingCanvas = new Canvas();
        graphingCanvas.setWidth(1024);
        graphingCanvas.setHeight(700);

        GraphicsContext gc = graphingCanvas.getGraphicsContext2D();
        //background
        gc.setFill(Color.LIGHTYELLOW);
        gc.fillRect(0, 0, 1024, 730);
        //grid lines
        int centerGraphX = 1024 / 2;
        int centerGraphY = 730 / 2;
        gc.setStroke(Color.BLACK);
        gc.strokeLine(centerGraphX, 0, centerGraphX, 730);
        gc.strokeLine(0, centerGraphY, 1024, centerGraphY);

        Label equationLabel = new Label("Equation: ");
        equationLabel.setTranslateY(730);

        TextField equationField = new TextField("1 + 2");
        equationField.setTranslateX(100);
        equationField.setTranslateY(730);

        Button graphButton = new Button("Graph!");
        graphButton.setTranslateX(300);
        graphButton.setTranslateY(730);

        graphButton.setOnAction( e -> {
            Controller.DoThing();
        });

        root.getChildren().addAll(equationLabel, equationField, graphButton, graphingCanvas);

        primaryStage.setTitle("Hello World");
        primaryStage.setTitle("Java Crema - Graphing Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
