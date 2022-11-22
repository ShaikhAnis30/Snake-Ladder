package com.example.realsnakeladder;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

// 6th step
public class Player {
    private Circle gamePiece;
    int xPosition;
    int yPosition;
    int currentPiecePosition; // means on GameBoard where our player is Standing

    static GameBoard gameBoard = new GameBoard();

    Player(int tileSize , Color pieceColor){
        this.currentPiecePosition = 1; // piece will start moving from 1
        this.xPosition = gameBoard.getXValue(currentPiecePosition); // from here we created getXValue and getYValue functions
        this.yPosition = gameBoard.getYValue(currentPiecePosition);

        // Specifications of GamePiece
        gamePiece = new Circle(tileSize/2); // radius of gamePiece circle - it takes radius
        gamePiece.setFill(pieceColor);
        // we have set xPosition & yPosition in 19 & 20 th line
        gamePiece.setTranslateX(xPosition); // when moving in X-axis gamePiece will have xPosition
        gamePiece.setTranslateY(yPosition); // when moving in Y-axis gamePiece will have yPosition

    }

    // 8th step - Moving our players
    // Setting Dice Value
    public void movePlayer(int diceValue){
        // means if I am at 96 position so if I get 6 on dice
        // then 96+6 will exceed my board So we will not do anything in this case
        if(currentPiecePosition + diceValue <= 100){
            currentPiecePosition += diceValue;
            translateplayer();
        }
    }

    // Now We will Move the Player
    private void translateplayer(){
        this.xPosition = gameBoard.getXValue(this.currentPiecePosition); // again taken x and coordinates
        this.yPosition = gameBoard.getYValue(this.currentPiecePosition);

        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),this.gamePiece);
        animate.setToX(this.xPosition);
        animate.setToY(this.yPosition);
        animate.setAutoReverse(false);
        animate.play();

//        gamePiece.setTranslateX(this.xPosition);
//        gamePiece.setTranslateY(this.yPosition);

    }


    // 11th step - this will take playerPositionAtSnakeOrLadder from fn
    public void playerAtSnakeOrLadder(){
        int newPosition = gameBoard.playerPositionAtSnakeOrLadder(this.currentPiecePosition);
        if(newPosition != -1){
            this.currentPiecePosition = newPosition;
            translateplayer();
        }
    }

    // 6th step
    public Circle getGamePiece(){ // this is called in SnakeLadder when adding into Group
        return this.gamePiece;
        // this will return gamePiece so that I can put it on the board
        // when we will create a player we will need this gamePiece
    }
}
