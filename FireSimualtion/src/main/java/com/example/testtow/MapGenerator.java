package com.example.testtow;

import com.example.testtow.Fire.FireControl;
import com.example.testtow.firetrucks.ControlRoom;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
/**
 * Klasa odpowiadającą za tworzenie całego tła aplikacji:
 * kolor tła, drogi, FireStation, przyciski, tekst,
 * ustawienie nazwy aplikacji
 */
public class MapGenerator {

    public static Button generateReport;
    EventHandler<ActionEvent> generateReportEvent = e -> {
        GenerateReport generateReport = new GenerateReport();
        generateReport.GenerateReport();
    };


    EventHandler<ActionEvent> turnWindEvent = e -> FireControl.windChange();

    Group root = new Group();
    public void MapGeneration(Stage primaryStage) {


        primaryStage.setTitle("FireSimulation");
        primaryStage.setResizable(false);

        //region UI
        Rectangle yellow = new Rectangle(650,50,20,20);
        yellow.setFill(Color.YELLOW);
        Text yellowText = new Text("- Light firetruck");
        yellowText.setX(680);
        yellowText.setY(64);

        Rectangle red = new Rectangle(650,100,20,20);
        red.setFill(Color.RED);
        Text redText = new Text("- Medium firetruck");
        redText.setX(680);
        redText.setY(114);

        Rectangle purple = new Rectangle(650,150,20,20);
        purple.setFill(Color.PURPLE);
        Text purpleText = new Text("- Heavy firetruck");
        purpleText.setX(680);
        purpleText.setY(164);

        generateReport = new Button("Generuj raport");
        generateReport.maxHeight(30);
        generateReport.maxWidth(100);
        generateReport.setLayoutX(650);
        generateReport.setLayoutY(550);
        generateReport.setDisable(true);
        generateReport.setOnAction(generateReportEvent);

        Button windOnTrue = new Button("Turn On/Off wind");
        windOnTrue.maxHeight(30);
        windOnTrue.maxWidth(100);
        windOnTrue.setLayoutX(650);
        windOnTrue.setLayoutY(450);
        windOnTrue.setOnAction(turnWindEvent);
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
        FireControl fireControl = new FireControl();

        //region display
        root.getChildren().addAll(line1, line2, line3, line4, line5, line6, FireStation, text1);
        root.getChildren().add(whiteRect);
        root.getChildren().addAll(yellow,yellowText,red,redText,purpleText,purple);
        root.getChildren().addAll(generateReport, windOnTrue);
        root.getChildren().add(fireControl.getWindText());
        //endregion
    }

    public Group getRoot() {
        return root;
    }
}
