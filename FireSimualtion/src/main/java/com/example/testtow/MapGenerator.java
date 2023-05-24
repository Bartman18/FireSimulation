package com.example.testtow;

import com.example.testtow.Fire.FireControl;
import com.example.testtow.firetrucks.ControlRoom;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MapGenerator {


    EventHandler<ActionEvent> generateReportEvent = e -> GenerateReport.GenerateReport();
    EventHandler<ActionEvent> turnWindEvent = e -> FireControl.windChange();
    //EventHandler<ActionEvent> restartEvent = e -> HelloApplication.start();
    public void MapGeneration(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root,800, 600, Color.GREEN);

        primaryStage.setTitle("FireSimulation");
        primaryStage.setResizable(false);

        //region UI
        Button generateReport = new Button("Generate losowe błędy");
        generateReport.maxHeight(30);
        generateReport.maxWidth(100);
        generateReport.setLayoutX(650);
        generateReport.setLayoutY(550);
        generateReport.setOnAction(generateReportEvent);

        Button windOnTrue = new Button("Turn On/Off wind");
        windOnTrue.maxHeight(30);
        windOnTrue.maxWidth(100);
        windOnTrue.setLayoutX(650);
        windOnTrue.setLayoutY(450);
        windOnTrue.setOnAction(turnWindEvent);

        /*Button restart = new Button("restart");
        restart.maxHeight(30);
        restart.maxWidth(100);
        restart.setLayoutX(650);
        restart.setLayoutY(350);
        windOnTrue.setOnAction(restartEvent);*/

        //endregion

        //region lines
        Line line1 = new Line();
        line1.setStartX(0);
        line1.setStartY(300);
        line1.setEndX(600);
        line1.setEndY(300);
        line1.setStrokeWidth(10);

        Line line2 = new Line();
        line2.setStartX(300);
        line2.setStartY(0);
        line2.setEndX(300);
        line2.setEndY(600);
        line2.setStrokeWidth(10);

        Line line3 = new Line();
        line3.setStartX(150);
        line3.setStartY(200);
        line3.setEndX(150);
        line3.setEndY(300);
        line3.setStrokeWidth(5);

        Line line4 = new Line();
        line4.setStartX(200);
        line4.setStartY(500);
        line4.setEndX(300);
        line4.setEndY(500);
        line4.setStrokeWidth(5);

        Line line5 = new Line();
        line5.setStartX(300);
        line5.setStartY(150);
        line5.setEndX(400);
        line5.setEndY(150);
        line5.setStrokeWidth(5);

        Line line6 = new Line();
        line6.setStartX(300);
        line6.setStartY(400);
        line6.setEndX(400);
        line6.setEndY(400);
        line6.setStrokeWidth(5);
        //endregion

        //region firestation
        Rectangle FireStation = new Rectangle(100,50,Color.RED);
        FireStation.setY(250);
        FireStation.setX(500);

        Text text1 = new Text("FIRE STATION");
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        text1.setFill(Color.BLACK);
        text1.setTextAlignment(TextAlignment.CENTER);
        text1.setWrappingWidth(FireStation.getWidth() + 15);
        text1.setX(FireStation.getX() );
        text1.setY(FireStation.getY() + FireStation.getHeight() / 2 + text1.getBoundsInLocal().getHeight() / 2);
        //endregion

        //region right panel
        Rectangle whiteRect = new Rectangle(600, 0, 200, 600);
        whiteRect.setFill(Color.WHITE);
        //endregion

        //region fires
        FireControl fireControl = new FireControl();
        Rectangle fire0 = fireControl.getFire0();
        Rectangle fire1 = fireControl.getFire1();
        Rectangle fire2 = fireControl.getFire2();
        Rectangle fire3 = fireControl.getFire3();
        //endregion

        //region control room
        ControlRoom controlRoom = new ControlRoom();
        Rectangle rect;
        rect = controlRoom.RightUpper();
        //endregion

        //region display
        root.getChildren().addAll(line1, line2, line3, line4, line5, line6, FireStation, text1);
        root.getChildren().add(whiteRect);
        root.getChildren().addAll(fire0, fire1, fire2, fire3);
        root.getChildren().addAll(generateReport, windOnTrue);

        root.getChildren().add(fireControl.getWindText());
        root.getChildren().add(rect);
        primaryStage.setScene(scene);
        primaryStage.show();
        //endregion
    }
}
