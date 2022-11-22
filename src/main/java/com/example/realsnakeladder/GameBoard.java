package com.example.realsnakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

// 5th step - this function is to add all the x,y coordinates into ArrayList
public class GameBoard {
    static int tileSize = 40;
    static int height = 10;
    static int width = 10;

    // I will insert all the coordinates of my player into ArrayList , ALl 100 values
    static ArrayList<Pair<Integer,Integer>> positionCoordinates;


    // 10th step for snakes and ladders
    static ArrayList<Integer> snakeLadderPosition;


    // 6th step
    public GameBoard(){ // without this it will throw error of null coordinate
        // it initialise all values, so that we don't get null coordinates error
        populatePositionCoordinates();
        setPositionCoordinates();
    }

    // 6th step - from line 19 from player class we come here
    public int getXValue(int piecePosition){
        return positionCoordinates.get(piecePosition).getKey(); // keys will be values of XPosition
    }

    public int getYValue(int piecePosition){
        return positionCoordinates.get(piecePosition).getValue(); // Values will be values of YPosition
    }


    // 10th step
    public int playerPositionAtSnakeOrLadder(int piecePosition){
        if(piecePosition != snakeLadderPosition.get(piecePosition)){
            return snakeLadderPosition.get(piecePosition);
        }
        return -1;
    }

    // 5th step - filled ArrayList by this Function
    private static void populatePositionCoordinates(){
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<Integer,Integer>(20,380)); // first position of players
        // initial pos 20,380

        int xTilePos , yTilePos;
        for(int i = height-1; i>=0; i--){
            for(int j = width-1; j>=0; j--){
                if(i%2 != 0){  // odd row
                    xTilePos = tileSize*width - (tileSize/2 + j*tileSize); // position of x coordinate
                }else{ // even row
                    xTilePos = tileSize/2 + j*tileSize;
                }

                yTilePos = tileSize/2 + i*tileSize; // position of y coordinate
                positionCoordinates.add(new Pair<Integer,Integer>(xTilePos,yTilePos));
                // added all coordinates into ArrayList in the form of pair
            }
        }

//        for(int i=0;i<positionCoordinates.size();i++){ // printed all the coordinates
//            System.out.println(i + " X : " + positionCoordinates.get(i).getKey() + " Y : " +
//                    positionCoordinates.get(i).getValue());
//        }
    }

    // 10th step
    private void setPositionCoordinates(){
        snakeLadderPosition = new ArrayList<>();
        for(int i=0; i<101; i++){
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(4,25); // using set we are mapping
        snakeLadderPosition.set(13,46);
        snakeLadderPosition.set(27,5);
        snakeLadderPosition.set(33,49);
        snakeLadderPosition.set(40,3);
        snakeLadderPosition.set(42,63);
        snakeLadderPosition.set(43,18);
        snakeLadderPosition.set(50,69);
        snakeLadderPosition.set(54,31);
        snakeLadderPosition.set(62,81);
        snakeLadderPosition.set(66,45);
        snakeLadderPosition.set(74,92);
        snakeLadderPosition.set(76,58);
        snakeLadderPosition.set(89,53);
        snakeLadderPosition.set(99,41);
    }

//    public static void main(String[] args) {
//        for(int i=0; i<100; i++){
//            System.out.println(Math.random()*6 + " # " + (int)(Math.random()*6+1));
//        }
//    }
//    public static void main(String[] args) {
//        populatePositionCoordinates();
//    }
}
