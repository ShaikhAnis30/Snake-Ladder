package com.example.realsnakeladder;

public class GameBoard {
    static int tileSize = 40;
    static int height = 10;
    static int width = 10;

    // i will insert all the coordinates of my player into ArrayList , ALl 100 values
    static ArrayList<Pair<Integer,Integer>> positionCoordinates;

    public int getXValue(int piecePosition){
        return positionCoordinates.get(piecePosition).getKey();
    }

    public int getYValue(int piecePosition){
        return positionCoordinates.get(piecePosition).getValue();
    }


    private static void populatePositionCoordinates(){
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<Integer,Integer>(20,380));
        // initial pos 20,380
        int xTilePos , yTilePos;
        for(int i = height-1; i>=0; i--){
            for(int j = width-1; j>=0; j--){
                if(i%2 == 0){  // odd row
                    xTilePos = tileSize*width - (tileSize/2 + j*tileSize); // position of x coordinate
                }else{ // even row
                    xTilePos = tileSize/2 + j*tileSize;
                }

                yTilePos = tileSize/2 + j*tileSize; // position of y coordinate
                positionCoordinates.add(new Pair<Integer,Integer>(xTilePos,yTilePos));
                // added all coordinates into ArrayList in the form of pair
            }
        }

        for(int i=0;i<positionCoordinates.size();i++){
            System.out.println(i + "X : " + positionCoordinates.get(i).getKey() + "Y : " +
                    positionCoordinates.get(i).getValue());
        }
    }
}
