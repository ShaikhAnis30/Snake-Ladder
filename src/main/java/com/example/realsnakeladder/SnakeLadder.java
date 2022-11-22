package com.example.realsnakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class SnakeLadder extends Application {

    // 1st step -- creating tileSize, height, width also Group
    // single Box dimension
    public final int tilesize = 40;
    int height = 10;
    int width = 10;

    Group tileGroup = new Group();  // group is empty for now

    // 3rd Step -- added yLine
    int yLine = 430; // means I will go down that Y-axis upto point 430

    // 8th step
    int diceValue;

    // 7th step - variables for players
    Player playerOne , playerTwo; // two variables for 2 players // objects of player class

    //4th step
    Label randResult;


    // 9th step - setting game rules
    boolean gameStart = true , turnOnePlayer = true , turnTwoPlayer = false;

    public Pane createContent(){
        // 1st step -- creating pane and setting PrefSize
        Pane root = new Pane();
        root.setPrefSize(width*tilesize ,height*tilesize+80); // 80 for extra space for buttons
        root.getChildren().addAll(tileGroup); // by this we are filling the group
        // we are adding all as a child of root(Pane) , now inside Pane this group will be added


        // 2nd Step -- adding all tiles
        for (int i = 0; i < height; i++) {  // this is Y co-ordinate
            for (int j = 0; j < width; j++) {  // this is X co-ordinate
                Tile tile = new Tile(tilesize,tilesize); // created object of tile class -- call to tile constructor in tile class
                tile.setTranslateX(j*tilesize); // this will move in x direction - added tiles in X-axis
                tile.setTranslateY(i*tilesize); // this will move in y direction - added tiles in Y-axis
                tileGroup.getChildren().addAll(tile); // one by one all tiles will be added
            }
        }

        // 4th step - for Dice and positions of buttons
        // add Label
        randResult = new Label("  Start The Game");
        randResult.setTranslateX(150); // on x-axis "Start The Game" will be displayed at 150 position
        randResult.setTranslateY(yLine-20); // on y-axis



        // 3rd step - adding Buttons
        // add 3 Buttons
        Button playerOneButton = new Button("Player One");
//        playerOneButton.setTextFill(Color.PINK); // i can add color also
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(yLine); // 430
        // 9th step
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() { // making this button Functional
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart == true){
                    if(turnOnePlayer == true){
                        getDiceValue();
                        playerOne.movePlayer(diceValue);
                        playerOne.playerAtSnakeOrLadder();
                        turnOnePlayer = false;
                        turnTwoPlayer = true;
                    }
                }
            }
        });

        Button gameButton = new Button("Start Game");
        gameButton.setTranslateX(160);
        gameButton.setTranslateY(yLine);

        Button playerTwoButton = new Button("Player two");
        playerTwoButton.setTranslateX(300);
        playerTwoButton.setTranslateY(yLine);
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart == true){
                    if(turnTwoPlayer == true){
                        getDiceValue();
                        playerTwo.movePlayer(diceValue); // diceValue ko movePlayer function ke Sath use Kiya hai
                        playerTwo.playerAtSnakeOrLadder();
                        turnOnePlayer = true;
                        turnTwoPlayer = false;
                    }
                }
            }
        });


        // 7th step
        // Creating Players for the Game
        playerOne = new Player(tilesize , Color.BLACK); // created 1st player
        playerTwo = new Player(tilesize-10 , Color.WHITE); // 1st player se thoda chota rahega so -10

        // 3rd step - setting Image
        Image img = new Image("C:\\Users\\ASUS\\IdeaProjects\\RealSnakeLadder\\src\\SnakeLadderImage.jpg");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitHeight(height*tilesize);
        boardImage.setFitWidth(width*tilesize);

        // What all things we have to Display on the Screen(pane) we will put all the things in tileGroup
        tileGroup.getChildren().addAll(boardImage,playerOneButton, gameButton , playerTwoButton ,
                randResult , playerOne.getGamePiece(), playerTwo.getGamePiece());
                                     // playerOne and playerTwo will have all properties of GamePiece
                                    // i.e. why we have created GamePiece function in Player class


        return root;
    }

    // 8th step continue after translate player function
    private void getDiceValue(){
        // random will give random value 0 or 1 but in double
        diceValue = (int)(Math.random()*6+1);
        randResult.setText(Integer.toString(diceValue));
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Welcome To Snake&Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}