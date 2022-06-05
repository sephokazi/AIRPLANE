package com.example.aeroplane;

import javafx.animation.*;
import javafx.application.Application;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    VBox box = new VBox();
    Label labelScore;
    Label command;


    //Duration
    Duration first= Duration.millis(12000);
    Duration second= Duration.millis(10000);
    Duration third= Duration.millis(8000);
    Duration fourth= Duration.millis(7000);
    Duration fifth= Duration.millis(5000);


    Duration one = Duration.millis(15000);
    Duration two = Duration.millis(17000);
    Duration three = Duration.millis(12000);
    Duration four = Duration.millis(20000);


    //Transition
    TranslateTransition FirstPoint = new TranslateTransition(one);
    TranslateTransition SecondPoint = new TranslateTransition(two);
    TranslateTransition ThirdPoint = new TranslateTransition(three);
    TranslateTransition FourthPoint = new TranslateTransition(four);



    TranslateTransition fly = new TranslateTransition(first);
    TranslateTransition fly1 = new TranslateTransition(second);
    TranslateTransition fly2 = new TranslateTransition(third);
    TranslateTransition fly3 = new TranslateTransition(fourth);
    TranslateTransition fly4 = new TranslateTransition(fifth);


    SequentialTransition st1;
    SequentialTransition st2;
    SequentialTransition st3;
    SequentialTransition st4;


    SequentialTransition seqT1;
    SequentialTransition seqT2;
    SequentialTransition seqT3;
    SequentialTransition seqT4;
    SequentialTransition seqT5;


    Rectangle reg1 = new Rectangle(200,100);
    String source = getClass().getResource("/Airplane.png").toExternalForm();
    Image image = new Image(source);
    ImageView imageView = new ImageView(image);


    Rectangle reg2 = new Rectangle(35,20);
    String source1 = getClass().getResource("/Coin.png").toExternalForm();
    Image point1 = new Image(source1);

    Rectangle rect3 = new Rectangle(35,20);
    String source2 = getClass().getResource("/Coin.png").toExternalForm();
    Image point2 = new Image(source2);

    Rectangle rect4 = new Rectangle(35,20);
    String source3 = getClass().getResource("/Coin.png").toExternalForm();
    Image point3 = new Image(source3);

    Rectangle rect5 = new Rectangle(35,20);
    String source4 = getClass().getResource("/Coin.png").toExternalForm();
    Image point4 = new Image(source4);

    // images for clouds
    Rectangle shape1 = new Rectangle(200,100);
    String source_1 = getClass().getResource("/Cloud.png").toExternalForm();
    Image image1 = new Image(source_1);


    Rectangle shape2 = new Rectangle(200,100);
    String source_2 = getClass().getResource("/Cloud.png").toExternalForm();
    Image image2 = new Image(source_2);


    Rectangle shape3 = new Rectangle(480,240);
    String source_3 = getClass().getResource("/Cloud.png").toExternalForm();
    Image image3 = new Image(source_3);

    Rectangle shape4 = new Rectangle(480,240);
    String source_4 = getClass().getResource("/Cloud.png").toExternalForm();
    Image image4 = new Image(source_4);

    Rectangle shape5 = new Rectangle(200,100);
    String source5 = getClass().getResource("/Cloud.png").toExternalForm();
    Image image5 = new Image(source5);

    //score
    int score;

    @Override
    public void start(Stage stage) {

        Pane root = new Pane();

        //clouds
        shape1.setFill(new ImagePattern(image1));
        shape5.setFill(new ImagePattern(image5));
        shape2.setFill(new ImagePattern(image2));
        shape3.setFill(new ImagePattern(image3));
        shape4.setFill(new ImagePattern(image4));

        //points for images
        reg2.setFill(new ImagePattern(point1));
        rect3.setFill(new ImagePattern(point2));
        rect4.setFill(new ImagePattern(point3));
        rect5.setFill(new ImagePattern(point4));


        //getting points
        FirstPoint .setToY(1800f);
        FirstPoint .setCycleCount(200);
        FirstPoint .setAutoReverse(false);
        st1 = new SequentialTransition (reg2, FirstPoint );


        SecondPoint.setToY(1800f);
        SecondPoint.setCycleCount(200);
        SecondPoint.setAutoReverse(false);
        st2 = new SequentialTransition (rect3, SecondPoint);


        ThirdPoint.setToY(1800f);
        ThirdPoint.setCycleCount(200);
        ThirdPoint.setAutoReverse(false);
        st3 = new SequentialTransition (rect4, ThirdPoint);


        FourthPoint.setToY(1800f);
        FourthPoint.setCycleCount(200);
        FourthPoint.setAutoReverse(false);
        st4 = new SequentialTransition (rect5, FourthPoint);


        fly.setToX(-1800f);
        fly.setCycleCount(200);
        fly.setAutoReverse(false);

        seqT1 = new SequentialTransition (shape1, fly);
        fly1.setToX(-1800f);
        fly1.setCycleCount(200);
        fly1.setAutoReverse(false);

        seqT2 = new SequentialTransition (shape2, fly1);
        fly2.setToX(-1800f);
        fly2.setCycleCount(200);
        fly2.setAutoReverse(false);

        seqT3 = new SequentialTransition (shape3, fly2);
        fly3.setToX(-1800f);
        fly3.setCycleCount(200);
        fly3.setAutoReverse(false);

        seqT4 = new SequentialTransition (shape4, fly3);
        fly4.setToX(-1800f);
        fly4.setCycleCount(200);
        fly4.setAutoReverse(false);
        seqT5 = new SequentialTransition (shape5, fly4);

        final Group group = new Group(createInstructions(),createScore(),box,shape2,shape3,shape4,reg2,rect3,rect4,rect5,root);


        shape1.setX(1200);
        shape1.setY(50);
        shape2.setX(1200);
        shape2.setY(400);
        shape3.setX(1200);
        shape3.setY(800);
        shape4.setX(1200);
        shape4.setY(500);
        shape5.setX(1200);
        shape5.setY(100);


        reg2.setX(800);
        reg2.setY(-50);
        rect3.setX(750);
        rect3.setY(-50);
        rect4.setX(600);
        rect4.setY(-50);
        rect5.setX(400);
        rect5.setY(-50);

        final Scene scene = new Scene(group,1300, 650);

        ImageView ship = createShip(scene);
        root.getChildren().addAll(reg1,shape1,shape2,shape3,shape4,shape5,labelScore);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = reg1.getX();
            double y = reg1.getY();

            if(event.getCode()==KeyCode.UP){
                reg1.setY(y-10);
            }
            else if(event.getCode()==KeyCode.DOWN){
                reg1.setY(y+10);
            }
            else if(event.getCode()==KeyCode.RIGHT){
                reg1.setX(x+10);
            }
            else if(event.getCode()==KeyCode.LEFT){
                reg1.setX(x-10);
            }
            else if(event.getCode()==KeyCode.ENTER){
                Play();
            }
            if(event.getCode() == KeyCode.SPACE){
                st1.pause();
                st2.pause();
                st3.pause();
                st4.pause();
                seqT1.pause();
                seqT2.pause();
                seqT2.pause();
                seqT3.pause();
                seqT4.pause();
                seqT5.pause();
            }
        });

        stage.setTitle("A I R P L A N E  G A M E!");
        stage.setScene(scene);
        stage.show();
    }


    public void Play(){
        st1.play();
        st2.play();
        st3.play();
        st4.play();
        seqT1.play();
        seqT2.play();
        seqT2.play();
        seqT3.play();
        seqT4.play();
        seqT5.play();

    }
    public void Pause(){
        st1.pause();
        st2.pause();
        st3.pause();
        st4.pause();
        seqT1.pause();
        seqT2.pause();
        seqT2.pause();
        seqT3.pause();
        seqT4.pause();
        seqT5.pause();

    }


    private ImageView createShip(Scene scene) {
        reg1.setFill(new ImagePattern(image));
        reg1.setX(100);
        reg1.setY(200);
        imageView.setFitWidth(140);
        imageView.setFitHeight(60);
        imageView.setY(scene.getHeight() - imageView.getFitHeight());

        return imageView;
    }
    private Label createInstructions() {
        command = new Label(
                "\n\tPRESS 'ENTER'!\n\tSCORE:"
        );

        command.setTextFill(Color.AQUA);
        command.setFont(Font.font("Arial", FontWeight.BOLD,20));
        return command;
    }
    private Label createScore() {
        score=0;

        labelScore = new Label();
        labelScore.setText(score+"");
        labelScore.setLayoutX(200);
        labelScore.setLayoutY(45);
        box.getChildren().add(labelScore);

        labelScore.setTextFill(Color.AQUA);
        labelScore.setFont(Font.font("Arial", FontWeight.BOLD,20));
        reg1.translateXProperty().addListener(observable -> {

        });
        shape1.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (reg1.getBoundsInParent().intersects(shape1.getBoundsInParent())){
                    String icon= getClass().getResource("/warning.jpg").toExternalForm();
                    Image imageB= new Image(icon);
                    reg1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape1.setOpacity(0.1);
                } else if (reg1.getBoundsInParent().intersects(shape2.getBoundsInParent())) {
                    String icon= getClass().getResource("/warning.jpg").toExternalForm();
                    Image imageJet= new Image(icon);
                    reg1.setFill(new ImagePattern(imageJet));
                    Pause();
                    shape2.setOpacity(0.1);
                } else if (reg1.getBoundsInParent().intersects(shape3.getBoundsInParent())) {
                    String icon= getClass().getResource("/warning.jpg").toExternalForm();
                    Image imageB= new Image(icon);
                    reg1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape3.setOpacity(0.1);
                } else if (reg1.getBoundsInParent().intersects(shape4.getBoundsInParent())) {
                    String icon= getClass().getResource("/warning.jpg").toExternalForm();
                    Image imageB= new Image(icon);
                    reg1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape4.setOpacity(0.1);
                }
                else if (reg1.getBoundsInParent().intersects(shape5.getBoundsInParent())) {
                    String icon= getClass().getResource("/warning.jpg").toExternalForm();
                    Image imageB= new Image(icon);
                    reg1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape5.setOpacity(0.1);
                }
                else if (reg1.getBoundsInParent().intersects(reg2.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
                else if (reg1.getBoundsInParent().intersects(rect3.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
                else if (reg1.getBoundsInParent().intersects(rect4.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
                else if (reg1.getBoundsInParent().intersects(rect5.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
            }
        });
        return labelScore;


    }

    public static void main(String[] args) {
        launch();
    }
}