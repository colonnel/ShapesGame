package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {
    private static int CANVAS_X = 1000;
    private static int CANVAS_Y = 600;
    GraphicsContext gc;
    Scene scene;
    private int size = 50;
    private double x = 10;
    private double y = 10;
    private int index;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("-=Shapes=-");
        BorderPane group = new BorderPane();
        Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        scene = new Scene(group);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        group.setCenter(canvas);
        primaryStage.show();

        //First line
        drawFillCircle(1);
        drawCircle(1);
        drawFillRectangle(2);
        drawRectangle(3);
        drawFillTriangle(4);
        drawTriangle(5);

        //Second line
        drawZ();
        drawHourglass();
        drawStroke(2);
        drawPackman(3);
        packmanEye();


    }

    private int indexByOrder() {
        if (index <= 2) {
            index = 1;
            return index;
        }
        return index - 1;


    }

    private double spaceX() {
        double x = size * 2;
        return x;
    }

    private double spaceY() {
        double y = size * 2;
        return y;
    }

    public void drawFillCircle(int index) {
        gc.setFill(Color.TOMATO);
        gc.fillOval(x, y, size, size);
    }

    public void drawCircle(int index) {
        gc.strokeOval(spaceX() * index, y, size, size);
    }

    public void drawRectangle(int index) {
        gc.strokeRect(spaceX() * index, y, size, size);
    }

    public void drawFillRectangle(int index) {
        gc.setFill(Color.BLANCHEDALMOND);
        gc.fillRect(spaceX() * index, y, size, size);
    }

    public void drawFillTriangle(int index) {
        gc.setFill(Color.DARKGREEN);
        gc.fillPolygon(new double[]{spaceX() * index, spaceX() * index + size, spaceX() * index + size / 2},
                new double[]{y + size, y + size, y}, 3);
    }

    public void drawTriangle(int index) {

        gc.strokePolygon(new double[]{spaceX() * index, spaceX() * index + size, spaceX() * index + size / 2},
                new double[]{y + size, y + size, y}, 3);
    }

    public void drawZ() {
        gc.setFill(Color.BLACK);
        gc.strokePolyline(new double[]{x, x + size, x, x + size},
                new double[]{spaceY(), spaceY(), spaceY() + size, spaceY() + size}, 4);

    }

    public void drawHourglass() {
        gc.fillPolygon(new double[]{spaceX(), spaceX() + size, spaceX() + size / 2, spaceX(), spaceX() + size},
                new double[]{spaceY(), spaceY(), spaceY() + size / 2, spaceY() + size, spaceY() + size}, 5);
    }

    public void drawStroke(int index) {
        gc.strokeLine(spaceX() * index, spaceY(), spaceX() * index + size, spaceY() + size);

    }

    public void drawPackman(int index) {
        gc.setFill(Color.DEEPSKYBLUE);
        gc.fillArc(spaceX() * index, spaceY(), size, size, 30, 300, ArcType.ROUND);
    }

    public void packmanEye(){
        gc.setFill(Color.BLACK);
        gc.fillOval(325, 107, 5, 5);
    }

    public static void main(String[] args) {
        launch(args);
    }
}