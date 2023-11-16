package com.example.lab7;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasDrawingApp extends Application {

    private static final double DEFAULT_ERASER_SIZE = 10.0;

    public static void main(String[] args) {
        launch(args);
    }

    //Сбрасывает холст в его первоначальный вид, заполняя полотно
    private void reset(Canvas canvas, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PaintApp");

        // Передний фон
        final Canvas canvas = new Canvas(500, 500);
        reset(canvas, Color.BURLYWOOD);

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // Ползунок для выбора размера удаляющей кисти
        Slider eraserSizeSlider = new Slider(1, 50, DEFAULT_ERASER_SIZE);
        Label eraserSizeLabel = new Label("Eraser Size:");

        // Обработчик изменения значения ползунка
        eraserSizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // Обновляем метку с размером кисти
                eraserSizeLabel.setText("Eraser Size: " + String.format("%.1f", newValue));
            }
        });

        // Удаление переднего фона при нажатии ЛКМ и перемещении по холсту
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                double eraserSize = eraserSizeSlider.getValue();
                gc.clearRect(e.getX() - eraserSize / 2, e.getY() - eraserSize / 2, eraserSize, eraserSize);
            }
        });

        // Возвращение переднего фона при тройном клике
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (t.getClickCount() == 3) {
                    reset(canvas, Color.BURLYWOOD);
                }
            }
        });

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(eraserSizeSlider);
        root.setTop(eraserSizeLabel);

        // Добавление холста и ползунка к сцене
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}
